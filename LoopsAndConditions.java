import java.util.Scanner;

public class LoopsAndConditions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the First Number");
        int firstNumber = scanner.nextInt();
        System.out.println("Enter the Second Number");
        int secondNumber = scanner.nextInt();
        if(firstNumber>secondNumber){
            System.out.println("First Number is Greater");
        }
        else{
            System.out.println("Second Number is Greater");
        }
        String result = firstNumber>secondNumber?"First Number is Greater":"Second Number is Greater";
        System.out.println(result);
    }
}