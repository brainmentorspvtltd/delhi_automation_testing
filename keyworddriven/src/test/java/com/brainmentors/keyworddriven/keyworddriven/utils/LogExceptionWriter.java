package com.brainmentors.keyworddriven.keyworddriven.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

public interface LogExceptionWriter {
	public static String writeToLog(Exception e) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		e.printStackTrace(pw);
		return sw.toString();
	}

}
