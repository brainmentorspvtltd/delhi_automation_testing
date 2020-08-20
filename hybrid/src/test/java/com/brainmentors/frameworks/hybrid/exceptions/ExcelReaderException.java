package com.brainmentors.frameworks.hybrid.exceptions;

public class ExcelReaderException extends RuntimeException{
	private String message;
	public ExcelReaderException() {
		
	}
	
	public ExcelReaderException(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ExcelReaderException [message=" + message + "]";
	}
	

}
