package com.brainmentors.apps;

public class Producer implements IProducer {
	@Override
	public void show() {
		System.out.println("I am Producer Show");
	}
	@Override
	public void print() {
		doNotShow();
		System.out.println("I am Producer print");
	}

	public void doNotShow() {
		System.out.println("I am Producer DoNot Show");
	}
}
