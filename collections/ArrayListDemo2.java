package collections;

import java.util.ArrayList;
import java.util.Scanner;

class Emp {// extends Object{
	private int id ;
	private String name;
	private double salary;
	
	
	/*public boolean equals(Object object) {
		
		if(object instanceof Emp) {
			Emp search  = this;
			Emp eListElement = (Emp) object; // downcast
			if(search.id!=0 && eListElement.id == search.id) {
				if(search.name!=null && search.name.length()>0 
						&& search.name.equals(eListElement.name)) {
				return true;
				}
				else if(search.name.length()==0) {
					return false;
				}
				return true;
			} // outer if
			
		}
		return false;
	}*/
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emp other = (Emp) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(salary) != Double.doubleToLongBits(other.salary))
			return false;
		return true;
	}
	Emp(){
		
	}
	Emp(int id, String name, double salary){
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
	
	
}
class EmpOperation{
	ArrayList<Emp> empList = new ArrayList<>();
	void search(int id, String name, double salary) {
		Emp e = new Emp(id, name, salary);
		String result= empList.contains(e)?"Found":"Not Found";
		System.out.println(result);
	}
	void add(int id, String name, double salary) {
		Emp emp = new Emp(id, name, salary);
		empList.add(emp);
	}
	void print() {
		empList.forEach((e)->System.out.println(e));
	}
}
public class ArrayListDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		EmpOperation e = new EmpOperation();
		while(true) {
			System.out.println("1. Add");
			System.out.println("2. Print");
			System.out.println("3. Search");
			System.out.println("4. Delete");
			System.out.println("Enter the Choice");
			int choice = s.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Enter the id");
				int id = s.nextInt();
				System.out.println("Enter the Name");
				String name = s.next();
				System.out.println("Enter the Salary");
				double salary = s.nextDouble();
				e.add(id, name, salary);
				break;
			case 2: 
				e.print();
				break;
			case 3:
				System.out.println("Enter the Id ");
				 id = s.nextInt();
				System.out.println("Enter the Name");
				 name = s.next();
				System.out.println("Enter the Salary");
				 salary = s.nextDouble();
				 e.search(id, name, salary);
				 break;
				 
			}
			
		}

	}

}
