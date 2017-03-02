package org.malibu.msu.bizapedia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BizapediaReportSpreadsheet {
	
	private static final Logger log = LoggerFactory.getLogger(BizapediaReportSpreadsheet.class);
	
	public static final String TEMPLATE_FILE_PATH = "\\resources\\template.xlsx";
	
	private Map<String, Integer> headerToColumnIndexMap = new HashMap<>();
	
	private Workbook wb;
	private Sheet sheet;
	private int currentRowIndex;
	
	public BizapediaReportSpreadsheet() throws IOException, EncryptedDocumentException, InvalidFormatException {
		initializeFromTemplate();
	}
	
	public void writeValueToColumn(String columnKey, String value) throws IOException {
		log.trace("writing '{}' to column '{}'", value, columnKey);
		if(!headerToColumnIndexMap.containsKey(columnKey)) {
			throw new IOException("bad mapping; mapping config file does not correllate to template file.  bad key: " + columnKey);
		}
		
		// find cell to write value to (will probably need to create it)
		Row row = sheet.getRow(currentRowIndex);
		Cell cell = row.getCell(headerToColumnIndexMap.get(columnKey));
		if(cell == null) {
			cell = row.createCell(headerToColumnIndexMap.get(columnKey));
		}
		
		// set cell value (obviously)
		cell.setCellValue(value);
	}
	
	public void nextRow() {
		log.trace("moving to the next spreadsheet row");
		currentRowIndex++;
		sheet.createRow(currentRowIndex);
	}
	
	public void saveSpreadsheet(String outputFilePath) throws IOException {
		log.info("saving spreadsheet to filesystem");
		try(FileOutputStream fos = new FileOutputStream(new File(outputFilePath))) {
			wb.write(fos);
		}
	}
	
	public int getCurrentRowIndex() {
		return currentRowIndex;
	}
	
	private void initializeFromTemplate() throws EncryptedDocumentException, InvalidFormatException, IOException {
		log.debug("initializing output spreadsheet from file: '{}'", System.getProperty("workingDir") + TEMPLATE_FILE_PATH);
		try(InputStream templateFileStream = new FileInputStream(new File(System.getProperty("workingDir") + TEMPLATE_FILE_PATH))) {
			wb = WorkbookFactory.create(templateFileStream);
			sheet = wb.getSheetAt(0); // get first sheet
			Row headerRow = sheet.getRow(1); // row with labels
			
			// build up map of headers to column indexes
			for(Cell headerCell : headerRow) {
				headerToColumnIndexMap.put(headerCell.getStringCellValue(), headerCell.getColumnIndex());
			}
			
			currentRowIndex = 1;
			nextRow(); // prep to start writing rows!
		}
	}
	
}
