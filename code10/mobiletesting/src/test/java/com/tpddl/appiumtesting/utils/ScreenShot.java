package com.tpddl.appiumtesting.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.tpddl.appiumtesting.helpers.Command;

public class ScreenShot {
	private static String filePath ;
	public static String getFilePath() {
		return filePath;
	}
	private static String getFileName(){
		Date date = new Date();
		SimpleDateFormat sf =  new SimpleDateFormat("dd_MMM_yyy_hh_mm_ssaa");
		String formattedDate = sf.format(date);
		return formattedDate+".png";
	}

	public static String takeScreenShot() throws IOException {
		final int EOF = -1;
		String location = PropertyReader.getValue(Constants.SCREENSHOT_LOCATION);
		File sourcePath = Command.takeScreenShot();
		File targetPath = new File(location+"/"+getFileName());
		
		FileInputStream fs = new FileInputStream(sourcePath);
		BufferedInputStream bs = new BufferedInputStream(fs);
		FileOutputStream fo = new FileOutputStream(targetPath);
		BufferedOutputStream bo = new BufferedOutputStream(fo);
		int singleByte = bs.read();
		while(singleByte!=EOF) {
			bo.write(singleByte);
			singleByte = bs.read();
		}
		bs.close();
		bo.close();
		fs.close();
		fo.close();
		filePath = targetPath.getAbsolutePath();
		return "ScreenShot Stored SuccessFully";
		
		
		
		//DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
		//String formattedDate = df.format(date);
		
		//long time = date.getTime();
	}
}
