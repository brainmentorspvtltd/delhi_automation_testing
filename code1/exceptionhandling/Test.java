package exceptionhandling;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Age");
		int age = scanner.nextInt();
		try {
		if(age<18) {
			throw new MinorAgeException(age,"Some Message");
		}
		else {
			System.out.println("U can Apply for DL");
		}
		}
		catch(MinorAgeException e) {
			System.out.println(e);
		}

	}

}
