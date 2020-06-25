class Emp{
	int id;
	Emp(){
		id = 1001;
		System.out.println("Emp Outer Class");
		Job job = new Job();
	}
	class CommonJob{}
	interface W{
		void print();
	}
	class Job extends CommonJob implements W{
		int id;
		Job(){
			id = 10;
			System.out.println("Job Inner Class ");
			System.out.println("Emp Id "+Emp.this.id);
			System.out.println("Job Id "+this.id);
			
		}
		@Override
		public void print() {
			// TODO Auto-generated method stub
			
		}
	}
}
public class CompositionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Emp ram = new Emp();

	}

}
