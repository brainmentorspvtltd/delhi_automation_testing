package com.brainmentors.cms.account;


class AccountCaller{
	void callAccount(Account account){
		account.checkBalance();
		account.printStatement();
		account.roi();
		if(account instanceof SavingAccount) {
		SavingAccount sa = (SavingAccount) account;
		sa.limitOfTrans();
		sa.noTransCost();
		}
		else
		if(account instanceof CurrentAccount) {	
			CurrentAccount ca = (CurrentAccount) account; 
			ca.odLimit();
			ca.noLimitOfTrans();
		}
		System.out.println("********************************");
		
		//account.withDraw();
	}
}

public class TestAccount {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Math
		AccountCaller ac = new AccountCaller();
		ac.callAccount(new SavingAccount());
		ac.callAccount(new CurrentAccount());
		
		
//		final int MAX = 100;
//		// Generic 
//		Account account = new SavingAccount(); // Upcasting
//		account.checkBalance();
//		account.printStatement();
//		account.roi();
//		account = new CurrentAccount();
		// Special Feature (Child)
//		account.limitOfTrans();
//		account.noTransCost();
//		account.withDraw();
		//MAX++;
		/*final SavingAccount sa = new SavingAccount();
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
		*/

	}

}
