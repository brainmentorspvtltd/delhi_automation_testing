package com.brainmentors.keyworddriven.keyworddriven.models;

public class CommandDO {
private String command;
private String target;
private String value;
public String getCommand() {
	return command;
}
public CommandDO() {
	
}
public CommandDO(String command, String target, String value) {
	this.command = command;
	this.target = target;
	this.value = value;
}
public void setCommand(String command) {
	this.command = command;
}
public String getTarget() {
	return target;
}
public void setTarget(String target) {
	this.target = target;
}
public String getValue() {
	return value;
}
public void setValue(String value) {
	this.value = value;
}
@Override
public String toString() {
	return "CommandDO [command=" + command + ", target=" + target + ", value=" + value + "]\n";
}

}
