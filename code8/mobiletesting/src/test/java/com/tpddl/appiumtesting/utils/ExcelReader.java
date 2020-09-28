package com.tpddl.appiumtesting.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
