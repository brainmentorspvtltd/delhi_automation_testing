package com.brainmentors.frameworks.hybrid.models;

public class CommandDO {
private String command;
private String target;
private String value;
private String type;
public String getCommand() {
	return command;
}
public CommandDO() {
	
}
public CommandDO(String command, String target, String value, String type) {
	this.command = command;
	this.target = target;
	this.value = value;
	this.type = type;
}

public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
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
	return "CommandDO [command=" + command + ", target=" + target + ", value=" + value + ", type=" + type + "]";
}


}
