package com.brainmentors.cms.staff;

public class Employee { //extends java.lang.Object{

	private int id; // Member Variable of class (Instance Variables) (Heap)
	private String name;
	private double salary;
	private double bonus;
	private String address;
	private String email;
	private String phone;
	private String companyName;
	
	public Employee(){
		companyName="TPDDL";
	}
	public Employee(int id, String name) {
		this(); // it must be the first line
		this.id  = id;
		this.name = name;		
	}
	@Override
	public String toString() {
		return "Id "+id+" Name"+name+" Salary "+salary;
	}
	
//	public void setName(String name) {
//		this.name =name;
//	}
//	public String getName() {
//		return name;
//	}
	
	
	
	/*public void input(int id , String name, double salary, double bonus, String address, String email, String phone) {  // Local Variables (Stack)
		if(id<=0 || salary<=0) {
			System.out.println("Id or Salary is in Valid ");
			return ;
		}
		this.id = id;
		this.name = name;
		this.salary = salary;
	}*/
//	public void display() {
//		System.out.println("Company Name "+companyName);
//		System.out.println("Id is "+id);
//		System.out.println("Name is "+name);
//		System.out.println("Salary is "+salary);
//	}
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public double getBonus() {
		return bonus;
	}
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

}
