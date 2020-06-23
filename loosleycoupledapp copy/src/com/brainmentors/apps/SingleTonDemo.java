package com.brainmentors.apps;

import java.util.ArrayList;

interface ITaskOperation{
	void add() ;
	void delete();
}
class Task{
	
}
class TaskOperations implements ITaskOperation{
	ArrayList<Task> tasks = new ArrayList<>();
	private static ITaskOperation taskOperation = null;
	private TaskOperations() {
		
	}
	public boolean compare() {
		System.out.println("Compare Call");
		return false;
	}
	
	@Override
	public synchronized void add() {
		System.out.println("Add Call");
		tasks.add(new Task());
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		System.out.println("Delete call");
		// TODO Auto-generated method stub
		
	}
	public static synchronized ITaskOperation getInstance() {
		if(taskOperation == null) {
			taskOperation = new TaskOperations();
		}
		return taskOperation;
	}
}

public class SingleTonDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//TaskOperations ts = new TaskOperations();
		ITaskOperation opr = TaskOperations.getInstance();
		ITaskOperation opr2 = TaskOperations.getInstance();
		ITaskOperation opr3 = TaskOperations.getInstance();
		System.out.println(opr==opr2);
		System.out.println(opr==opr3);
		

	}

}
