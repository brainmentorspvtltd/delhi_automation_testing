package com.brainmentors.apps;

import java.lang.reflect.InvocationTargetException;
import java.util.ResourceBundle;

public class Factory {
	private Factory(){}
	public static IProducer getInstance() {
		//return new EnhanceProducer();
		ResourceBundle rb = ResourceBundle.getBundle("config");
		String className = rb.getString("classname");
		Object object = null;
		try {
			object = Class.forName(className).getDeclaredConstructor().newInstance();
			
		
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (IProducer)object;
	}

}
