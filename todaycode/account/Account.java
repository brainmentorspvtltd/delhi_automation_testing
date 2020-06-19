package com.brainmentors.cms.account;

//public final class Account {
public  abstract class Account{
	int id;
	String name;
	double balance;
	protected void printStatement() {
		System.out.println("Account class PrintStatement");
	}
	protected void checkBalance() {
		System.out.println("Account class checkBalance");
	}
	//final protected void roi() {
//	protected void roi() {
//		System.out.println("Account class ROI");
//	}
	protected abstract  void roi(); // Decleration (Body Less)
}
