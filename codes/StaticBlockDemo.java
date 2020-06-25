import static java.lang.System.out;
//import static staticapp.H.show;
//import static staticapp.H1.show;

import staticapp.H;
import staticapp.H1;

class M{
	int n; // Instance Var
	static int a; // Class Var
	M(){
		out.println("Default Cons");
	}
	M(int n){
		this();
		this.n = n;
		out.println("I Call When u create an object (n times ) n time object creation");
	}
	static {
		 a= 100;
		 fetchDataFromDB();
		out.println("I Call When Class is Loaded and it only once "+a);
	}
	static {
		out.println("I Call Second");
	}
	static void fetchDataFromDB() {
		out.println("Talk to DB");
	}
}
public class StaticBlockDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		M obj = new M(10);
		M obj2 = new M(20);
		M obj3 = new M(30);
		//show();
		H1.show();
		H.show();
		out.println("Hello Static ");

	}

}
