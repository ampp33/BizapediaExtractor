package org.malibu.msu.bizapedia.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.filechooser.FileFilter;

import org.malibu.msu.bizapedia.BizapediaReportSpreadsheet;
import org.malibu.msu.bizapedia.ws.BizapediaBatchCallback;
import org.malibu.msu.bizapedia.ws.BizapediaBatchService;

import https.www_bizapedia.Company;
import https.www_bizapedia.Principal;

public class BizapediaExtractorUi {

	private JFrame frmLdxSimulationData;
	private JTextField apiKeyField;
	private JLabel statusLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					BizapediaExtractorUi window = new BizapediaExtractorUi();
					window.frmLdxSimulationData.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BizapediaExtractorUi() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLdxSimulationData = new JFrame();
		frmLdxSimulationData.setTitle("Bizapedia Extractor v1.0");
		frmLdxSimulationData.setResizable(false);
		frmLdxSimulationData.setBounds(100, 100, 415, 118);
		frmLdxSimulationData.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLdxSimulationData.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Api Key:");
		lblUsername.setBounds(10, 42, 70, 14);
		frmLdxSimulationData.getContentPane().add(lblUsername);
		
		apiKeyField = new JTextField();
		apiKeyField.setBounds(90, 39, 194, 20);
		frmLdxSimulationData.getContentPane().add(apiKeyField);
		apiKeyField.setColumns(10);
		
