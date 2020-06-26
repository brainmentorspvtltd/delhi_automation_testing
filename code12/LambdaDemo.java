// SAM Interface
@FunctionalInterface
interface Calc{
	//int sub();
	int calculate(int x, int y);
}
public class LambdaDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Calc c = new Calc() {
//			@Override
//			public int add(int x, int y) {
//				return x +y;
//			}
//		};
//		int z = c.add(10, 20);
//		System.out.println(z);
		Calc e = (a,b)-> {
			System.out.println("A is "+a);
			System.out.println("B is "+b);
			return a + b;
		};
		int z1 = e.calculate(1000, 2000);
		System.out.println(z1);
		Calc c = (a,b)-> a + b;
		int z = c.calculate(10, 20);
		System.out.println(z);
		Calc d = (a,b)-> a * b;
		 z = d.calculate(10, 20);
		System.out.println(z);
		
	}

}
