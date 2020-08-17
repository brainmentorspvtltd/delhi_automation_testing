package com.brainmentors.keyworddriven.keyworddriven.exceptions;

public class KeywordDrivenException extends RuntimeException {
	private String message;
public KeywordDrivenException() {
	
}
public KeywordDrivenException(String message) {
	this.message = message;
}
@Override
public String toString() {
	return "KeywordDrivenException [message=" + message + "]";
}

}
