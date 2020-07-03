package filedemos;


import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ResourceBundle;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;

public class ExcelWriter {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ResourceBundle rb = ResourceBundle.getBundle("config");
		String path = rb.getString("xlspath");
		File file = new File(path);
		if(file.exists()) {
			FileInputStream fs = new FileInputStream(file);
			//FileOutputStream fs = new FileOutputStream(file, true);
			HSSFWorkbook workBook = new HSSFWorkbook(fs);	
			HSSFSheet sheet = workBook.getSheetAt(1);
			Row row = sheet.createRow(1);
			row.createCell(0).setCellValue("Amit");
			Cell cell1 = row.createCell(1);
			cell1.setCellValue("RAM");
			
			CellStyle style = workBook.createCellStyle();
			style.setAlignment(HorizontalAlignment.CENTER);
			style.setWrapText(true);
//			HSSFColor myColor= new HSSFColor();
//			int index1 = myColor.getIndex();
//			int index2 = myColor.getIndex2();
//			HSSFColor myColor2= 
//					new HSSFColor(index1, index2, Color.CYAN);
			
			//style.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
		    
		    cell1.setCellStyle(style);
			
			FileOutputStream fo = new FileOutputStream(file);
			workBook.write(fo);
			workBook.close();
			fo.close();
			fs.close();
			System.out.println("Write Done...");
//			Cell cell2 = row.createCell(0);
//			Cell cell3 = row.createCell(0);
//			Cell cell4 = row.createCell(0);
			
			
		}

	}

}
