package org.malibu.msu.bizapedia.ws;

import java.util.List;

import https.www_bizapedia.Company;
import https.www_bizapedia.Principal;

public class BizapediaBatchService {
	
	private BizapediaWsClientWrapper client;
	
	public BizapediaBatchService(String apiKey) {
		this.client = new BizapediaWsClientWrapper(apiKey);
	}
	
	public void lookupCompaniesByNames(List<String> companyNames, BizapediaBatchCallback callback) throws Exception {
		for (String companyName : companyNames) {
			List<Company> companies = client.lookupCompaniesByName(companyName, null, null);
			for (Company company : companies) {
				callback.handleResult(company);
				for (Principal principle : company.getPrincipals().getPrincipal()) {
					callback.handleResult(principle);
				}
			}
		}
	}
}
