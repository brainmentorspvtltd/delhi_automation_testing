package com.brainmentors.keyworddriven.keyworddriven.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

import com.brainmentors.keyworddriven.keyworddriven.exceptions.KeywordDrivenException;
import com.brainmentors.keyworddriven.keyworddriven.models.CommandDO;



public interface ExcelReader {
	public static List<CommandDO> readCommandsXLS(){
		List<CommandDO> commands = new ArrayList<>();
		FileInputStream fs = null;
		HSSFWorkbook workBook = null;
		boolean isFirstRow = true;
		File file = new File(PropertyReader.getValue(Constants.XLS_PATH_KEY));
		if(!file.exists()) {
			throw new KeywordDrivenException("XLS File Not Exist Can't Do Keyword Driven "+Constants.XLS_PATH_KEY);
		}
		try {
			fs = new FileInputStream(file);
			workBook = new HSSFWorkbook(fs);
			HSSFSheet sheet = workBook.getSheetAt(0);
			Iterator<Row> rows= sheet.rowIterator();
			int cellCount = 0;
			while(rows.hasNext()) {
				CommandDO command = new CommandDO();
				Row currentRow = rows.next();
				if(isFirstRow) { // Heading Skip
					isFirstRow = false;
					continue;
				}
				Iterator<Cell> cells = currentRow.cellIterator();
				while(cells.hasNext()){
					Cell cell = cells.next();
					cellCount++;
					if(cell.getCellType()==CellType.STRING) {
						if(cellCount==1) {
							command.setCommand(cell.getStringCellValue());
						}
						else
						if(cellCount==2) {
							command.setTarget(cell.getStringCellValue());
						}
						else
						if(cellCount==3) {
							command.setValue(cell.getStringCellValue());
						}
					}
					if(cell.getCellType()==CellType.NUMERIC) {
						if(cellCount==3) {
							command.setValue(String.valueOf((int)cell.getNumericCellValue()));
						}
					}
				} // Cell Ends
				cellCount=0;
				commands.add(command);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new KeywordDrivenException(e.getMessage());
		}
		catch(IOException e) {
			throw new KeywordDrivenException(e.getMessage());
		}
		finally {
			if(workBook!=null) {
				try {
					workBook.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					throw new KeywordDrivenException(e.getMessage());
				}
			}
			if(fs!=null) {
				try {
					fs.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					throw new KeywordDrivenException(e.getMessage());
				}
			}
			
		}
		return commands;
		
	}
}
