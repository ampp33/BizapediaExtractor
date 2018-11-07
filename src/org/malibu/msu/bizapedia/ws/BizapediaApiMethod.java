package org.malibu.msu.bizapedia.ws;

import java.util.Arrays;
import java.util.Map;
import java.util.function.BiFunction;

import org.malibu.msu.bizapedia.conversion.BizapediaConvertedApiOutput;

public class BizapediaApiMethod {
	
	private String apiMethodDescription;
	private String[] inputParameters;
	private BiFunction<String, Map<String, String>, BizapediaConvertedApiOutput> executeFunction;
	
	public BizapediaApiMethod(String apiMethodDescription, BiFunction<String, Map<String, String>, BizapediaConvertedApiOutput> executeFunction, String... inputParameters) {
		setApiMethodDescription(apiMethodDescription);
		setInputParameters(inputParameters);
		this.executeFunction = executeFunction;
	}
	
	public String getApiMethodDescription() {
		return apiMethodDescription;
	}
	
	public void setApiMethodDescription(String apiMethodDescription) {
		this.apiMethodDescription = apiMethodDescription;
	}
	
	public String[] getInputParameters() {
		return inputParameters;
	}
	
	public void setInputParameters(String[] inputParameters) {
		this.inputParameters = inputParameters;
	}
	
	public String getInputParametersAsString() {
		return Arrays.toString(inputParameters).replace("[", "").replaceAll("]", "");
	}
	
	public BizapediaConvertedApiOutput execute(String apiKey, Map<String, String> inputParameters) {
		return executeFunction.apply(apiKey, inputParameters);
	}
	
}
