package org.malibu.msu.bizapedia.ws;

import java.util.List;

import https.www_bizapedia_com.BdmService;

public class BizapediaWsClientWrapper {
	
	private String apiKey;
	
	private BdmService bdmService;
	
	public BizapediaWsClientWrapper(String apiKey) {
		this.apiKey = apiKey;
		this.bdmService = new BdmService();
	}
	
	public https.www_bizapedia.Company lookupCompanyByFileNumber(String postalAbbreviation, String fileNumber) throws BizapediaWsClientException {
		https.www_bizapedia.Company company = bdmService.getBdmserviceSoap().lcbfn(apiKey, postalAbbreviation, fileNumber);
		if(!company.isSuccess()) {
			throw new BizapediaWsClientException(company.getErrorMessage());
		}
		return company;
	}
	
	public List<https.www_bizapedia.Trademark> lookupTrademarks(String trademarkMarkIdentification, String trademarkOwnerName) throws BizapediaWsClientException {
		https.www_bizapedia.TrademarkList tmList = bdmService.getBdmserviceSoap().lt(apiKey, trademarkMarkIdentification, trademarkOwnerName);
		if(!tmList.isSuccess()) {
			throw new BizapediaWsClientException(tmList.getErrorMessage());
		}
		return tmList.getTrademarks().getTrademark();
	}
	
	public List<https.www_bizapedia.Company> lookupCompaniesByName(String companyName, String cityName, String postalAbbreviation) throws BizapediaWsClientException {
		https.www_bizapedia.CompanyList compList = bdmService.getBdmserviceSoap().lcsbn(apiKey, companyName, cityName, postalAbbreviation);
		if(!compList.isSuccess()) {
			throw new BizapediaWsClientException(compList.getErrorMessage());
		}
		return compList.getCompanies().getCompany();
	}
	
//	public https.www_bizapedia.AddressLists lookupAddresses(String address, String cityName, String postalAbbreviation, String postalCode) {
//		https.www_bizapedia.AddressLists addrLists = bdmService.getBdmserviceSoap().la(apiKey, address, cityName, postalAbbreviation, postalCode);
//		if(!addrLists.isSuccess()) {
//			throw new BizapediaWsClientException(addrLists.getErrorMessage());
//		}
//		return addrLists.get
//	}
	
	public List<https.www_bizapedia.CompanyPrincipal> lookupPeople(String firstName, String lastName, String cityName, String postalAbbreviation) throws BizapediaWsClientException {
		https.www_bizapedia.CompanyPrincipalList cpl = bdmService.getBdmserviceSoap().lp(apiKey, firstName, lastName, cityName, postalAbbreviation);
		if(!cpl.isSuccess()) {
			throw new BizapediaWsClientException(cpl.getErrorMessage());
		}
		return cpl.getCompanyPrincipals().getCompanyPrincipal();
	}
	
	public https.www_bizapedia.Company lookupCompanyByName(String postalAbbreviation, String companyName) throws BizapediaWsClientException {
		https.www_bizapedia.Company company = bdmService.getBdmserviceSoap().lcbn(apiKey, postalAbbreviation, companyName);
		if(!company.isSuccess()) {
			throw new BizapediaWsClientException(company.getErrorMessage());
		}
		return company;
	}
	
}
