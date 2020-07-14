package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class SortBySalary implements Comparator<Emp>{

	@Override
	public int compare(Emp first, Emp second) {
		// TODO Auto-generated method stub
		//return (int)(first.getSalary() - second.getSalary());
		return ((Double)first.getSalary()).compareTo(second.getSalary());
//		Double firstSalary = first.getSalary();
//		Double secondSalary = second.getSalary();
//		return firstSalary.compareTo(secondSalary);
	}
	
}


class Emp implements Comparable<Emp>{// extends Object{
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
	@Override
	public int compareTo(Emp e) {
		// TODO Auto-generated method stub
		//return this.id -  e.id;
		//return this.name.compareTo(e.name);
		//return this.name.compareToIgnoreCase(e.name);
		//return e.id - this.id;
		return e.name.compareToIgnoreCase(this.name);
	}
	
	
}
class EmpOperation{
	ArrayList<Emp> empList = new ArrayList<>();
	double totalSalary() {
//		double total = 0;
//		for(Emp e : empList) {
//			total += e.getSalary();
//		}
//		return total;
		return empList.stream().mapToDouble(e->e.getSalary()).sum();
	}
	double greaterTotalSalary() {
//		double total = 0;
//		for(Emp e : empList) {
//			if(e.getSalary()>9000) {
//			total += e.getSalary();
//			}
//		}
//		return total;
		return empList.parallelStream().
				filter(e->e.getSalary()>9000).
				mapToDouble(e->e.getSalary())
		.sum();
	}
	
	int search(int id, String name, double salary) {
		Emp e = new Emp(id, name, salary);
		//boolean r = empList.contains(e);
		int index = empList.indexOf(e);
		String result= index>=0?"Found":"Not Found";
		System.out.println(result);
		return index; 
	}
	void delete(int id, String name, double salary) {
		int index = search(id, name, salary);
		if(index>=0) {
			empList.remove(index);
			System.out.println("Removed .....");
		}
		
	}
	void update(int id, String name, double salary, Scanner scanner) {
		int index = search(id, name, salary);
		if(index>=0) {
			System.out.println("Enter the New Salary to Update");
			double newSalary = scanner.nextInt();
//			Emp empObject = empList.get(index);
//			empObject.setSalary(newSalary);
			Emp newObject = new Emp(id,name,newSalary);
			empList.set(index, newObject);
			System.out.println("Salary Updated....");
			//empList.remove(index);
			
		}
		
	}
	void sort() {
		//Collections.sort(empList); // Comparable
		//Collections.sort(empList, new SortBySalary()); // Comparator
		//Collections.sort(empList,(first,second)->
		//first.getName().compareTo(second.getName()));
		Collections.sort(empList,(first,second)->
		first.getId()-second.getId());
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
			System.out.println("5. Sort");
			System.out.println("6. Update");
			System.out.println("7. Total Salary");
			System.out.println("8. Total Salary> 9000");
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
			case 4:
				System.out.println("Delete Operation");
				System.out.println("Enter the Id ");
				 id = s.nextInt();
				System.out.println("Enter the Name");
				 name = s.next();
				System.out.println("Enter the Salary");
				 salary = s.nextDouble();
				 e.delete(id, name, salary);
				 break;	 
			case 5:
				e.sort();
				e.print();
				break;
			case 6:
				System.out.println("Enter the Id ");
				 id = s.nextInt();
				System.out.println("Enter the Name");
				 name = s.next();
				System.out.println("Enter the Salary");
				 salary = s.nextDouble();
				e.update(id, name, salary, s);
				break;
			case 7:
				System.out.println(e.totalSalary());
				break;
			case 8 : 
				System.out.println(e.greaterTotalSalary());
				break;
			}
			
		}

	}

}
