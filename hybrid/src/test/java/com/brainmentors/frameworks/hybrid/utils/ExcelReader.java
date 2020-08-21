package com.brainmentors.frameworks.hybrid.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

import com.brainmentors.frameworks.hybrid.exceptions.ExcelReaderException;
import com.brainmentors.frameworks.hybrid.models.CommandDO;




public interface ExcelReader {
	public static void main(String[] args) {
		ArrayList<Map<String,Object>> list = ExcelReader.readDataXLS(1);
		System.out.println(list);
	}
	
	public static List<CommandDO> readCommandsXLS(){
		List<CommandDO> commands = new ArrayList<>();
		FileInputStream fs = null;
		HSSFWorkbook workBook = null;
		boolean isFirstRow = true;
		int totalCell = Integer.parseInt(PropertyReader.getValue(Constants.MAXCELLS));
		File file = new File(PropertyReader.getValue(Constants.XLS_PATH_KEY));
		if(!file.exists()) {
			throw new ExcelReaderException("XLS File Not Exist Can't Do Keyword Driven "+Constants.XLS_PATH_KEY);
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
						//System.out.println("BLANK CELL "+cellCount);
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
						else
						if(cellCount==3) {
							command.setType(cell.getStringCellValue());
						}
					}
					if(cell.getCellType()==CellType.NUMERIC) {
						if(cellCount==2) {
							command.setValue(String.valueOf((int)cell.getNumericCellValue()));
						}
					}
				} // Cell Ends
				//System.out.println("ROW ENDS");
				//cellCount=0;
				commands.add(command);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new ExcelReaderException(e.getMessage());
		}
		catch(IOException e) {
			throw new ExcelReaderException(e.getMessage());
		}
		finally {
			if(workBook!=null) {
				try {
					workBook.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					throw new ExcelReaderException(e.getMessage());
				}
			}
			if(fs!=null) {
				try {
					fs.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					throw new ExcelReaderException(e.getMessage());
				}
			}
			
		}
		System.out.println("::::Commands From XLS "+commands);
		return commands;
		
	}

	public static ArrayList<Map<String,Object>> readDataXLS(int sheetNo) {
		FileInputStream fs = null;
		HSSFWorkbook workBook = null;
		boolean isHeader = true;
		ArrayList<Map<String,Object>> list = new ArrayList<>();
		ArrayList<String> columns = new ArrayList<>();
		int currentColumn = 0;
		
		File file = new File(PropertyReader.getValue(Constants.XLS_PATH_KEY));
		if(!file.exists()) {
			throw new ExcelReaderException("XLS File Not Exist Can't Do Keyword Driven "+Constants.XLS_PATH_KEY);
		}
		try {
			fs = new FileInputStream(file);
			workBook = new HSSFWorkbook(fs);
			HSSFSheet sheet = workBook.getSheetAt(sheetNo);
			Iterator<Row> rows= sheet.rowIterator();
			
			while(rows.hasNext()) {
				Row row = rows.next();
				
				if(isHeader) {
					Iterator<Cell> cells  = row.cellIterator();
					while(cells.hasNext()) {
						Cell cell = cells.next();
						columns.add(cell.getStringCellValue());
					}
					System.out.println("Headers are "+columns);
					isHeader = false;
					continue;
				}
				// Data Read
				HashMap<String, Object> map = new HashMap<>();
				Iterator<Cell> cells  = row.cellIterator();
				while(cells.hasNext()) {
					String key = columns.get(currentColumn);
					Object value = null;
					Cell cell = cells.next();
					if(cell.getCellType()==CellType.STRING) {
						value = cell.getStringCellValue();
					}
					else
					if(cell.getCellType()==CellType.NUMERIC) {
						value = (int)cell.getNumericCellValue();
					}
					map.put(key, value);
					currentColumn++;
					
				}
				currentColumn = 0;
				list.add(map);
				
			}
	}
		catch(IOException e) {
			throw new ExcelReaderException("IO Exception in XLS Reader "+e);
		}
		finally {
			try {
			if(workBook!=null) {
				workBook.close();
			}
			if(fs!=null) {
				fs.close();
			}
			}
			catch(Exception e) {
				throw new ExcelReaderException("XLS Exception During Close "+e);
			}
		}
		return list;
	}
		
}
