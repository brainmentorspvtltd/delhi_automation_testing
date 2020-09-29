package com.tpddl.appiumtesting.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

import com.tpddl.appiumtesting.models.CommandDO;

public class ExcelReader {
	
	public static void main(String[] args) throws IOException {
		List<CommandDO> list = readCommands();
		
		System.out.println(list);
		System.out.println("*****************************************");
		System.out.println(readData(1));
	}
	
	public static List<Map<String, Object>> readData(int sheetNo) throws IOException{
		List<Map<String, Object>> dataList = new ArrayList<>();
		FileInputStream fs = null;
		HSSFWorkbook workBook = null;
		ArrayList<String> headers = new ArrayList<>();
		try {
		File file = new File(PropertyReader.getValue(Constants.XLS_PATH));
		
		if(!file.exists()) {
			throw new RuntimeException("XLS Path Not Exist....");
		}
		fs = new FileInputStream(file);
		boolean isFirstRow = false;
		workBook = new HSSFWorkbook(fs);
		HSSFSheet commandSheet = workBook.getSheetAt(sheetNo);
		Iterator<Row> rows = commandSheet.rowIterator();
		while(rows.hasNext()) {
			Row currentRow = rows.next();
			// Reading Data Headers
			if(!isFirstRow) {
				Iterator<Cell> cellIterator = currentRow.cellIterator();
				while(cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					if(cell.getCellType()==CellType.STRING) {
						headers.add(cell.getStringCellValue());
					}
				}
				isFirstRow = true;
				System.out.println("Headers are "+headers);
				continue; // Skip Current Iteration
				
			}
			// Read Data
			int currentCellIndex = 0;
			Iterator<Cell> cells= currentRow.cellIterator();
			Object value = null;
			Map<String, Object> map = new HashMap<>();
			while(cells.hasNext()) {
				String key = headers.get(currentCellIndex);
				Cell cell = cells.next();
				if(cell.getCellType()==CellType.STRING) {
					value = cell.getStringCellValue();
				}
				else
				if(cell.getCellType()==CellType.NUMERIC) {
					value = cell.getNumericCellValue();
				}
				map.put(key, value);
				currentCellIndex++;
			} // Cells Loop End
			
			dataList.add(map);	
		} // row loop ends
		} 
		finally {
			if(workBook!=null) {
				workBook.close();
			}
			if(fs!=null) {
				fs.close();
			}
		}
		return dataList;
	}	
	
	public static List<CommandDO> readCommands() throws IOException{
		List<CommandDO> commandList = new ArrayList<>();
		FileInputStream fs = null;
		HSSFWorkbook workBook = null;
		try {
		File file = new File(PropertyReader.getValue(Constants.XLS_PATH));
		int maxcells = PropertyReader.getIntValue(Constants.MAX_CELLS);
		if(!file.exists()) {
			throw new RuntimeException("XLS Path Not Exist....");
		}
		fs = new FileInputStream(file);
		boolean isFirstRow = false;
		workBook = new HSSFWorkbook(fs);
		HSSFSheet commandSheet = workBook.getSheetAt(0);
		Iterator<Row> rows = commandSheet.rowIterator();
		while(rows.hasNext()) {
			Row currentRow = rows.next();
			
			if(!isFirstRow) {
				isFirstRow = true;
				continue; // Skip Current Iteration
				
			}
			CommandDO commandDO = new CommandDO();
			//currentRow.cellIterator(); // if cells are not blank
			for(int cellCount = 0; cellCount<=maxcells; cellCount++) {
				Cell cell = currentRow.getCell(cellCount,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
				if(cell.getCellType()==CellType._NONE || cell.getCellType()==CellType.BLANK) {
					continue;
				}
				if (cell.getCellType() == CellType.STRING) {
					if (cellCount == 0) {
						commandDO.setCommand(cell.getStringCellValue());
					} else if (cellCount == 1) {
						commandDO.setTarget(cell.getStringCellValue());
					} else if (cellCount == 2) {
						commandDO.setValue(cell.getStringCellValue());
					} else if (cellCount == 3) {
						commandDO.setType(cell.getStringCellValue());
					}
				}
			}  // Cell Loop Ends
			commandList.add(commandDO);
				
		} // row loop ends
		} 
		finally {
			if(workBook!=null) {
				workBook.close();
			}
			if(fs!=null) {
				fs.close();
			}
		}
		return commandList;
	}	

}
