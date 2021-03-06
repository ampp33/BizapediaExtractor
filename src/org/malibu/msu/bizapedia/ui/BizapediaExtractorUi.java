package org.malibu.msu.bizapedia.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

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
	
	private static final int DEFAULT_SAVE_INTERVAL = 10;

	private JFrame frmBizapediaExtractor;
	private JTextField apiKeyField;
	private JLabel statusLabel;
	private JButton runButton;
	
	private JPanel progressBarPanel;
	private JPanel progressBgPanel;
	
	private Font montserratBlack22;
	private Font montserratRegular12;
	private Font montserratRegular10;
	private JTextField saveIntervalField;

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
					window.frmBizapediaExtractor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 * @throws FontFormatException 
	 */
	public BizapediaExtractorUi() throws FontFormatException, IOException {
		initializeFonts();
		initialize();
	}
	
	private void initializeFonts() throws FontFormatException, IOException {
		montserratBlack22 = Font.createFont(Font.TRUETYPE_FONT, BizapediaExtractorUi.class.getClassLoader().getResourceAsStream("Montserrat-Black.ttf")).deriveFont(22f);
		montserratRegular12 = Font.createFont(Font.TRUETYPE_FONT, BizapediaExtractorUi.class.getClassLoader().getResourceAsStream("Montserrat-Regular.ttf")).deriveFont(12f);
		montserratRegular10 = Font.createFont(Font.TRUETYPE_FONT, BizapediaExtractorUi.class.getClassLoader().getResourceAsStream("Montserrat-Regular.ttf")).deriveFont(10f);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBizapediaExtractor = new JFrame();
		frmBizapediaExtractor.setTitle("Bizapedia Extractor v1.5");
		frmBizapediaExtractor.setResizable(false);
		frmBizapediaExtractor.setBounds(100, 100, 415, 146);
		frmBizapediaExtractor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBizapediaExtractor.getContentPane().setLayout(null);
		frmBizapediaExtractor.getContentPane().setBackground(Color.WHITE);
		
		JLabel lblUsername = new JLabel("Api Key:");
		lblUsername.setFont(montserratRegular12);
		lblUsername.setForeground(Color.GRAY);
		lblUsername.setBounds(8, 45, 70, 14);
		frmBizapediaExtractor.getContentPane().add(lblUsername);
		
		apiKeyField = new JTextField();
		apiKeyField.setBounds(68, 43, 230, 20);
		frmBizapediaExtractor.getContentPane().add(apiKeyField);
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
		runButton.setBounds(308, 42, 89, 46);
		frmBizapediaExtractor.getContentPane().add(runButton);
		
		JLabel lblNewLabel = new JLabel("BIZAPEDIA EXTRACTOR");
		lblNewLabel.setForeground(new Color(100, 205, 196));
		lblNewLabel.setFont(montserratBlack22);
		lblNewLabel.setBounds(9, 4, 342, 33);
		frmBizapediaExtractor.getContentPane().add(lblNewLabel);
		
		JLabel lblV = new JLabel("v1.5");
		lblV.setBounds(11, 27, 46, 14);
		frmBizapediaExtractor.getContentPane().add(lblV);
		
		JPanel progressForegroundPanel = new JPanel();
		progressForegroundPanel.setOpaque(false);
		progressForegroundPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		progressForegroundPanel.setBounds(0, 96, 409, 23);
		frmBizapediaExtractor.getContentPane().add(progressForegroundPanel);
		progressForegroundPanel.setLayout(null);
		
		statusLabel = new JLabel("");
		statusLabel.setBounds(8, 4, 391, 14);
		progressForegroundPanel.add(statusLabel);
		statusLabel.setFont(montserratRegular10);
		statusLabel.setForeground(Color.WHITE);
		
		progressBarPanel = new JPanel();
		progressBarPanel.setBackground(new Color(100, 205, 196));
		progressBarPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		progressBarPanel.setBounds(0, 96, 0, 23);
		frmBizapediaExtractor.getContentPane().add(progressBarPanel);
		progressBarPanel.setLayout(null);
		
		progressBgPanel = new JPanel();
		progressBgPanel.setBackground(Color.GRAY);
		progressBgPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		progressBgPanel.setBounds(0, 96, 409, 23);
		frmBizapediaExtractor.getContentPane().add(progressBgPanel);
		progressBgPanel.setLayout(null);
		
		JLabel lblSaveInterval = new JLabel("Save Interval (API calls between saves):");
		lblSaveInterval.setForeground(Color.GRAY);
		lblSaveInterval.setFont(new Font("Montserrat", Font.PLAIN, 12));
		lblSaveInterval.setBounds(8, 70, 246, 14);
		frmBizapediaExtractor.getContentPane().add(lblSaveInterval);
		
		saveIntervalField = new JTextField();
		saveIntervalField.setColumns(10);
		saveIntervalField.setBounds(252, 68, 46, 20);
		saveIntervalField.setText(Integer.toString(DEFAULT_SAVE_INTERVAL));
		frmBizapediaExtractor.getContentPane().add(saveIntervalField);
	}
	
	private void handleExtraction() {
		// validiate save interval
		int saveInterval = DEFAULT_SAVE_INTERVAL;
		String saveIntervalAsString = saveIntervalField.getText();
		try {
			saveInterval = Integer.parseInt(saveIntervalAsString);
		} catch (Exception ex) {
			log.warn("user entered invalid save interval: " + saveIntervalAsString);
			JOptionPane.showMessageDialog(frmBizapediaExtractor, "Invalid save interval, enter a numeric value");
			return;
		}
		
		if(saveInterval <= 0) {
			saveInterval = DEFAULT_SAVE_INTERVAL;
			saveIntervalField.setText(Integer.toString(saveInterval));
		}
		
		// prompt for input file path
		log.debug("asking user for input file");
		JFileChooser inputFileChooser = new JFileChooser();
		inputFileChooser.setDialogTitle("Select your input text file");
		inputFileChooser.setFileFilter(new FileFilter() {
			public String getDescription() { return null; }
			public boolean accept(File f) { return f.getName().toLowerCase().endsWith(".txt"); }
		});
		int choice = inputFileChooser.showOpenDialog(frmBizapediaExtractor);
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
		choice = outputFileChooser.showSaveDialog(frmBizapediaExtractor);
		if(choice != JFileChooser.APPROVE_OPTION) {
			// halt processing if they don't select a file
			log.trace("user exited out of dest file dialog");
			return;
		}
		
		// process
		BizapediaProcessorConfig config
				= new BizapediaProcessorConfig(inputFileChooser.getSelectedFile().getAbsolutePath(),
												outputFileChooser.getSelectedFile().getAbsolutePath(),
												apiKeyField.getText(),
												saveInterval);
		
		log.debug("input file path: '{}'", config.getInputFilePath());
		log.debug("output file path: '{}'", config.getOutputFilePath());
		log.debug("api key: '{}'", config.getApiKey());
		log.info("kicking off extraction thread handler");
		boolean success = new BizapediaExtractionThreadHandler(this).runExtraction(config);
		log.info("done processing (success: {})", success);
		
		if(success) {
			log.debug("notifying user that processing was successful");
			updateStatusOnUi("Done! Success!");
			JOptionPane.showMessageDialog(frmBizapediaExtractor, "Success!");
		} else {
			log.debug("notifying user that processing failed");
			updateStatusOnUi("Errors were encountered during processing");
			JOptionPane.showMessageDialog(frmBizapediaExtractor, "An error occurred during processing");
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
