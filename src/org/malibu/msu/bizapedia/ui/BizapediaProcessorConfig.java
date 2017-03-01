package org.malibu.msu.bizapedia.ui;

public class BizapediaProcessorConfig {
	
	private String inputFilePath;
	private String outputFilePath;
	private String apiKey;
	
	public BizapediaProcessorConfig(String inputFilePath, String outputFilePath, String apiKey) {
		this.inputFilePath = inputFilePath;
		this.outputFilePath = outputFilePath;
		this.apiKey = apiKey;
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
	
}
