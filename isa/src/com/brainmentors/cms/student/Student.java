package com.brainmentors.cms.student;

import java.util.Arrays;

import com.brainmentors.cms.utils.Utility;

public class Student {
	private int rollno;
	private String name;
	private int [] marks;
	private String phone;
	private String collegeName;
	Student(){
		collegeName = "SRCC";
	}
	public Student(int rollno, String name, int marks[]){
		this();
		this.rollno = rollno;
		this.name = name;
		this.marks = marks;
	}
	int total() {
		int sum = 0;
		for(int mark : marks) {
			sum+=mark;
		}
		return sum;
	}
	double per() {
		return total()/marks.length;
	}
	String grade() {
		double percentage = per();
		if(percentage>=90) {
			return "A Grade";
		}
		else
		if(percentage<90 && percentage>=70) {
			return "B Grade ";
		}
		else
		if(percentage<70 && percentage>=60) {
			return "C Grade";
		}
		else
		if(percentage<60 && percentage>=50) {
			return "D Grade";
		}
		else {
			return "F Grade";
		}
		
	}
	public String printMarkSheet() {
		String markstr = "";
		int i =  1;
		for(int mark : marks) {
			markstr+= "Subject "+i+" "+mark+"\n";
			i++;
		}
		//Utility util = new Utility();
		return " MarkSheet of "+Utility.titleCase(name)+"\n"+
				" Rollno "+rollno+"\n"+
				" Subjects Marks \n"+markstr+"\n"+
				" Total Marks "+total()+"\n"+
				" Percentage "+per()+"\n"+
				" Grade "+grade();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int[] getMarks() {
		return marks;
	}
	public void setMarks(int[] marks) {
		this.marks = marks;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public int getRollno() {
		return rollno;
	}
	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", name=" + name + ", marks=" + Arrays.toString(marks) + ", phone=" + phone
				+ ", collegeName=" + collegeName + "]";
	}
	

}
