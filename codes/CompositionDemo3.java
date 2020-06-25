class V1{
	V1(){
		System.out.println("V1 Cons call");
	}
	void show() {
		System.out.println("V1 Show");
		 int m = 1000;
		class V2{
			int a , b;
			V2(){
				a= 10;
				b=20;
				System.out.println("V2 Cons Call");
			}
			void print() {
				System.out.println("V2 Print ");
				System.out.println(a+ " "+this.b + " "+m);
				//m++;
			}
			
		}
		V2 obj =new V2();
		obj.print();
	}
}

public class CompositionDemo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		V1 obj = new V1();
		obj.show();

	}

}
