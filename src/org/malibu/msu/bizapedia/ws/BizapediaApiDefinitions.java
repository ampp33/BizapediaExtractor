package org.malibu.msu.bizapedia.ws;

import java.util.List;

import org.malibu.msu.bizapedia.conversion.BizapediaConvertedApiOutput;
import org.malibu.msu.bizapedia.conversion.BizapediaObjectConverter;

import https.www_bizapedia.AddressLists;
import https.www_bizapedia.Company;
import https.www_bizapedia.CompanyPrincipal;
import https.www_bizapedia.Trademark;

public class BizapediaApiDefinitions {
	
	public static final BizapediaApiMethod LOOKUP_COMPANY_BY_COMPANY_NAME = new BizapediaApiMethod("Lookup Company By Company Name",
			(apiKey, searchParameters) -> {
				Company company = new BizapediaWsClientWrapper(apiKey).lookupCompanyByName(searchParameters.get("postalAbbreviation"), searchParameters.get("companyName"));
				return BizapediaObjectConverter.convert(company);
			},
			"postalAbbreviation", "companyName");
	
	public static final BizapediaApiMethod LOOKUP_COMPANY_BY_FILE_NUMBER = new BizapediaApiMethod("Lookup Company By File Number",
			(apiKey, searchParameters) -> {
				Company company = new BizapediaWsClientWrapper(apiKey).lookupCompanyByFileNumber(searchParameters.get("postalAbbreviation"), searchParameters.get("fileNumber"));
				return BizapediaObjectConverter.convert(company);
			},
			"postalAbbreviation", "fileNumber");
	
	public static final BizapediaApiMethod LOOKUP_COMPANIES_BY_COMPANY_NAME = new BizapediaApiMethod("Lookup Companies By Company Name",
			(apiKey, searchParameters) -> {
				List<Company> companies = new BizapediaWsClientWrapper(apiKey).lookupCompaniesByName(searchParameters.get("companyName"), searchParameters.get("cityName"), searchParameters.get("postalAbbreviation"));
				BizapediaConvertedApiOutput results = new BizapediaConvertedApiOutput();
				for (Company company : companies) {
					results.addAll(BizapediaObjectConverter.convert(company));
				}
				return results;
			},
			"postalAbbreviation", "companyName", "cityName");
	
	public static final BizapediaApiMethod LOOKUP_COMPANIES_BY_PEOPLE = new BizapediaApiMethod("Lookup Companies By People",
			(apiKey, searchParameters) -> {
				List<CompanyPrincipal> companyPrinciples = new BizapediaWsClientWrapper(apiKey).lookupPeople(searchParameters.get("firstName"), searchParameters.get("lastName"), searchParameters.get("cityName"), searchParameters.get("postalAbbreviation"));
				BizapediaConvertedApiOutput results = new BizapediaConvertedApiOutput();
				for (CompanyPrincipal companyPrinciple : companyPrinciples) {
					results.addAll(BizapediaObjectConverter.convert(companyPrinciple));
				}
				return results;
			},
			"postalAbbreviation", "firstName", "lastName", "cityName");
	
	public static final BizapediaApiMethod LOOKUP_TRADEMARKS = new BizapediaApiMethod("Lookup Trademarks",
			(apiKey, searchParameters) -> {
				List<Trademark> trademarks = new BizapediaWsClientWrapper(apiKey).lookupTrademarks(searchParameters.get("trademarkMarkIdentification"), searchParameters.get("trademarkOwnerName"));
				BizapediaConvertedApiOutput results = new BizapediaConvertedApiOutput();
				for (Trademark trademark : trademarks) {
					results.addAll(BizapediaObjectConverter.convert(trademark));
				}
				return results;
			},
			"trademarkMarkIdentification", "trademarkOwnerName");
	
	public static final BizapediaApiMethod LOOKUP_ADDRESSES = new BizapediaApiMethod("Lookup Addresses",
			(apiKey, searchParameters) -> {
				AddressLists addressLists = new BizapediaWsClientWrapper(apiKey).lookupAddresses(searchParameters.get("address"), searchParameters.get("cityName"), searchParameters.get("postalAbbreviation"), searchParameters.get("postalCode"));
				return BizapediaObjectConverter.convert(addressLists);
			},
			"address", "cityName", "postalAbbreviation", "postalCode");
	
}
