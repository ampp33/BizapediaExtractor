package org.malibu.msu.bizapedia.ss;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BizapediaReportWriter {
	
	private static final Logger log = LoggerFactory.getLogger(BizapediaReportWriter.class);
	
	private Map<String, Map<String, Integer>> sheetToHeaderColumnIndexMap = new HashMap<>();
	private Map<String, Integer> sheetToCurrentRowMap = new HashMap<>();
	
	private Workbook wb;
	
	public BizapediaReportWriter() throws IOException {
		createNewSpreadsheet();
	}
	
	public void createNewSpreadsheet() throws IOException {
		wb = new XSSFWorkbook();
		sheetToHeaderColumnIndexMap.clear();
		sheetToCurrentRowMap.clear();
	}
	
	public void saveSpreadsheet(String filePath) throws IOException {
		try(FileOutputStream fos = new FileOutputStream(new File(filePath))) {
			wb.write(fos);
		}
	}
	
	public void writeValueToColumn(String sheetName, String columnKey, String value) throws IOException {
		Map<String, Integer> headerColumnIndexMap = null;
		Sheet sheet = null;
		
		log.trace("getting sheet '{}'", sheetName);
		if(!sheetToHeaderColumnIndexMap.containsKey(sheetName)) {
			log.trace("sheet '{}' doesn't exist yet, creating it", sheetName);
			sheet = wb.createSheet(sheetName);
			
			log.trace("creating header row");
			sheet.createRow(0);
			
			sheetToHeaderColumnIndexMap.put(sheetName, new HashMap<>());
		} else {
			sheet = wb.getSheet(sheetName);
		}
		
		headerColumnIndexMap = sheetToHeaderColumnIndexMap.get(sheetName);
		
		log.trace("writing '{}' to column '{}'", value, columnKey);
		if(!headerColumnIndexMap.containsKey(columnKey)) {
			log.trace("column '{}' does not exist, adding to next available column", columnKey);
			int columnIndex = headerColumnIndexMap.size();
			Row headerRow = sheet.getRow(0);
			Cell headerCell = headerRow.createCell(columnIndex);
			headerCell.setCellValue(columnKey);
			headerColumnIndexMap.put(columnKey, columnIndex);
		}
		
		// find row and cell to write value to
		int currentRowIndex = getRowForSheet(sheetName);
		log.trace("getting row '{}'", currentRowIndex);
		Row row = sheet.getRow(currentRowIndex);
		if(row == null) {
			log.trace("row does not exist, so we'll create it");
			row = sheet.createRow(currentRowIndex);
		}
		Cell cell = row.getCell(headerColumnIndexMap.get(columnKey));
		if(cell == null) {
			cell = row.createCell(headerColumnIndexMap.get(columnKey));
		}
		
		// set cell value (obviously)
		cell.setCellValue(value);
	}
	
	public void nextRow(String sheetName) {
		log.trace("moving to the next spreadsheet row");
		sheetToCurrentRowMap.put(sheetName, getRowForSheet(sheetName) + 1);
	}
	
	private int getRowForSheet(String sheetName) {
		sheetToCurrentRowMap.putIfAbsent(sheetName, 1);
		return sheetToCurrentRowMap.get(sheetName);
	}
	
}
