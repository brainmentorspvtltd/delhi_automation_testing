package com.brainmentors.datadriven.mycompanion.exceptions;

public class DataDrivenException extends RuntimeException {
	private String msg;
	public DataDrivenException(){
		
	}
	public DataDrivenException(String msg) {
		this.msg = msg;
	}
	public String toString() {
		return msg!=null?msg:"Data Driven Exception Occurred...";
	}
}
