package org.malibu.msu.bizapedia.conversion;

import https.www_bizapedia.AddressLists;
import https.www_bizapedia.Company;
import https.www_bizapedia.CompanyPrincipal;
import https.www_bizapedia.Principal;
import https.www_bizapedia.Trademark;

public class BizapediaObjectConverter {
	
	public static BizapediaConvertedApiOutput convert(Company company) {
		BizapediaConvertedApiOutput output = new BizapediaConvertedApiOutput();
		if(company != null) {
			output.getCompanies().addAll(convertJustCompany(company).getCompanies());
			if(company.getPrincipals() != null) {
				for (Principal principal : company.getPrincipals().getPrincipal()) {
					output.getPrincipals().addAll(convert(principal).getPrincipals());
				}
			}
		}
		return output;
	}
	
	public static BizapediaConvertedApiOutput convertJustCompany(Company company) {
		BizapediaConvertedApiOutput output = new BizapediaConvertedApiOutput();
		if(company != null) {
			output.getCompanies().add(ObjectConverter.convertObjectToMap(company, "success", "errorMessage", "principals"));
		}
		return output;
	}
	
	public static BizapediaConvertedApiOutput convert(Principal principal) {
		BizapediaConvertedApiOutput output = new BizapediaConvertedApiOutput();
		if(principal != null) {
			output.getPrincipals().add(ObjectConverter.convertObjectToMap(principal));
		}
		return output;
	}
	
	public static BizapediaConvertedApiOutput convert(CompanyPrincipal companyPrinciple) {
		BizapediaConvertedApiOutput output = new BizapediaConvertedApiOutput();
		if(companyPrinciple != null) {
			if(companyPrinciple.getCompany() != null) {
				// all principals will be inside the single Principal object, and not within the Company principals array
				output.getCompanies().addAll(convertJustCompany(companyPrinciple.getCompany()).getCompanies());
			}
			if(companyPrinciple.getPrincipal() != null) {
				output.getPrincipals().addAll(convert(companyPrinciple.getPrincipal()).getPrincipals());
			}
			output.getRelevanceScores().add(ObjectConverter.convertObjectToMap(companyPrinciple, "principal", "company"));
		}
		return output;
	}
	
	public static BizapediaConvertedApiOutput convert(Trademark trademark) {
		BizapediaConvertedApiOutput output = new BizapediaConvertedApiOutput();
		if(trademark != null) {
			// TODO: exclude all the XML, or further parse this data?
			output.getTrademarks().add(ObjectConverter.convertObjectToMap(trademark, "principal", "company"));
		}
		return output;
	}
	
	public static BizapediaConvertedApiOutput convert(AddressLists addressLists) {
		BizapediaConvertedApiOutput output = new BizapediaConvertedApiOutput();
		if(addressLists != null) {
			if(addressLists.getCompanies() != null && addressLists.getCompanies().getCompany() != null) {
				for(Company company : addressLists.getCompanies().getCompany()) {
					output.getCompanies().addAll(convertJustCompany(company).getCompanies());
				}
			}
			if(addressLists.getCompanyPrincipals() != null && addressLists.getCompanyPrincipals().getCompanyPrincipal() != null) { 
				for (CompanyPrincipal companyPrinciple : addressLists.getCompanyPrincipals().getCompanyPrincipal()) {
					// this company isn't necessary, since it's identical to the companies above,
					// except that it doens't have relevance score populated
//					if(companyPrinciple.getCompany() != null) {
//						output.getCompanies().addAll(convert(companyPrinciple.getCompany()).getCompanies());
//					}
					if(companyPrinciple.getPrincipal() != null) {
						output.getPrincipals().addAll(convert(companyPrinciple.getPrincipal()).getPrincipals());
					}
					output.getRelevanceScores().add(ObjectConverter.convertObjectToMap(companyPrinciple, "principal", "company"));
				}
			}
			if(addressLists.getTrademarks() != null && addressLists.getTrademarks().getTrademark() != null) {
				for(Trademark trademark : addressLists.getTrademarks().getTrademark()) {
					output.getTrademarks().addAll(convert(trademark).getTrademarks());
				}
			}
			// TODO: what will be contained within the company principal?  more companies?  any valid principals?
			// from what I've seen company principle WILL be populated with Company, Principle, and Relevance Score
			// not sure if the Company object matches the Company Principle Object though.  I ASSUME it does.
		}
		return output;
	}
	
}
