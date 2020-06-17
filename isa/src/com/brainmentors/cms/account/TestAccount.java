package com.brainmentors.cms.account;

public class TestAccount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Math
		final int MAX = 100;
		//MAX++;
		final SavingAccount sa = new SavingAccount();
		sa.checkBalance();
		sa.printStatement();
		sa.roi();
		sa.limitOfTrans();
		sa.noTransCost();
		sa.withDraw();
		sa.balance = 9099;
		sa.balance++;
		//sa = new SavingAccount(); Error
		
		System.out.println("***********************");
		CurrentAccount ca = new CurrentAccount();
		ca.checkBalance();
		ca.printStatement();
		ca.roi();
		ca.noLimitOfTrans();
		ca.transCost();
		ca.withDraw();

	}

}
