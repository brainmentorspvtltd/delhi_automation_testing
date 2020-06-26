// Nested
class P1{
static class P2{	
	static void show() {
		System.out.println("P2 Show");
	}
}
}
// Inner
class P3{
	int n=100;
	class P4 {
		void show() {
			System.out.println("P4 Show "+n);
			
		}
	}
}

public class NestedClass {

	public static void main(String[] args) {
		P1.P2.show();
		//P3.P4 obj = new P3().new P4();
		P3 obj = new P3();
		P3.P4 obj2 = obj.new P4();
		
		obj2.show();

	}

}
