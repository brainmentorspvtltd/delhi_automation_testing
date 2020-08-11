package com.brainmentors.datadriven.mycompanion.models;

public class User {
	private String userid;
	private String password;
	private String code;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", password="  +password+ ", code=" + code + "]\n";
	}
	
	

}
