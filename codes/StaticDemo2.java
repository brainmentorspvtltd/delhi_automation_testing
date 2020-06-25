// Utility Class
// Utility Interface
//final class MathOperations{
interface MathOperations{
	//private MathOperations() {}
	static void sin() {
		
	}
	static void cos() {
		
	}
	static void add(int a, int b) {
		System.out.println(a+b);
	}
	static void qe() {
		
	}
}
public class StaticDemo2 {

	public static void main(String[] args) {
		MathOperations.add(10, 20);
		Math.abs(-90);
		//MathOperations obj = new MathOperations();
		//obj.add(10, 20);

	}

}
