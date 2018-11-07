package org.malibu.msu.bizapedia.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileFilter;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.malibu.msu.bizapedia.BizapediaExtractionThreadHandler;
import org.malibu.msu.bizapedia.BizapediaExtractorException;
import org.malibu.msu.bizapedia.ws.BizapediaApiDefinitions;
import org.malibu.msu.bizapedia.ws.BizapediaApiMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BizapediaExtractorUi {
	
	private static final Logger log = LoggerFactory.getLogger(BizapediaExtractorUi.class);
	
	private static final int DEFAULT_SAVE_INTERVAL = 10;

	private JFrame frmBizapediaExtractor;
	private JComboBox<BizapediaApiMethod> apiMethodComboBox;
	private JTextField apiKeyField;
	private JLabel statusLabel;
	private JButton runButton;
	
	private JPanel progressBarPanel;
	private JPanel progressBgPanel;
	
	private Font montserratBlack22;
	private Font montserratRegular12;
	private Font montserratRegular10;
	private JTextField saveIntervalField;
	private JTextArea inputParametersTextArea;
	
	private static final BizapediaApiMethod[] API_METHODS = new BizapediaApiMethod[] {
		BizapediaApiDefinitions.LOOKUP_COMPANY_BY_COMPANY_NAME,
		BizapediaApiDefinitions.LOOKUP_COMPANY_BY_FILE_NUMBER,
		BizapediaApiDefinitions.LOOKUP_COMPANIES_BY_COMPANY_NAME,
		BizapediaApiDefinitions.LOOKUP_COMPANIES_BY_PEOPLE,
		BizapediaApiDefinitions.LOOKUP_TRADEMARKS,
		BizapediaApiDefinitions.LOOKUP_ADDRESSES
		
	};

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
		frmBizapediaExtractor.setTitle("Bizapedia Extractor v2.0");
		frmBizapediaExtractor.setResizable(false);
		frmBizapediaExtractor.setBounds(100, 100, 415, 281);
		frmBizapediaExtractor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBizapediaExtractor.getContentPane().setLayout(null);
		frmBizapediaExtractor.getContentPane().setBackground(Color.WHITE);
		
		JLabel lblApiKey = new JLabel("Api Key:");
		lblApiKey.setFont(montserratRegular12);
		lblApiKey.setForeground(Color.GRAY);
		lblApiKey.setBounds(8, 45, 70, 14);
		frmBizapediaExtractor.getContentPane().add(lblApiKey);
		
		apiKeyField = new JTextField();
		apiKeyField.setBounds(68, 43, 329, 20);
		apiKeyField.setText(System.getProperty("DEFAULT_API_KEY"));
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
		runButton.setBounds(308, 119, 89, 91);
		frmBizapediaExtractor.getContentPane().add(runButton);
		
		JLabel lblAppTitle = new JLabel("BIZAPEDIA EXTRACTOR");
		lblAppTitle.setForeground(new Color(100, 205, 196));
		lblAppTitle.setFont(montserratBlack22);
		lblAppTitle.setBounds(9, 4, 342, 33);
		frmBizapediaExtractor.getContentPane().add(lblAppTitle);
		
		JLabel lblVersion = new JLabel("v2.0");
		lblVersion.setBounds(11, 27, 46, 14);
		frmBizapediaExtractor.getContentPane().add(lblVersion);
		
		JPanel progressForegroundPanel = new JPanel();
		progressForegroundPanel.setOpaque(false);
		progressForegroundPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		progressForegroundPanel.setBounds(0, 223, 409, 23);
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
		progressBarPanel.setBounds(0, 223, 0, 23);
		frmBizapediaExtractor.getContentPane().add(progressBarPanel);
		progressBarPanel.setLayout(null);
		
		progressBgPanel = new JPanel();
		progressBgPanel.setBackground(Color.GRAY);
		progressBgPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		progressBgPanel.setBounds(0, 223, 409, 23);
		frmBizapediaExtractor.getContentPane().add(progressBgPanel);
		progressBgPanel.setLayout(null);
		
		JLabel lblSaveInterval = new JLabel("Save Interval (API calls between saves):");
		lblSaveInterval.setForeground(Color.GRAY);
		lblSaveInterval.setFont(new Font("Montserrat", Font.PLAIN, 12));
		lblSaveInterval.setBounds(8, 192, 246, 14);
		frmBizapediaExtractor.getContentPane().add(lblSaveInterval);
		
		saveIntervalField = new JTextField();
		saveIntervalField.setColumns(10);
		saveIntervalField.setBounds(252, 190, 46, 20);
		saveIntervalField.setText(Integer.toString(DEFAULT_SAVE_INTERVAL));
		frmBizapediaExtractor.getContentPane().add(saveIntervalField);
		
		JLabel lblApiMethod = new JLabel("Api Method:");
		lblApiMethod.setForeground(Color.GRAY);
		lblApiMethod.setFont(new Font("Montserrat", Font.PLAIN, 12));
		lblApiMethod.setBounds(8, 75, 70, 14);
		frmBizapediaExtractor.getContentPane().add(lblApiMethod);
		
		apiMethodComboBox = new JComboBox<>(new DefaultComboBoxModel<>(API_METHODS));
		apiMethodComboBox.setBounds(78, 72, 319, 20);
		apiMethodComboBox.setRenderer(new DefaultListCellRenderer() {
			@Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if(value instanceof BizapediaApiMethod){
                	BizapediaApiMethod apiMethod = (BizapediaApiMethod) value;
                    setText(apiMethod.getApiMethodDescription());
                }
                return this;
            }
		});
		apiMethodComboBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					BizapediaApiMethod apiMethod = (BizapediaApiMethod)e.getItem();
					inputParametersTextArea.setText(apiMethod.getInputParametersAsString());
				}
			}
		});
		frmBizapediaExtractor.getContentPane().add(apiMethodComboBox);
		
		JLabel lblInputParameters = new JLabel("Input Parameters:");
		lblInputParameters.setForeground(Color.GRAY);
		lblInputParameters.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblInputParameters.setBounds(8, 102, 152, 14);
		frmBizapediaExtractor.getContentPane().add(lblInputParameters);
		
		inputParametersTextArea = new JTextArea();
		inputParametersTextArea.setWrapStyleWord(true);
		inputParametersTextArea.setBorder(new LineBorder(Color.GRAY));
		inputParametersTextArea.setLineWrap(true);
		inputParametersTextArea.setBounds(8, 119, 288, 60);
		frmBizapediaExtractor.getContentPane().add(inputParametersTextArea);
		// set text area to contain the currently selected api method on app startup
		BizapediaApiMethod selectedApiMethod = (BizapediaApiMethod)apiMethodComboBox.getSelectedItem();
		inputParametersTextArea.setText(selectedApiMethod.getInputParametersAsString());
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
		inputFileChooser.setDialogTitle("Select your input Excel file");
		inputFileChooser.setFileFilter(new FileFilter() {
			public String getDescription() { return null; }
			public boolean accept(File f) { return f.isDirectory()
														|| f.getName().toLowerCase().endsWith(".xlsx")
														|| f.getName().toLowerCase().endsWith(".xls"); }
		});
		int choice = inputFileChooser.showOpenDialog(frmBizapediaExtractor);
		if(choice != JFileChooser.APPROVE_OPTION) {
			// halt processing if they don't select a file
			log.trace("user exited out of input file dialog");
			return;
		}
		
		// prompt for output dir path
		log.debug("asking user for output file location");
		JFileChooser outputDirChooser = new JFileChooser();
		outputDirChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		outputDirChooser.setDialogTitle("Specify directory to save your output file(s)");
		choice = outputDirChooser.showSaveDialog(frmBizapediaExtractor);
		if(choice != JFileChooser.APPROVE_OPTION) {
			// halt processing if they don't select a file
			log.trace("user exited out of dest file dialog");
			return;
		}
		
		// process
		BizapediaProcessorConfig config
				= new BizapediaProcessorConfig(inputFileChooser.getSelectedFile().getAbsolutePath(),
												outputDirChooser.getSelectedFile().getAbsolutePath(),
												(BizapediaApiMethod)apiMethodComboBox.getSelectedItem(),
												apiKeyField.getText(),
												saveInterval);
		
		log.debug("input file path: '{}'", config.getInputFilePath());
		log.debug("output dir path: '{}'", config.getOutputDirFilePath());
		log.debug("api method: '{}'", config.getApiMethod().getApiMethodDescription());
		log.debug("api key: '{}'", config.getApiKey());
		
		log.info("kicking off extraction thread handler");
		try {
			new BizapediaExtractionThreadHandler(this).runExtraction(config);
		} catch (EncryptedDocumentException | InvalidFormatException | IOException | BizapediaExtractorException e) {
			log.debug("exception was thrown during processing", e);
			updateStatusOnUi("Errors were encountered during processing");
			JOptionPane.showMessageDialog(frmBizapediaExtractor, "An error occurred during processing: " + e.getMessage());
			return;
		}
		
		log.info("done processing");
		log.debug("notifying user that processing was successful");
		updateStatusOnUi("Done! Success!");
		JOptionPane.showMessageDialog(frmBizapediaExtractor, "Success!");
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
