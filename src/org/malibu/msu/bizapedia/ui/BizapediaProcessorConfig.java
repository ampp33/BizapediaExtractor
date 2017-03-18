package org.malibu.msu.bizapedia.ui;

public class BizapediaProcessorConfig {
	
	private String inputFilePath;
	private String outputFilePath;
	private String apiKey;
	private int saveInterval;
	
	public BizapediaProcessorConfig(String inputFilePath, String outputFilePath, String apiKey, int saveInterval) {
		this.inputFilePath = inputFilePath;
		this.outputFilePath = outputFilePath;
		this.apiKey = apiKey;
		this.saveInterval = saveInterval;
	}
	
	public String getOutputFilePath() {
		return outputFilePath;
	}
	
	public String getApiKey() {
		return apiKey;
	}
	
	public String getInputFilePath() {
		return inputFilePath;
	}
	
	public int getSaveInterval() {
		return saveInterval;
	}
	
}
