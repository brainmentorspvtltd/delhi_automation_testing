
public class Account {
Account(){
	System.out.println("Account Born");
}
@Override
protected void finalize() {
	//super.finalize();
	System.out.println("Account Bye Bye");
}
}
