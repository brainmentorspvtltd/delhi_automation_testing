package filedemos;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.ResourceBundle;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

public class ExcelReader {

	public static void main(String[] args) throws IOException {
		ResourceBundle rb = ResourceBundle.getBundle("config");
		String path = rb.getString("xlspath");
		File file = new File(path);
		if(file.exists()) {
			FileInputStream fs = new FileInputStream(file);
			// xlsx
			//XSSFWorkbook workBook = new XSSFWorkbook(fs);
			// xls
			HSSFWorkbook workBook = new HSSFWorkbook(fs);
			
			HSSFSheet sheet = workBook.getSheetAt(0); //workBook.getSheet("")
			Iterator<Row> rows = sheet.rowIterator();
			while(rows.hasNext()) {
				Row currentRow = rows.next(); // give current and move to next
				Iterator<Cell> cells = currentRow.cellIterator();
				while(cells.hasNext()) {
					Cell currentCell = cells.next(); // give current and move to next
					if(CellType.BLANK==currentCell.getCellType()) {
						System.out.println("This Cell is Blank");
						
					}
					if(CellType.STRING== currentCell.getCellType()) {
						System.out.print(currentCell.getStringCellValue()+" ");
					}
					else
					if(CellType.NUMERIC==currentCell.getCellType()) {
						System.out.print(currentCell.getNumericCellValue()+" ");
					}
				} // cells ends
				System.out.println();
			} // rows ends
			workBook.close();
			fs.close();
			
		}
		else {
			System.out.println("XLS File Path Not Found...");
		}
		
	}

}
