package com.brainmentors.apps;

public class EnhanceProducer implements IProducer {

	@Override
	public void show() {
		// TODO Auto-generated method stub
		System.out.println("Enhance Producer Show");
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("Enhance Producer Print");
		
	}
	
	public void notToAccess() {
		System.out.println("EP Not to Access");
	}
	public void notToAccess2() {
		System.out.println("EP Not to Access2");
	}

}
