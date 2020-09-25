package com.tpddl.appiumtesting.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.log4j.Logger;

public class ExceptionPrinter {
	
	public static void printStackTraceOnLogFile(Exception ex, Logger logger) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		ex.printStackTrace(pw);
		String detail = sw.toString();
		logger.error(detail);
		
	}

}
