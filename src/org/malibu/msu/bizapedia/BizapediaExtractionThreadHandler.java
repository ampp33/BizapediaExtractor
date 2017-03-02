package org.malibu.msu.bizapedia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.malibu.msu.bizapedia.ui.BizapediaExtractorUi;
import org.malibu.msu.bizapedia.ui.BizapediaProcessorConfig;
import org.malibu.msu.bizapedia.ws.BizapediaWsClientWrapper;

import https.www_bizapedia.Company;
import https.www_bizapedia.Principal;

public class BizapediaExtractionThreadHandler {
	
	private BizapediaExtractorUi mainUi;
	
	public BizapediaExtractionThreadHandler(BizapediaExtractorUi mainUi) {
		this.mainUi = mainUi;
	}
	
	public boolean runExtraction(BizapediaProcessorConfig config) {
		updateStatus("Loading input list...");
		List<String> companies = new LinkedList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(new File(config.getInputFilePath())))) {
			String line = null;
			while((line = reader.readLine()) != null) {
				companies.add(line);
			}
		} catch (Exception ex) {
			updateStatus("Failed to load input list: " + ex.getMessage());
			return false;
		}
		
		updateStatus("Preparing spreadsheet...");
		BizapediaReportSpreadsheet ss = null;
		try {
			ss = new BizapediaReportSpreadsheet();
		} catch (Exception ex) {
			updateStatus("Failed to prepare spreadsheet: " + ex.getMessage());
			return false;
		}
		
		updateStatus("Beginning extraction...");
		try {
			executeApiCalls(config, ss, companies);
		} catch (Exception ex) {
			updateStatus("Error occurred during processing: " + ex.getMessage());
			return false;
		} finally {
			updateStatus("Saving spreadsheet...");
			try {
				ss.saveSpreadsheet(config.getOutputFilePath());
			} catch (Exception ex) {
				updateStatus("Failed to save spreadsheet!  Error: " + ex.getMessage());
				return false;
			}
		}
		
		return true;
	}
	
	private void executeApiCalls(BizapediaProcessorConfig config, BizapediaReportSpreadsheet ss, List<String> listOfCompanyNamesToSearch) throws Exception {
		updateStatus("Processing...");
		BizapediaWsClientWrapper client = new BizapediaWsClientWrapper(config.getApiKey());
		
		// TODO: need to save the spreadsheet ever 3 search results or so.  These API calls are precious!  Don't waste any data!!
		
		int currentCompanyNum = 0;
		int totalNumCompanies = listOfCompanyNamesToSearch.size();
		
		for (String companyName : listOfCompanyNamesToSearch) {
			
			boolean foundCompany = false;
			currentCompanyNum++;
			
			updateStatus(String.format("Extracting ( %d / %d ): [ company : '%s' ]", currentCompanyNum, totalNumCompanies, companyName));
			
			ss.writeValueToColumn("SearchedCompanyName", companyName);
			
			List<Company> companiesFound = client.lookupCompaniesByName(companyName, "", "");
			
			for (Company company : companiesFound) {
				
				foundCompany = true;
				boolean foundPrinciple = false;
				
				writeCompanyToSs(ss, company);
				
				for (Principal principle : company.getPrincipals().getPrincipal()) {
					
					foundPrinciple = true;
					
					writePrincipleToSs(ss, principle);
					ss.nextRow();
					
				}
				
				if(!foundPrinciple) ss.nextRow();
			}
			
			if(!foundCompany) ss.nextRow();
			
			if(currentCompanyNum % 3 == 0) {
				updateStatus("Saving spreadsheet every three searches executed...");
				ss.saveSpreadsheet(config.getOutputFilePath());
			}
			
		}
	}

	private void writeCompanyToSs(BizapediaReportSpreadsheet ss, Company company) throws IOException {
		ss.writeValueToColumn("EntityName", company.getEntityName());
		ss.writeValueToColumn("FileNumber", company.getFileNumber());
		ss.writeValueToColumn("FilingJurisdictionName", company.getFilingJurisdictionName());
		ss.writeValueToColumn("FilingJurisdictionPostalAbbreviation", company.getFilingJurisdictionPostalAbbreviation());
		ss.writeValueToColumn("DomesticJurisdictionName", company.getDomesticJurisdictionName());
		ss.writeValueToColumn("DomesticJurisdictionPostalAbbreviation", company.getDomesticJurisdictionPostalAbbreviation());
		ss.writeValueToColumn("FilingStatus", company.getFilingStatus());
		ss.writeValueToColumn("EntityType", company.getEntityType());
		ss.writeValueToColumn("FilingDate", company.getFilingDate() == null ? null : company.getFilingDate().toString());
		ss.writeValueToColumn("PrincipalAddressCountryCode", company.getPrincipalAddressCountryCode());
		ss.writeValueToColumn("PrincipalAddressLine1", company.getPrincipalAddressLine1());
		ss.writeValueToColumn("PrincipalAddressLine2", company.getPrincipalAddressLine2());
		ss.writeValueToColumn("PrincipalAddressCity", company.getPrincipalAddressCity());
		ss.writeValueToColumn("PrincipalAddressState", company.getPrincipalAddressState());
		ss.writeValueToColumn("PrincipalAddressPostalCode", company.getPrincipalAddressPostalCode());
		ss.writeValueToColumn("MailingAddressCountryCode", company.getMailingAddressCountryCode());
		ss.writeValueToColumn("MailingAddressLine1", company.getMailingAddressLine1());
		ss.writeValueToColumn("MailingAddressLine2", company.getMailingAddressLine2());
		ss.writeValueToColumn("MailingAddressCity", company.getMailingAddressCity());
		ss.writeValueToColumn("MailingAddressState", company.getMailingAddressState());
		ss.writeValueToColumn("MailingAddressPostalCode", company.getMailingAddressPostalCode());
		ss.writeValueToColumn("RegisteredAgentName", company.getRegisteredAgentName());
		ss.writeValueToColumn("RegisteredAgentAddressCountryCode", company.getRegisteredAgentAddressCountryCode());
		ss.writeValueToColumn("RegisteredAgentAddressLine1", company.getRegisteredAgentAddressLine1());
		ss.writeValueToColumn("RegisteredAgentAddressLine2", company.getRegisteredAgentAddressLine2());
		ss.writeValueToColumn("RegisteredAgentCity", company.getRegisteredAgentCity());
		ss.writeValueToColumn("RegisteredAgentState", company.getRegisteredAgentState());
		ss.writeValueToColumn("RegisteredAgentPostalCode", company.getRegisteredAgentPostalCode());
		ss.writeValueToColumn("RegisteredAgentPhone", company.getRegisteredAgentPhone());
		ss.writeValueToColumn("RegisteredAgentFax", company.getRegisteredAgentFax());
		ss.writeValueToColumn("RegisteredAgentEmail", company.getRegisteredAgentEmail());
		ss.writeValueToColumn("LastUpdateDate", company.getLastUpdateDate() == null ? null : company.getLastUpdateDate().toString());
		ss.writeValueToColumn("RelevanceScore", company.getRelevanceScore() == null ? null : company.getRelevanceScore().toString());
	}
	
	private void writePrincipleToSs(BizapediaReportSpreadsheet ss, Principal principle) throws IOException {
		ss.writeValueToColumn("PrincipalName", principle.getPrincipalName());
		ss.writeValueToColumn("FirstName", principle.getFirstName());
		ss.writeValueToColumn("LastName", principle.getLastName());
		ss.writeValueToColumn("Titles", principle.getTitles());
		ss.writeValueToColumn("CountryCode", principle.getCountryCode());
		ss.writeValueToColumn("AddressLine1", principle.getAddressLine1());
		ss.writeValueToColumn("AddressLine2", principle.getAddressLine2());
		ss.writeValueToColumn("City", principle.getCity());
		ss.writeValueToColumn("StateProvince", principle.getStateProvince());
		ss.writeValueToColumn("PostalCode", principle.getPostalCode());
	}
	
	private void updateStatus(String text) {
		mainUi.updateStatusOnUi(text);
	}
	
}
