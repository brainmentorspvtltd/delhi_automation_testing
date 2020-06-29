package exceptionhandling;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Demo1 {
	Scanner scanner = new Scanner(System.in);
	int firstNumber ;
	int secondNumber;
	int result;
	void takeFirstNumber() {
		try {
			System.out.println("Enter the First Number");
			 firstNumber = scanner.nextInt();
		}
		catch(InputMismatchException e) {
			System.out.println("Only Number Allowed B/w 0 to 9 "+e);
			scanner.nextLine();
			takeFirstNumber();
		}
	}
	void takeSecondNumber() {
		try {
			System.out.println("Enter the Second Number");
			secondNumber = scanner.nextInt();
		}
		catch(InputMismatchException e) {
			System.out.println("Only Number Allowed B/w 0 to 9 "+e);
			scanner.nextLine();
			takeSecondNumber();
		}
	}
	void divide() {
		try {
		result = firstNumber/secondNumber;
		}
		catch(ArithmeticException e) {
			System.out.println("U Divide a Number with zero "+e);
			takeSecondNumber();
			divide();
		}
	}
	void print() {
		System.out.println("Result is "+result);
		scanner.close();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo1 obj = new Demo1();
		obj.takeFirstNumber();
		obj.takeSecondNumber();
		obj.divide();
		obj.print();
		/*Scanner scanner = new Scanner(System.in);
		try {
		System.out.println("Enter the First Number");
		int firstNumber = scanner.nextInt();
		System.out.println("Enter the Second Number");
		int secondNumber = scanner.nextInt();
		int result =firstNumber/ secondNumber;
		System.out.println(result);
		scanner.close();
		}
		catch(InputMismatchException e) {
			System.out.println("U Enter String in Number Field "+e);
		}*/

	}

}
