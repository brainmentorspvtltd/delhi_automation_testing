package com.brainmentors.frameworks.hybrid.exceptions;

public class HybridException extends RuntimeException {
private String message;
public HybridException() {
	
}
public HybridException(String message) {
	this.message = message;
}
@Override
public String toString() {
	return "HybridException [message=" + message + "]";
}

}
