import java.util.ArrayList;

public class Customer{ //extends Object {
	public static Customer customer = null;
	Account account ;  //1:1
	ArrayList<Account> accounts; // 1 :M
	
	int id;
	Customer(){
		id = 1001;
		System.out.println("Customer Born");
		//account = new Account(); // Creation
		
	}
	Customer(Account account){
		id = 1001;
		System.out.println("Customer Born");
		this.account = account; // Assign
		
	}
	@Override
	protected void finalize() {
		//super.finalize();
		//customer = this;
		
		System.out.println("Customer Bye Bye  "+this);
	}

}
