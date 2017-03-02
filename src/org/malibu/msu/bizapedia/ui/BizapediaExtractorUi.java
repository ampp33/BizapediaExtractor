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

public class BizapediaExtractorUi {
	
	private static final Logger log = LoggerFactory.getLogger(BizapediaExtractorUi.class);

	private JFrame frame;
	private JTextField apiKeyField;
	private JLabel statusLabel;
	private JButton runButton;

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
					window.frame.setVisible(true);
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
		frame = new JFrame();
		frame.setTitle("Bizapedia Extractor v1.2");
		frame.setResizable(false);
		frame.setBounds(100, 100, 415, 118);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Api Key:");
		lblUsername.setBounds(10, 42, 70, 14);
		frame.getContentPane().add(lblUsername);
		
		apiKeyField = new JTextField();
		apiKeyField.setBounds(90, 39, 194, 20);
		frame.getContentPane().add(apiKeyField);
		apiKeyField.setColumns(10);
		
		runButton = new JButton("Run");
		runButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread(new Runnable() {
					public void run() {
						log.info("'Run' button has been clicked");
						runButton.setEnabled(false);
						try {
							handleExtraction();
						} finally {
							runButton.setEnabled(true);
						}
					}
				}).start();
			}
		});
		runButton.setBounds(304, 38, 89, 23);
		frame.getContentPane().add(runButton);
		
		statusLabel = new JLabel("<status>");
		statusLabel.setBounds(10, 67, 389, 14);
		frame.getContentPane().add(statusLabel);
		
		JLabel lblNewLabel = new JLabel("Bizapedia Extractor");
		lblNewLabel.setForeground(new Color(255, 140, 0));
		lblNewLabel.setFont(new Font("Ubuntu", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 0, 342, 33);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblV = new JLabel("v1.0");
		lblV.setBounds(199, 17, 46, 14);
		frame.getContentPane().add(lblV);
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
		int choice = inputFileChooser.showOpenDialog(frame);
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
		choice = outputFileChooser.showSaveDialog(frame);
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
			JOptionPane.showMessageDialog(frame, "Success!");
		} else {
			log.debug("notifying user that processing failed");
			updateStatusOnUi("Errors were encountered during processing");
			JOptionPane.showMessageDialog(frame, "An error occurred during processing");
		}
	}
	
	public void updateStatusOnUi(String text) {
		statusLabel.setText(text);
	}
	
}
