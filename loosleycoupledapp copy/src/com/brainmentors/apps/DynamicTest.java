package com.brainmentors.apps;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

class A{
	A(){
		System.out.println("A Cons Call");
	}
}
class B{
	B(){
		System.out.println("B Cons Call");
	}
}
public class DynamicTest {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		System.out.println("Enter the Class Name");
		Scanner s = new Scanner(System.in);
		String className = s.next();
		Object object = Class.forName(className).getDeclaredConstructor().newInstance();
		s.close();
		//		if(className.equals("A")) {
//			A obj = new A();
//		}
//		else
//		if(className.equals("B")) {
//			B obj = new B();
//		}
		

	}

}
