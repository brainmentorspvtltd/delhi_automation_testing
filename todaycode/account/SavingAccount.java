package com.brainmentors.cms.account;

public class SavingAccount extends Account {
	void withDraw() {
		System.out.println("SavingAccount class withDraw");
	}
	void limitOfTrans() {
		System.out.println("SavingAccount class LimitOfTrans");
	}
	void noTransCost() {
		System.out.println("SavingAccount class noTransCost");
	}
//	@Override
//	protected void roi() {
//		super.roi();
//		System.out.println("SA ROI 3%");
//	}
	
	protected void roi(int x) {
		System.out.println("Overloading ....."); 
		
	}
	@Override
	protected void roi() {
		// TODO Auto-generated method stub
		System.out.println("SA ROI 3%");
	}
}