		JButton runButton = new JButton("Run");
		runButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread(new Runnable() {
					public void run() {
						// prompt for input file path
						JFileChooser inputFileChooser = new JFileChooser();
						inputFileChooser.setFileFilter(new FileFilter() {
							public String getDescription() { return null; }
							public boolean accept(File f) { return f.getName().toLowerCase().endsWith(".txt"); }
						});
						int choice = inputFileChooser.showSaveDialog(frmLdxSimulationData);
						if(choice != JFileChooser.APPROVE_OPTION) {
							// halt processing if they don't select a file
							return;
						}
						
						// prompt for output file path
						JFileChooser outputFileChooser = new JFileChooser();
						outputFileChooser.setSelectedFile(new File("output.xlsx"));
						choice = outputFileChooser.showSaveDialog(frmLdxSimulationData);
						if(choice != JFileChooser.APPROVE_OPTION) {
							// halt processing if they don't select a file
							return;
						}
						
						// process
						BizapediaProcessorConfig config
								= new BizapediaProcessorConfig(inputFileChooser.getSelectedFile().getAbsolutePath(),
																outputFileChooser.getSelectedFile().getAbsolutePath(),
																apiKeyField.getText());
						boolean success = runExtraction(config);
						if(success) {
							updateStatus("Done! Success!");
							JOptionPane.showMessageDialog(frmLdxSimulationData, "Success!");
						} else {
							JOptionPane.showMessageDialog(frmLdxSimulationData, "An error occurred during processing");
						}
					}
				}).start();
			}
		});
		runButton.setBounds(304, 38, 89, 23);
		frmLdxSimulationData.getContentPane().add(runButton);
		
		statusLabel = new JLabel("<status>");
		statusLabel.setBounds(10, 67, 389, 14);
		frmLdxSimulationData.getContentPane().add(statusLabel);
		
		JLabel lblNewLabel = new JLabel("Bizapedia Extractor");
		lblNewLabel.setForeground(new Color(255, 140, 0));
		lblNewLabel.setFont(new Font("Ubuntu", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 0, 342, 33);
		frmLdxSimulationData.getContentPane().add(lblNewLabel);
		
		JLabel lblV = new JLabel("v1.0");
		lblV.setBounds(199, 17, 46, 14);
		frmLdxSimulationData.getContentPane().add(lblV);
	}
	
	private boolean runExtraction(BizapediaProcessorConfig config) {
		updateStatus("Loading input list...");
		List<String> companies = new LinkedList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(new File(config.getInputFilePath())))) {
			String line = null;
			while((line = reader.readLine()) != null) {
				companies.add(line);
			}
		} catch (Exception ex) {
			updateStatus("Failed to load input list: " + ex.getMessage());
			return false;
		}
		
		BizapediaReportSpreadsheet ss = null;
		try {
			updateStatus("Preparing spreadsheet...");
			ss = new BizapediaReportSpreadsheet();
		} catch (Exception ex) {
			updateStatus("Failed to prepare spreadsheet: " + ex.getMessage());
			return false;
		}
		
		try {
			runApiExtraction(config, ss, companies);
		} catch (Exception ex) {
			updateStatus("Error occurred during processing: " + ex.getMessage());
			return false;
		} finally {
			updateStatus("Saving spreadsheet...");
			try {
				ss.saveSpreadsheet(config.getOutputFilePath());
			} catch (Exception ex) {
				updateStatus("Failed to save spreadsheet!  Error: " + ex.getMessage());
				return false;
			}
		}
		
		return true;
	}
	
	private void runApiExtraction(BizapediaProcessorConfig config, BizapediaReportSpreadsheet ss, List<String> companies) throws Exception {
		updateStatus("Processing...");
		BizapediaBatchService bizpediaService = new BizapediaBatchService(config.getApiKey());
		bizpediaService.lookupCompaniesByNames(companies, new BizapediaBatchCallback() {
			private String currentCompany;
			
			public void handleResult(Company company) throws Exception {
				this.currentCompany = company.getEntityName();
				updateStatus(String.format("Extracting: [ company : '%s' ]", this.currentCompany));
				
				ss.writeValueToColumn("EntityName", company.getEntityName());
				ss.writeValueToColumn("FileNumber", company.getFileNumber());
				ss.writeValueToColumn("FilingJurisdictionName", company.getFilingJurisdictionName());
				ss.writeValueToColumn("FilingJurisdictionPostalAbbreviation", company.getFilingJurisdictionPostalAbbreviation());
				ss.writeValueToColumn("DomesticJurisdictionName", company.getDomesticJurisdictionName());
				ss.writeValueToColumn("DomesticJurisdictionPostalAbbreviation", company.getDomesticJurisdictionPostalAbbreviation());
				ss.writeValueToColumn("FilingStatus", company.getFilingStatus());
				ss.writeValueToColumn("EntityType", company.getEntityType());
				ss.writeValueToColumn("FilingDate", company.getFilingDate() == null ? null : company.getFilingDate().toString());
				ss.writeValueToColumn("PrincipalAddressCountryCode", company.getPrincipalAddressCountryCode());
				ss.writeValueToColumn("PrincipalAddressLine1", company.getPrincipalAddressLine1());
				ss.writeValueToColumn("PrincipalAddressLine2", company.getPrincipalAddressLine2());
				ss.writeValueToColumn("PrincipalAddressCity", company.getPrincipalAddressCity());
				ss.writeValueToColumn("PrincipalAddressState", company.getPrincipalAddressState());
				ss.writeValueToColumn("PrincipalAddressPostalCode", company.getPrincipalAddressPostalCode());
				ss.writeValueToColumn("MailingAddressCountryCode", company.getMailingAddressCountryCode());
				ss.writeValueToColumn("MailingAddressLine1", company.getMailingAddressLine1());
				ss.writeValueToColumn("MailingAddressLine2", company.getMailingAddressLine2());
				ss.writeValueToColumn("MailingAddressCity", company.getMailingAddressCity());
				ss.writeValueToColumn("MailingAddressState", company.getMailingAddressState());
				ss.writeValueToColumn("MailingAddressPostalCode", company.getMailingAddressPostalCode());
				ss.writeValueToColumn("RegisteredAgentName", company.getRegisteredAgentName());
				ss.writeValueToColumn("RegisteredAgentAddressCountryCode", company.getRegisteredAgentAddressCountryCode());
				ss.writeValueToColumn("RegisteredAgentAddressLine1", company.getRegisteredAgentAddressLine1());
				ss.writeValueToColumn("RegisteredAgentAddressLine2", company.getRegisteredAgentAddressLine2());
				ss.writeValueToColumn("RegisteredAgentCity", company.getRegisteredAgentCity());
				ss.writeValueToColumn("RegisteredAgentState", company.getRegisteredAgentState());
				ss.writeValueToColumn("RegisteredAgentPostalCode", company.getRegisteredAgentPostalCode());
				ss.writeValueToColumn("RegisteredAgentPhone", company.getRegisteredAgentPhone());
				ss.writeValueToColumn("RegisteredAgentFax", company.getRegisteredAgentFax());
				ss.writeValueToColumn("RegisteredAgentEmail", company.getRegisteredAgentEmail());
				ss.writeValueToColumn("LastUpdateDate", company.getLastUpdateDate() == null ? null : company.getLastUpdateDate().toString());
				ss.writeValueToColumn("RelevanceScore", company.getRelevanceScore() == null ? null : company.getRelevanceScore().toString());
				
				ss.nextRow();
			}
			
			public void handleResult(Principal principle) throws Exception {
				updateStatus(String.format("Extracting: [ company : '%s' ] [ principle : '%s' ]", currentCompany, principle.getPrincipalName()));
				
				ss.writeValueToColumn("PrincipalName", principle.getPrincipalName());
				ss.writeValueToColumn("FirstName", principle.getFirstName());
				ss.writeValueToColumn("LastName", principle.getLastName());
				ss.writeValueToColumn("Titles", principle.getTitles());
				ss.writeValueToColumn("CountryCode", principle.getCountryCode());
				ss.writeValueToColumn("AddressLine1", principle.getAddressLine1());
				ss.writeValueToColumn("AddressLine2", principle.getAddressLine2());
				ss.writeValueToColumn("City", principle.getCity());
				ss.writeValueToColumn("StateProvince", principle.getStateProvince());
				ss.writeValueToColumn("PostalCode", principle.getPostalCode());
				
				ss.nextRow();
			}
		});
	}
	
	private void updateStatus(String text) {
		statusLabel.setText(text);
	}
}
