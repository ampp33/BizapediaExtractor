package org.malibu.msu.bizapedia.ws;

import java.util.List;

import https.www_bizapedia_com.BdmService;

public class BizapediaWsClientWrapper implements BizapediaWsClient {
	
	private String apiKey;
	
	private BdmService bdmService;
	
	public BizapediaWsClientWrapper(String apiKey) {
		this.apiKey = apiKey;
		this.bdmService = new BdmService();
	}
	
	public https.www_bizapedia.Company lookupCompanyByName(String postalAbbreviation, String companyName) {
		https.www_bizapedia.Company company = bdmService.getBdmserviceSoap().lcbn(apiKey, postalAbbreviation, companyName);
		return company;
	}
	
	public https.www_bizapedia.Company lookupCompanyByFileNumber(String postalAbbreviation, String fileNumber) {
		https.www_bizapedia.Company company = bdmService.getBdmserviceSoap().lcbfn(apiKey, postalAbbreviation, fileNumber);
//		if(!company.isSuccess()) {
//			throw new BizapediaWsClientException(company.getErrorMessage());
//		}
		return company;
	}
	
	public List<https.www_bizapedia.Company> lookupCompaniesByName(String companyName, String cityName, String postalAbbreviation) {
		https.www_bizapedia.CompanyList compList = bdmService.getBdmserviceSoap().lcsbn(apiKey, companyName, cityName, postalAbbreviation);
		return compList.getCompanies().getCompany();
	}
	
	public List<https.www_bizapedia.CompanyPrincipal> lookupPeople(String firstName, String lastName, String cityName, String postalAbbreviation) {
		https.www_bizapedia.CompanyPrincipalList cpl = bdmService.getBdmserviceSoap().lp(apiKey, firstName, lastName, cityName, postalAbbreviation);
		// TODO: success = false and errorMessage populated == valid error!  print error to spreadsheet and continue processing?
		return cpl.getCompanyPrincipals().getCompanyPrincipal();
	}
	
	public List<https.www_bizapedia.Trademark> lookupTrademarks(String trademarkMarkIdentification, String trademarkOwnerName) {
		https.www_bizapedia.TrademarkList tmList = bdmService.getBdmserviceSoap().lt(apiKey, trademarkMarkIdentification, trademarkOwnerName);
		return tmList.getTrademarks().getTrademark();
	}
	
	public https.www_bizapedia.AddressLists lookupAddresses(String address, String cityName, String postalAbbreviation, String postalCode) {
		https.www_bizapedia.AddressLists addrLists = bdmService.getBdmserviceSoap().la(apiKey, address, cityName, postalAbbreviation, postalCode);
		return addrLists;
	}
	
}
