package com.brainmentors.cms.test.staff;

import com.brainmentors.cms.staff.Employee;

public class EmployeeTest {

	public static void main(String[] args) {
		Employee ram ;
		ram = new Employee(1001, "Ram");
		ram.setName("Ramesh");
		ram.setSalary(90909);
		System.out.println(ram.getName());
		System.out.println(ram.toString());
		//ram= new Employee();
//		ram.display();
		//ram.id =-1001;
		//ram.salary = -99999;
		//ram.input(1001, "Ram");
		//ram.display();
		Employee shyam = new Employee(1002, "Shyam") ;
		System.out.println(shyam);
//		shyam.display();

	}

}
