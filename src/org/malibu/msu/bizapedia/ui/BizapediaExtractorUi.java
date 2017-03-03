package org.malibu.msu.bizapedia.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.filechooser.FileFilter;

import org.malibu.msu.bizapedia.BizapediaExtractionThreadHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.swing.JPanel;
import java.awt.Component;

public class BizapediaExtractorUi {
	
	private static final Logger log = LoggerFactory.getLogger(BizapediaExtractorUi.class);

	private JFrame frmBizapediaExtractorV;
	private JTextField apiKeyField;
	private JLabel statusLabel;
	private JButton runButton;
	
	private JPanel progressBarPanel;
	private JPanel progressBgPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					log.debug("creating main UI object");
					BizapediaExtractorUi window = new BizapediaExtractorUi();
					window.frmBizapediaExtractorV.setVisible(true);
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
		frmBizapediaExtractorV = new JFrame();
		frmBizapediaExtractorV.setTitle("Bizapedia Extractor v1.3");
		frmBizapediaExtractorV.setResizable(false);
		frmBizapediaExtractorV.setBounds(100, 100, 415, 122);
		frmBizapediaExtractorV.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBizapediaExtractorV.getContentPane().setLayout(null);
		frmBizapediaExtractorV.getContentPane().setBackground(Color.WHITE);
		
		JLabel lblUsername = new JLabel("Api Key:");
		lblUsername.setFont(new Font("Montserrat", Font.PLAIN, 12));
		lblUsername.setForeground(Color.GRAY);
		lblUsername.setBounds(10, 42, 70, 14);
		frmBizapediaExtractorV.getContentPane().add(lblUsername);
		
		apiKeyField = new JTextField();
		apiKeyField.setBounds(70, 40, 230, 20);
		frmBizapediaExtractorV.getContentPane().add(apiKeyField);
		apiKeyField.setColumns(10);
		
		runButton = new JButton("Run");
		runButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread(new Runnable() {
					public void run() {
						log.info("'Run' button has been clicked");
						runButton.setEnabled(false);
						updateProgressOnUi(0);
						try {
							handleExtraction();
						} finally {
							runButton.setEnabled(true);
						}
					}
				}).start();
			}
		});
		runButton.setBounds(310, 39, 89, 23);
		frmBizapediaExtractorV.getContentPane().add(runButton);
		
		JLabel lblNewLabel = new JLabel("BIZAPEDIA EXTRACTOR");
		lblNewLabel.setForeground(new Color(100, 205, 196));
		lblNewLabel.setFont(new Font("Montserrat", Font.BOLD, 22));
		lblNewLabel.setBounds(9, 0, 342, 33);
		frmBizapediaExtractorV.getContentPane().add(lblNewLabel);
		
		JLabel lblV = new JLabel("v1.3");
		lblV.setBounds(11, 23, 46, 14);
		frmBizapediaExtractorV.getContentPane().add(lblV);
		
		JPanel progressForegroundPanel = new JPanel();
		progressForegroundPanel.setOpaque(false);
		progressForegroundPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		progressForegroundPanel.setBounds(0, 72, 409, 23);
		frmBizapediaExtractorV.getContentPane().add(progressForegroundPanel);
		progressForegroundPanel.setLayout(null);
		
		statusLabel = new JLabel("");
		statusLabel.setBounds(8, 4, 391, 14);
		progressForegroundPanel.add(statusLabel);
		statusLabel.setFont(new Font("Montserrat", Font.PLAIN, 10));
		statusLabel.setForeground(Color.WHITE);
		
		progressBarPanel = new JPanel();
		progressBarPanel.setBackground(new Color(100, 205, 196));
		progressBarPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		progressBarPanel.setBounds(0, 72, 0, 23);
		frmBizapediaExtractorV.getContentPane().add(progressBarPanel);
		progressBarPanel.setLayout(null);
		
		progressBgPanel = new JPanel();
		progressBgPanel.setBackground(Color.GRAY);
		progressBgPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		progressBgPanel.setBounds(0, 72, 409, 23);
		frmBizapediaExtractorV.getContentPane().add(progressBgPanel);
		progressBgPanel.setLayout(null);
	}
	
	private void handleExtraction() {
		// prompt for input file path
		log.debug("asking user for input file");
		JFileChooser inputFileChooser = new JFileChooser();
		inputFileChooser.setDialogTitle("Select your input text file");
		inputFileChooser.setFileFilter(new FileFilter() {
			public String getDescription() { return null; }
			public boolean accept(File f) { return f.getName().toLowerCase().endsWith(".txt"); }
		});
		int choice = inputFileChooser.showOpenDialog(frmBizapediaExtractorV);
		if(choice != JFileChooser.APPROVE_OPTION) {
			// halt processing if they don't select a file
			log.trace("user exited out of input file dialog");
			return;
		}
		
		// prompt for output file path
		log.debug("asking user for output file location");
		JFileChooser outputFileChooser = new JFileChooser();
		outputFileChooser.setDialogTitle("Specify where to save your output file");
		outputFileChooser.setSelectedFile(new File("output.xlsx"));
		choice = outputFileChooser.showSaveDialog(frmBizapediaExtractorV);
		if(choice != JFileChooser.APPROVE_OPTION) {
			// halt processing if they don't select a file
			log.trace("user exited out of dest file dialog");
			return;
		}
		
		// process
		BizapediaProcessorConfig config
				= new BizapediaProcessorConfig(inputFileChooser.getSelectedFile().getAbsolutePath(),
												outputFileChooser.getSelectedFile().getAbsolutePath(),
												apiKeyField.getText());
		log.debug("input file path: '{}'", config.getInputFilePath());
		log.debug("output file path: '{}'", config.getOutputFilePath());
		log.debug("api key: '{}'", config.getApiKey());
		log.info("kicking off extraction thread handler");
		boolean success = new BizapediaExtractionThreadHandler(this).runExtraction(config);
		log.info("done processing (success: {})", success);
		
		if(success) {
			log.debug("notifying user that processing was successful");
			updateStatusOnUi("Done! Success!");
			JOptionPane.showMessageDialog(frmBizapediaExtractorV, "Success!");
		} else {
			log.debug("notifying user that processing failed");
			updateStatusOnUi("Errors were encountered during processing");
			JOptionPane.showMessageDialog(frmBizapediaExtractorV, "An error occurred during processing");
		}
	}
	
	public void updateStatusOnUi(String text) {
		statusLabel.setText(text);
	}
	
	public void updateProgressOnUi(double percentComplete) {
		double complateProgressBarWidth = (double)progressBgPanel.getWidth();
		double progressBarWidth = (complateProgressBarWidth * percentComplete);
		progressBarPanel.setSize((int)progressBarWidth, progressBarPanel.getHeight());
	}
}
