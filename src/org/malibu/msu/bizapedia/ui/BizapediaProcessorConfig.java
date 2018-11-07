package org.malibu.msu.bizapedia.ui;

import org.malibu.msu.bizapedia.ws.BizapediaApiMethod;

public class BizapediaProcessorConfig {
	
	private String inputFilePath;
	private String outputDirFilePath;
	private BizapediaApiMethod apiMethod;
	private String apiKey;
	private int saveInterval;
	
	public BizapediaProcessorConfig(String inputFilePath, String outputDirFilePath, BizapediaApiMethod apiMethod, String apiKey, int saveInterval) {
		this.inputFilePath = inputFilePath;
		this.outputDirFilePath = outputDirFilePath;
		this.apiMethod = apiMethod;
		this.apiKey = apiKey;
		this.saveInterval = saveInterval;
	}
	
	public String getOutputDirFilePath() {
		return outputDirFilePath;
	}
	
	public BizapediaApiMethod getApiMethod() {
		return this.apiMethod;
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
