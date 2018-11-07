package org.malibu.msu.bizapedia.conversion;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class BizapediaConvertedApiOutput {
	
	private List<Map<String, String>> companies = new LinkedList<>();
	private List<Map<String, String>> principals = new LinkedList<>();
	private List<Map<String, String>> relevanceScores = new LinkedList<>();
	private List<Map<String, String>> trademarks = new LinkedList<>();
	
	public List<Map<String, String>> getCompanies() {
		return companies;
	}
	
	public List<Map<String, String>> getPrincipals() {
		return principals;
	}
	
	public List<Map<String, String>> getRelevanceScores() {
		return relevanceScores;
	}
	
	public List<Map<String, String>> getTrademarks() {
		return trademarks;
	}
	
	public void addAll(BizapediaConvertedApiOutput otherOutput) {
		if(otherOutput != null) {
			getCompanies().addAll(otherOutput.getCompanies());
			getPrincipals().addAll(otherOutput.getPrincipals());
			getRelevanceScores().addAll(otherOutput.getRelevanceScores());
			getTrademarks().addAll(otherOutput.getTrademarks());
		}
	}
	
}
