package org.malibu.msu.bizapedia.ws;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import https.www_bizapedia.ArrayOfPrincipal;
import https.www_bizapedia.Company;
import https.www_bizapedia.CompanyPrincipal;
import https.www_bizapedia.Principal;
import https.www_bizapedia.Trademark;

public class DummyBizapediaWsClientWrapper implements BizapediaWsClient {
	
	public DummyBizapediaWsClientWrapper(String apiKey) {
	}
	
	public List<https.www_bizapedia.Company> lookupCompaniesByName(String companyName, String cityName, String postalAbbreviation) throws BizapediaWsClientException {
		List<https.www_bizapedia.Company> result = new LinkedList<>();
		result.add(createDummyCompanyWithPrinciples());
		return result;
	}
	
	private Company createDummyCompanyWithPrinciples() {
		https.www_bizapedia.Company company = new Company();
		
		company.setEntityName("EntityName");
		company.setFileNumber("FileNumber");
		company.setFilingJurisdictionName("FilingJurisdictionName");
		company.setFilingJurisdictionPostalAbbreviation("FilingJurisdictionPostalAbbreviation");
		company.setDomesticJurisdictionName("DomesticJurisdictionName");
		company.setDomesticJurisdictionPostalAbbreviation("DomesticJurisdictionPostalAbbreviation");
		company.setFilingStatus("FilingStatus");
		company.setEntityType("EntityType");
		company.setFilingDate(null);
		company.setPrincipalAddressCountryCode("PrincipalAddressCountryCode");
		company.setPrincipalAddressLine1("PrincipalAddressLine1");
		company.setPrincipalAddressLine2("PrincipalAddressLine2");
		company.setPrincipalAddressCity("PrincipalAddressCity");
		company.setPrincipalAddressState("PrincipalAddressState");
		company.setPrincipalAddressPostalCode("PrincipalAddressPostalCode");
		company.setMailingAddressCountryCode("MailingAddressCountryCode");
		company.setMailingAddressLine1("MailingAddressLine1");
		company.setMailingAddressLine2("MailingAddressLine2");
		company.setMailingAddressCity("MailingAddressCity");
		company.setMailingAddressState("MailingAddressState");
		company.setMailingAddressPostalCode("MailingAddressPostalCode");
		company.setRegisteredAgentName("RegisteredAgentName");
		company.setRegisteredAgentAddressCountryCode("RegisteredAgentAddressCountryCode");
		company.setRegisteredAgentAddressLine1("RegisteredAgentAddressLine1");
		company.setRegisteredAgentAddressLine2("RegisteredAgentAddressLine2");
		company.setRegisteredAgentCity("RegisteredAgentCity");
		company.setRegisteredAgentState("RegisteredAgentState");
		company.setRegisteredAgentPostalCode("RegisteredAgentPostalCode");
		company.setRegisteredAgentPhone("RegisteredAgentPhone");
		company.setRegisteredAgentFax("RegisteredAgentFax");
		company.setRegisteredAgentEmail("RegisteredAgentEmail");
		company.setLastUpdateDate(null);
		company.setRelevanceScore(new BigDecimal(10));
		
		company.setPrincipals(new ArrayOfPrincipal());
		company.getPrincipals().getPrincipal().add(createDummyPrincipal("1", "dude", "king dude"));
		company.getPrincipals().getPrincipal().add(createDummyPrincipal("2", "dude", "blah dude"));
		company.getPrincipals().getPrincipal().add(createDummyPrincipal("3", "dude", "some dude"));
		company.getPrincipals().getPrincipal().add(createDummyPrincipal("4", "dude", "herp dude"));
		
		return company;
	}
	
	private Principal createDummyPrincipal(String firstName, String lastName, String title) {
		https.www_bizapedia.Principal principal = new Principal();
		
		principal.setPrincipalName(firstName + " " + lastName);
		principal.setFirstName(firstName);
		principal.setLastName(lastName);
		principal.setTitles(title);
		principal.setCountryCode("CountryCode");
		principal.setAddressLine1("AddressLine1");
		principal.setAddressLine2("AddressLine2");
		principal.setCity("City");
		principal.setStateProvince("StateProvince");
		principal.setPostalCode("PostalCode");
		
		return principal;
	}

	public Company lookupCompanyByFileNumber(String postalAbbreviation, String fileNumber)
			throws BizapediaWsClientException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Trademark> lookupTrademarks(String trademarkMarkIdentification, String trademarkOwnerName)
			throws BizapediaWsClientException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<CompanyPrincipal> lookupPeople(String firstName, String lastName, String cityName,
			String postalAbbreviation) throws BizapediaWsClientException {
		// TODO Auto-generated method stub
		return null;
	}

	public Company lookupCompanyByName(String postalAbbreviation, String companyName)
			throws BizapediaWsClientException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
