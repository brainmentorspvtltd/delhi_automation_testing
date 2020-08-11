package com.brainmentors.datadriven.mycompanion.utils;

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

import com.brainmentors.datadriven.mycompanion.exceptions.DataDrivenException;
import com.brainmentors.datadriven.mycompanion.models.User;

public interface ExcelReader {
	public static List<User> readUserXLS(){
		List<User> users = new ArrayList<>();
		FileInputStream fs = null;
		HSSFWorkbook workBook = null;
		boolean isFirstRow = true;
		File file = new File(PropertyReader.getValue(Constants.XLS_PATH_KEY));
		if(!file.exists()) {
			throw new DataDrivenException("XLS File Not Exist Can't Do Data Driven "+Constants.XLS_PATH_KEY);
		}
		try {
			fs = new FileInputStream(file);
			workBook = new HSSFWorkbook(fs);
			HSSFSheet sheet = workBook.getSheetAt(0);
			Iterator<Row> rows= sheet.rowIterator();
			int cellCount = 0;
			while(rows.hasNext()) {
				User user = new User();
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
							user.setUserid(cell.getStringCellValue());
						}
						else
						if(cellCount==2) {
							user.setPassword(cell.getStringCellValue());
						}
						else
						if(cellCount==3) {
							user.setCode(cell.getStringCellValue());
						}
					}
					if(cell.getCellType()==CellType.NUMERIC) {
						if(cellCount==3) {
							user.setCode(String.valueOf((int)cell.getNumericCellValue()));
						}
					}
				} // Cell Ends
				cellCount=0;
				users.add(user);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new DataDrivenException(e.getMessage());
		}
		catch(IOException e) {
			throw new DataDrivenException(e.getMessage());
		}
		finally {
			if(workBook!=null) {
				try {
					workBook.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					throw new DataDrivenException(e.getMessage());
				}
			}
			if(fs!=null) {
				try {
					fs.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					throw new DataDrivenException(e.getMessage());
				}
			}
			
		}
		return users;
		
	}
	public static void main(String[] args) {
		List<User> users = ExcelReader.readUserXLS();
		System.out.println(users);
	}

}
