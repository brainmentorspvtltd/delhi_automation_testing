package com.brainmentors.cms.account;

public class CurrentAccount extends Account {
	void withDraw() {
		System.out.println("CurrentAccount class withDraw");
	}
	void odLimit() {
		System.out.println("CurrentAccount class odLimit");
	}
	void noLimitOfTrans() {
		System.out.println("CurrentAccount class noLimitOfTrans");
	}
	void transCost() {
		System.out.println("CurrentAccount class TransCost");
	}
	@Override
	protected void roi() {
		System.out.println("CA ROI PAY 5%");
	}
}
