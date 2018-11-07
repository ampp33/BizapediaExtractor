package org.malibu.msu.bizapedia.ss;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.malibu.msu.bizapedia.BizapediaExtractorException;

public class BizapediaInputSpreadsheet {
	
	public static final String UNIQUE_ID_COLUMN_NAME = "row-id";
	private static final String UNIQUE_ID_STUB = "%s-%d";
	
	private Workbook wb;
	private DataFormatter dataFormatter = new DataFormatter();
	private Map<Integer, String> columnIndexToHeaderLabelMap = new LinkedHashMap<>();
	private int currentRowIndex = 0;
	private int currentProcessableRowNumber = 0;
	private int totalNumberOfProcessableRows = 0;
	
	public BizapediaInputSpreadsheet(File inputSpreadsheet) throws EncryptedDocumentException, InvalidFormatException, IOException, BizapediaExtractorException {
		wb = WorkbookFactory.create(inputSpreadsheet);
		buildColumnIndexLabelMap();
		updateInputSpreadsheetWithUniqueIds();
	}
	
	public List<String> getHeaderColumnNames() {
		return new LinkedList<>(columnIndexToHeaderLabelMap.values());
	}
	
	public int getCurrentRowNumber() {
		return getRowNumberFromRowIndex(currentRowIndex);
	}
	
	public int getCurrentProcessableRowNumber() {
		return currentProcessableRowNumber;
	}
	
	public int getTotalNumberOfProcessableRows() {
		return totalNumberOfProcessableRows;
	}
	
	public Map<String, String> getNextRow() {
		Sheet sheet = wb.getSheetAt(0);
		Row row = null;
		// move to the next row
		currentRowIndex++;
		// attempt to read rows until we find a non-null one or we run out of rows in the sheet
		while((row = sheet.getRow(currentRowIndex)) == null && currentRowIndex + 1 <= sheet.getPhysicalNumberOfRows()) currentRowIndex++;
		// if no more rows found, return null to signal we're at the end of the file
		if(row == null) return null;
		currentProcessableRowNumber++;
		Map<String, String> rowData = new HashMap<>();
		for(Entry<Integer, String> headerIndexToHeaderLabel : columnIndexToHeaderLabelMap.entrySet()) {
			Cell cell = row.getCell(headerIndexToHeaderLabel.getKey());
			rowData.put(headerIndexToHeaderLabel.getValue(), getCellValueOrEmptyString(cell));
		}
		// add the unique column id to the row data
		rowData.put(UNIQUE_ID_COLUMN_NAME, getCellValueOrEmptyString(row.getCell(0)));
		return rowData;
	}
	
	private void buildColumnIndexLabelMap() throws IOException {
		if(wb.getNumberOfSheets() == 0) {
			throw new IOException("input spreadsheet contains no sheets");
		}
		Sheet sheet = wb.getSheetAt(0);
		if(sheet.getPhysicalNumberOfRows() == 0) {
			throw new IOException("input spreadsheet conatins a sheet with no rows");
		}
		Row labelRow = sheet.getRow(0);
		if(labelRow.getPhysicalNumberOfCells() == 0) {
			throw new IOException("input spreadsheet conatins a header row with no labels, which are required");
		}
		for(int columnIndex = 0; columnIndex < labelRow.getLastCellNum(); columnIndex++) {
			String cellValue = getCellValueOrEmptyString(labelRow.getCell(columnIndex));
			if(StringUtils.isNotBlank(cellValue)) {
				columnIndexToHeaderLabelMap.put(columnIndex, cellValue);
			}
		}
	}
	
	private void updateInputSpreadsheetWithUniqueIds() throws BizapediaExtractorException {
		Sheet sheet = wb.getSheetAt(0);
		for(int rowIndex = 0; rowIndex < sheet.getPhysicalNumberOfRows(); rowIndex++) {
			final Row row = sheet.getRow(rowIndex);
			if(row == null) continue;
			
			// look at each column with a header label in reverse order, getting each cell value as we go, and shifting it to the right
			List<Integer> reversedColumnIndexes = new ArrayList<Integer>(columnIndexToHeaderLabelMap.keySet());
			Collections.reverse(reversedColumnIndexes);
			reversedColumnIndexes.forEach((columnIndex) -> {
				setCellValueOrCreateCellAndSetValue(row, columnIndex + 1, getCellValueOrEmptyString(row.getCell(columnIndex)));
				// clear the pre-shifted cell's value
				setCellValueIfCellExists(row.getCell(columnIndex), "");
			});
			
			// set the first column value to be the unique id column label or a unique id, depending on whether or not we're processing the header row
			setCellValueOrCreateCellAndSetValue(row, 0, rowIndex == 0 ? UNIQUE_ID_COLUMN_NAME : generateRandomUniqueRowId(getRowNumberFromRowIndex(rowIndex)));
			
			if(rowIndex != 0) {
				totalNumberOfProcessableRows++;
			}
			
		}
		
		// update our map of column indexes to be shifted one cell to the right, since we just shifted all the columns!
		List<Integer> reversedColumnIndexes = new ArrayList<Integer>(columnIndexToHeaderLabelMap.keySet());
		Collections.reverse(reversedColumnIndexes);
		reversedColumnIndexes.forEach((columnIndex) -> {
			columnIndexToHeaderLabelMap.put(columnIndex + 1, columnIndexToHeaderLabelMap.remove(columnIndex));
		});
		
	}

	private String getCellValueOrEmptyString(Cell cell) {
		return (cell == null ? "" : dataFormatter.formatCellValue(cell));
	}
	
	private void setCellValueIfCellExists(Cell cell, String value) {
		if(cell != null) {
			cell.setCellValue(value);
		}
	}
	
	private void setCellValueOrCreateCellAndSetValue(Row row, int columnIndex, String value) {
		if(row.getCell(columnIndex) == null) {
			row.createCell(columnIndex);
		}
		row.getCell(columnIndex).setCellValue(value);
	}
	
	private int getRowNumberFromRowIndex(int rowIndex) {
		return rowIndex + 1;
	}
	
	private String generateRandomUniqueRowId(int rowIndex) {
		String uniqueId = UUID.randomUUID().toString().split("\\-")[0];
		return String.format(UNIQUE_ID_STUB, uniqueId, rowIndex);
	}
	
}
