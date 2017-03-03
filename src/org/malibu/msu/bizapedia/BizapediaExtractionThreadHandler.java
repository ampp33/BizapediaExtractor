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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import https.www_bizapedia.Company;
import https.www_bizapedia.Principal;

public class BizapediaExtractionThreadHandler {
	
	private static final Logger log = LoggerFactory.getLogger(BizapediaExtractionThreadHandler.class);
	
	private BizapediaExtractorUi mainUi;
	
	public BizapediaExtractionThreadHandler(BizapediaExtractorUi mainUi) {
		this.mainUi = mainUi;
	}
	
	public boolean runExtraction(BizapediaProcessorConfig config) {
		updateStatus("Loading input list...");
		List<String> companies = new LinkedList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(new File(config.getInputFilePath())))) {
			String line = null;
			log.debug("looking for companies listed in the input file...");
			while((line = reader.readLine()) != null) {
				log.debug(line);
				companies.add(line);
			}
		} catch (Exception ex) {
			log.error("failed to load input file, halting processing", ex);
			updateStatus("Failed to load input list: " + ex.getMessage());
			return false;
		}
		
		updateStatus("Preparing spreadsheet...");
		BizapediaReportSpreadsheet ss = null;
		try {
			ss = new BizapediaReportSpreadsheet();
		} catch (Exception ex) {
			log.error("failed to prepare output spreadsheet, halting processing", ex);
			updateStatus("Failed to prepare spreadsheet: " + ex.getMessage());
			return false;
		}
		
		updateStatus("Beginning extraction...");
		try {
			executeApiCalls(config, ss, companies);
			log.debug("done making all API calls");
		} catch (Exception ex) {
			log.error("error occurred during processing, halting processing", ex);
			updateStatus("Error occurred during processing: " + ex.getMessage());
			return false;
		} finally {
			updateStatus("Saving spreadsheet...");
			try {
				ss.saveSpreadsheet(config.getOutputFilePath());
				mainUi.updateProgressOnUi(1);
			} catch (Exception ex) {
				log.error("UNALBE TO SAVE SPREADSHEET.  Either the user was messing with the file, or something very bad happened!", ex);
				updateStatus("Failed to save spreadsheet!  Error: " + ex.getMessage());
				mainUi.updateProgressOnUi(1); // mark status bar as "complete"
				return false;
			}
		}
		
		return true;
	}
	
	private void executeApiCalls(BizapediaProcessorConfig config, BizapediaReportSpreadsheet ss, List<String> listOfCompanyNamesToSearch) throws Exception {
		updateStatus("Processing...");
		log.debug("creating web service wrapper and client with API key '{}'", config.getApiKey());
		BizapediaWsClientWrapper client = new BizapediaWsClientWrapper(config.getApiKey());
		
		int currentCompanyNum = 0;
		int totalNumCompanies = listOfCompanyNamesToSearch.size();
		
		for (String companyName : listOfCompanyNamesToSearch) {
			
			boolean foundCompany = false;
			currentCompanyNum++;
			
			updateStatus(String.format("Extracting ( %d / %d ): [ company : '%s' ]", currentCompanyNum, totalNumCompanies, companyName));
			mainUi.updateProgressOnUi(calculatePercentComplete(currentCompanyNum, totalNumCompanies));
			
			ss.writeValueToColumn("SearchedCompanyName", companyName);
			
			log.debug("calling web service via client with company name '{}'", companyName);
			List<Company> companiesFound = client.lookupCompaniesByName(companyName, "", "");
			log.debug("web service call successful, {} companies returned", companiesFound.size());
			
			for (Company company : companiesFound) {
				
				foundCompany = true;
				boolean foundPrinciple = false;
				
				log.trace("writing company '{}' data to spreadsheet", company.getEntityName());
				writeCompanyToSs(ss, company);
				log.debug("company '{}' has {} principles", company.getEntityName(), company.getPrincipals().getPrincipal().size());
				
				for (Principal principle : company.getPrincipals().getPrincipal()) {
					
					foundPrinciple = true;
					
					log.trace("writing principle '{}' data to spreadsheet", principle.getPrincipalName());
					writePrincipleToSs(ss, principle);
					log.trace("starting a new ss row");
					ss.nextRow();
					
				}
				
				if(!foundPrinciple) {
					log.trace("no principles found in search results, starting a new ss row");
					ss.nextRow();
				}
			}
			
			if(!foundCompany) {
				log.trace("no companies found in search results, starting a new ss row");
				ss.nextRow();
			}
			
			if(currentCompanyNum % 3 == 0) {
				log.info("saving spreadsheet, to avoid data loss");
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
		log.info(text);
		mainUi.updateStatusOnUi(text);
	}
	
	private double calculatePercentComplete(int currentItemNumber, int totalItemCount) {
		double curr = (double)currentItemNumber;
		double total = (double)totalItemCount;
		return (curr - 1)/total;
	}
	
}
