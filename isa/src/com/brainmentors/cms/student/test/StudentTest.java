package com.brainmentors.cms.student.test;

import java.util.Scanner;

import com.brainmentors.cms.student.Student;

public class StudentTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int MAX_SUBJECTS = 3;
		int marks []= new int[MAX_SUBJECTS];
		Scanner scanner= new Scanner(System.in);
		System.out.println("Enter the Rollno");
		int rollno = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the Name");
		String name = scanner.nextLine();
		//for(int i = 0; i<MAX_SUBJECTS; i++) {
		int i = 0;
		while(i<MAX_SUBJECTS) {
			System.out.println("Enter the Marks of "+(i+1) +" Subject");
			int mark = scanner.nextInt();
			
			if(mark<=100 && mark>=0) {
			marks[i] = mark;
			i++;
			}
			else {
				System.out.println("U Enter Wrong Marks "+mark);
				continue;
			}
			
		}
		System.out.println("Enter the Phone No");
		String phone = scanner.next();
		Student ram = new Student(rollno, name, marks);
		ram.setPhone(phone);
		//System.out.println(ram);
		String result = ram.printMarkSheet();
		System.out.println(result);
		scanner.close();
		
	}

}
