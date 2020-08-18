package com.brainmentors.keyworddriven.keyworddriven.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import com.brainmentors.keyworddriven.keyworddriven.exceptions.KeywordDrivenException;
import com.brainmentors.keyworddriven.keyworddriven.models.CommandDO;



public interface ExcelReader {
	
	public static void main(String[] args) {
		readCommandsMultiSheets();
	}
	
	public static LinkedHashMap<String, List<CommandDO>> readCommandsMultiSheets(){
		List<CommandDO> commands = null;
		LinkedHashMap<String, List<CommandDO>> map = new LinkedHashMap<>();
		FileInputStream fs = null;
		HSSFWorkbook workBook = null;
		boolean isFirstRow = true;
		int totalCell = Integer.parseInt(PropertyReader.getValue(Constants.MAXCELLS));
		File file = new File(PropertyReader.getValue(Constants.XLS_PATH_KEY));
		if(!file.exists()) {
			throw new KeywordDrivenException("XLS File Not Exist Can't Do Keyword Driven "+Constants.XLS_PATH_KEY);
		}
		try {
			fs = new FileInputStream(file);
			workBook = new HSSFWorkbook(fs);
			Iterator<Sheet> sheets = workBook.sheetIterator();
			//HSSFSheet sheet = workBook.getSheetAt(0);
			while(sheets.hasNext()) {
				commands = new ArrayList<>();
				Sheet sheet = sheets.next();
			
			Iterator<Row> rows= sheet.rowIterator();
			//int cellCount = 0;
			while(rows.hasNext()) {
				CommandDO command = new CommandDO();
				
				Row currentRow = rows.next();
				if(isFirstRow) { // Heading Skip
					isFirstRow = false;
					continue;
				}
				
				//Iterator<Cell> cells = currentRow.cellIterator();
				
				for(int cellCount  = 0; cellCount<=totalCell; cellCount++ ) {
					Cell cell = currentRow.getCell(cellCount, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
					
				//while(cells.hasNext()){
					//Cell cell = cells.next();
					//cellCount++;
					//System.out.println("TYPE OF CELL IS "+cell.getStringCellValue());
					//Cell temp = currentRow.getCell(i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
					//System.out.println("Temp is "+temp.getCellType());
					if(cell.getCellType()==CellType.BLANK) {
						System.out.println("BLANK CELL "+cellCount);
						continue;
					}
//					
//					if(cell.getCellType()==CellType._NONE || 
////							cell.getCellType()==CellType.BLANK ) {
////						System.out.println("######## I am in Blank Cell");
////						continue;
////					}
					if(cell.getCellType()==CellType.STRING) {
						if(cellCount==0) {
							command.setCommand(cell.getStringCellValue());
						}
						else
						if(cellCount==1) {
							command.setTarget(cell.getStringCellValue());
						}
						else
						if(cellCount==2) {
							command.setValue(cell.getStringCellValue());
						}
					}
					if(cell.getCellType()==CellType.NUMERIC) {
						if(cellCount==2) {
							command.setValue(String.valueOf((int)cell.getNumericCellValue()));
						}
					}
				} // Cell Ends
				System.out.println("ROW ENDS");
				//cellCount=0;
				commands.add(command);
			}
			map.put(sheet.getSheetName(),commands);
			}	// Sheet Ends
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
		System.out.println("::::Commands From XLS "+map);
		return map;
		
	}
	
	public static List<CommandDO> readCommandsXLS(){
		List<CommandDO> commands = new ArrayList<>();
		FileInputStream fs = null;
		HSSFWorkbook workBook = null;
		boolean isFirstRow = true;
		int totalCell = Integer.parseInt(PropertyReader.getValue(Constants.MAXCELLS));
		File file = new File(PropertyReader.getValue(Constants.XLS_PATH_KEY));
		if(!file.exists()) {
			throw new KeywordDrivenException("XLS File Not Exist Can't Do Keyword Driven "+Constants.XLS_PATH_KEY);
		}
		try {
			fs = new FileInputStream(file);
			workBook = new HSSFWorkbook(fs);
			HSSFSheet sheet = workBook.getSheetAt(0);
			Iterator<Row> rows= sheet.rowIterator();
			//int cellCount = 0;
			while(rows.hasNext()) {
				CommandDO command = new CommandDO();
				
				Row currentRow = rows.next();
				if(isFirstRow) { // Heading Skip
					isFirstRow = false;
					continue;
				}
				
				//Iterator<Cell> cells = currentRow.cellIterator();
				
				for(int cellCount  = 0; cellCount<=totalCell; cellCount++ ) {
					Cell cell = currentRow.getCell(cellCount, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
					
				//while(cells.hasNext()){
					//Cell cell = cells.next();
					//cellCount++;
					//System.out.println("TYPE OF CELL IS "+cell.getStringCellValue());
					//Cell temp = currentRow.getCell(i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
					//System.out.println("Temp is "+temp.getCellType());
					if(cell.getCellType()==CellType.BLANK) {
						System.out.println("BLANK CELL "+cellCount);
						continue;
					}
//					
//					if(cell.getCellType()==CellType._NONE || 
////							cell.getCellType()==CellType.BLANK ) {
////						System.out.println("######## I am in Blank Cell");
////						continue;
////					}
					if(cell.getCellType()==CellType.STRING) {
						if(cellCount==0) {
							command.setCommand(cell.getStringCellValue());
						}
						else
						if(cellCount==1) {
							command.setTarget(cell.getStringCellValue());
						}
						else
						if(cellCount==2) {
							command.setValue(cell.getStringCellValue());
						}
					}
					if(cell.getCellType()==CellType.NUMERIC) {
						if(cellCount==2) {
							command.setValue(String.valueOf((int)cell.getNumericCellValue()));
						}
					}
				} // Cell Ends
				System.out.println("ROW ENDS");
				//cellCount=0;
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
		System.out.println("::::Commands From XLS "+commands);
		return commands;
		
	}
}
