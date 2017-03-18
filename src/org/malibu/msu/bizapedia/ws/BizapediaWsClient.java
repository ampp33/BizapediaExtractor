package org.malibu.msu.bizapedia.ws;

import java.util.List;

public interface BizapediaWsClient {
	
	public https.www_bizapedia.Company lookupCompanyByFileNumber(String postalAbbreviation, String fileNumber) throws BizapediaWsClientException;
	public List<https.www_bizapedia.Trademark> lookupTrademarks(String trademarkMarkIdentification, String trademarkOwnerName) throws BizapediaWsClientException;
	public List<https.www_bizapedia.Company> lookupCompaniesByName(String companyName, String cityName, String postalAbbreviation) throws BizapediaWsClientException;
	public List<https.www_bizapedia.CompanyPrincipal> lookupPeople(String firstName, String lastName, String cityName, String postalAbbreviation) throws BizapediaWsClientException;
	public https.www_bizapedia.Company lookupCompanyByName(String postalAbbreviation, String companyName) throws BizapediaWsClientException;
	
}
