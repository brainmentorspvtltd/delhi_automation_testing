package com.brainmentors.datadriven.mycompanion.utils;

import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public interface PDFReader {
	public static boolean writePDF(String msg) throws DocumentException, IOException {
		String path = PropertyReader.getValue(Constants.PDF_REPORT_KEY);
		FileOutputStream fo = new FileOutputStream(path);
		Document doc = new Document();
		
		PdfWriter write =  PdfWriter.getInstance(doc, fo);
		doc.open();
		Paragraph para = new Paragraph(msg);
		//Paragraph para = new Paragraph("Hello This is a PDF iText Example , We write data in a pdf file");
		Image image = Image.getInstance("/Users/amit/Documents/rocket.png");
		image.scaleToFit(100, 100);
		image.setAlt("Image Missing");
		doc.add(image);
		para.setFont(new Font(FontFamily.COURIER.TIMES_ROMAN, 30f));
		para.setAlignment(1);
		//doc.add(new Paragraph("Hello World!"));
		doc.add(para);
		doc.close();
		write.close();
		fo.close();
		System.out.println("PDF Write....");
		return true;
	}
	public static void main(String[] args) throws DocumentException, IOException {
		//PDFReader.writePDF();
	}

}
