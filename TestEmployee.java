public class TestEmployee {
    public static void main(String[] args) {
        Employee ram;
        ram = new Employee();
        System.out.println("id is "+ram.id);
        System.out.println("Name is "+ram.name);
        System.out.println("Salary is "+ram.salary);
        ram.id = 1001;
        ram.name = "Ram";
        ram.salary =9999;
        System.out.println("id is "+ram.id);
        System.out.println("Name is "+ram.name);
        System.out.println("Salary is "+ram.salary);
    }
    
}