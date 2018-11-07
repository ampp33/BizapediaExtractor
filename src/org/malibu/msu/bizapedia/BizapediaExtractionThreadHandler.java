package org.malibu.msu.bizapedia;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.malibu.msu.bizapedia.conversion.BizapediaConvertedApiOutput;
import org.malibu.msu.bizapedia.ss.BizapediaInputSpreadsheet;
import org.malibu.msu.bizapedia.ss.BizapediaReportWriter;
import org.malibu.msu.bizapedia.ui.BizapediaExtractorUi;
import org.malibu.msu.bizapedia.ui.BizapediaProcessorConfig;
import org.malibu.msu.bizapedia.ws.BizapediaApiMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BizapediaExtractionThreadHandler {
	
	private static final String OUTPUT_SPREADSHEET_NAME_STUB = "bizapedia-extractor-output-%d-%d.xlsx";
	private static final String COMPANY_SHEET_NAME = "companies";
	private static final String PRINCIPLES_SHEET_NAME = "principes";
	private static final String RELEVANCE_SCORES_SHEET_NAME = "relevance-scores";
	private static final String TRADEMARKS_SHEET_NAME = "trademarks";
	
	private static final Logger log = LoggerFactory.getLogger(BizapediaExtractionThreadHandler.class);
	
	private BizapediaExtractorUi mainUi;
	
	public BizapediaExtractionThreadHandler(BizapediaExtractorUi mainUi) {
		this.mainUi = mainUi;
	}
	
	public void runExtraction(BizapediaProcessorConfig config) throws EncryptedDocumentException, InvalidFormatException, IOException, BizapediaExtractorException {
		BizapediaInputSpreadsheet inputSs = new BizapediaInputSpreadsheet(new File(config.getInputFilePath()));
		verifySpreadsheetColumnsMatchApiParameters(config.getApiMethod(), inputSs);
		
		updateStatus("Beginning extraction...");
		int outputSpreadsheetStartRowNumber = -1;
		boolean resultsNotYetWrittenToFile = false;
		BizapediaReportWriter outputSs = new BizapediaReportWriter();
		try {
			Map<String, String> apiInputParameters = null;
			while((apiInputParameters = inputSs.getNextRow()) != null) {
				if(outputSpreadsheetStartRowNumber == -1) {
					// set the output spreadsheet starting row number, if it hasn't been determined yet
					outputSpreadsheetStartRowNumber = inputSs.getCurrentRowNumber();
				}
				// call API and update status and progress on UI
				updateStatus(String.format("Extracting ( %d / %d )", inputSs.getCurrentProcessableRowNumber(), inputSs.getTotalNumberOfProcessableRows()));
				mainUi.updateProgressOnUi(calculatePercentComplete(inputSs.getCurrentProcessableRowNumber(), inputSs.getTotalNumberOfProcessableRows()));
				executeApiCall(config, apiInputParameters, outputSs);
				resultsNotYetWrittenToFile = true;
				// save spreadsheet if we've hit the save interval
				if(inputSs.getCurrentProcessableRowNumber() % config.getSaveInterval() == 0) {
					log.info("saving spreadsheet to avoid data loss");
					updateStatus("Saving current spreadsheet...");
					saveOutputSpreadsheet(outputSs, config, outputSpreadsheetStartRowNumber, inputSs.getCurrentRowNumber());
					resultsNotYetWrittenToFile = false;
					outputSs.createNewSpreadsheet();
					// make sure we determine the next starting row number once the next row is read
					outputSpreadsheetStartRowNumber = -1;
				}
			}
			log.debug("done making all API calls");
		} catch (RuntimeException ex) {
			log.error("error occurred during processing, halting processing", ex);
			updateStatus("Error occurred during processing: " + ex.getMessage());
			throw new BizapediaExtractorException("Error occurred during processing: " + ex.getMessage(), ex);
		} finally {
			updateStatus("Saving current spreadsheet...");
			try {
				if(resultsNotYetWrittenToFile) {
					log.info("saving last spreadsheet to avoid data loss");
					updateStatus("Saving last spreadsheet...");
					// TODO: bug in last row number, need to figure out how to handle this, though this isn't major
					saveOutputSpreadsheet(outputSs, config, outputSpreadsheetStartRowNumber, inputSs.getCurrentRowNumber() - 1);
				}
				mainUi.updateProgressOnUi(1);
			} catch (Exception ex) {
				String userErrorMessage = "Failed to save spreadsheet!  Error: " + ex.getMessage();
				log.error("UNALBE TO SAVE SPREADSHEET.  Either the user was messing with the file, or something very bad happened!", ex);
				updateStatus(userErrorMessage);
				mainUi.updateProgressOnUi(1); // mark status bar as "complete"
				throw new BizapediaExtractorException(userErrorMessage, ex);
			}
		}
		
	}
	
	private void executeApiCall(BizapediaProcessorConfig config, Map<String, String> apiInputParameters, BizapediaReportWriter outputSs) throws IOException {
		BizapediaConvertedApiOutput apiOutput = config.getApiMethod().execute(config.getApiKey(), apiInputParameters);
		writeApiOutputToOutputSpreadsheet(outputSs, apiOutput, apiInputParameters.get(BizapediaInputSpreadsheet.UNIQUE_ID_COLUMN_NAME));
	}
	
	private void writeApiOutputToOutputSpreadsheet(BizapediaReportWriter outputSs, BizapediaConvertedApiOutput output, String uniqueRowId) throws IOException {
		writeDataToSheet(outputSs, COMPANY_SHEET_NAME, output.getCompanies(), uniqueRowId);
		writeDataToSheet(outputSs, PRINCIPLES_SHEET_NAME, output.getPrincipals(), uniqueRowId);
		writeDataToSheet(outputSs, RELEVANCE_SCORES_SHEET_NAME, output.getRelevanceScores(), uniqueRowId);
		writeDataToSheet(outputSs, TRADEMARKS_SHEET_NAME, output.getTrademarks(), uniqueRowId);
	}
	
	private void writeDataToSheet(BizapediaReportWriter outputSs, String sheetName, List<Map<String, String>> dataList, String uniqueRowId) throws IOException {
		for(Map<String, String> data : dataList) {
			outputSs.writeValueToColumn(sheetName, BizapediaInputSpreadsheet.UNIQUE_ID_COLUMN_NAME, uniqueRowId);
			for (Entry<String, String> dataEntry : data.entrySet()) {
				outputSs.writeValueToColumn(sheetName, dataEntry.getKey(), dataEntry.getValue());
			}
			outputSs.nextRow(sheetName);
		}
	}
	
	private void saveOutputSpreadsheet(BizapediaReportWriter outputSs, BizapediaProcessorConfig config, int startRowNumber, int currentRowNumber) throws IOException {
		String outputFileAbsolutePath = config.getOutputDirFilePath() + File.separator + String.format(OUTPUT_SPREADSHEET_NAME_STUB, startRowNumber, currentRowNumber);
		outputSs.saveSpreadsheet(outputFileAbsolutePath);
	}

	private void verifySpreadsheetColumnsMatchApiParameters(BizapediaApiMethod apiMethod, BizapediaInputSpreadsheet inputSs) throws BizapediaExtractorException {
		Set<String> spreadsheetParameters = new HashSet<>(inputSs.getHeaderColumnNames());
		Set<String> apiParameters = new HashSet<>(Arrays.asList(apiMethod.getInputParameters()));
		
		apiParameters.removeAll(spreadsheetParameters);
		
		if(apiParameters.size() > 0) {
			throw new BizapediaExtractorException("input spreadsheet missing the following required API parameters: " + Arrays.toString(apiParameters.toArray()));
		}
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
