package exceptionhandling;

import java.util.InputMismatchException;

public class Demo2 {

	public static void main(String[] args) {
		try {
		//int e = 100/0;
		int arr[] = new int[10];
		//arr[20] = 1000;
		String n = null;
		System.out.println(n.toUpperCase());
		}
		
		catch(ArithmeticException e) {
			System.out.println("U Divide a Number with Zero "+e);
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Array Out of Range "+e);
		}
		catch (NullPointerException e) {
			// TODO: handle exception
			System.out.println("Value is Null and u r accessing it "+e);
		}
		catch (InputMismatchException|NumberFormatException e) {
			// TODO: handle exception
			System.out.println("Only Number Allowed "+e);
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Some Mis Exception Occur "+e);
		}
		

	}

}
