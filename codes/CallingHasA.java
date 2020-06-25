
public class CallingHasA {

	public static void main(String[] args) {
		
		Account account = new Account();
		Customer customer = new Customer(account);
		customer = null;
		System.gc();
		System.out.println("Before Loop");
		for(int i = 1; i<=10; i++) {
			System.out.println("I is "+i);
		}
		
		/*Customer customer = new Customer();
		System.out.println(customer.id);
		customer = null;
//		if(customer!=null) {
//		System.out.println(customer.id);
//		}
		System.gc();
		System.out.println("Before Loop");
		for(int i = 1; i<=10; i++) {
			System.out.println("I is "+i);
		}
		customer  = Customer.customer;
		if(customer!=null) {
			System.out.println("ReBorn");
		System.out.println(customer.id);
		}*/
	}

}
