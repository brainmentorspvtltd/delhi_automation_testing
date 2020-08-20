package com.brainmentors.frameworks.hybrid.exceptions;

public class CommandException extends RuntimeException{
	private String message;
public CommandException() {}
public CommandException(String message) {
	this.message = message;
}
@Override
public String toString() {
	return "CommandException [message=" + message + "]";
}

}
