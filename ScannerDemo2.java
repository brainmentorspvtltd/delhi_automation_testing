import java.util.Scanner;

public class ScannerDemo2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the Salary");
        double salary = s.nextDouble();
        s.nextLine(); // eat \n
        System.out.println("Enter the Name");
        String name = s.nextLine();
        System.out.println("Name is "+name+" Salary is "+salary);
       
        Scanner e = new Scanner(System.in);
        System.out.println("Enter the Age");
        int age = e.nextInt();
        System.out.println("Age is "+age);
        e.close();
        s.close();
    }
    
}