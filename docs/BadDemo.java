/**
 * Bad Demo this is a sample class to learn SRP and Java Doc
 * @author Amit Srivastava
 * @since 15th 2020
 * @version 1.0
 */
public class BadDemo{
    // Single Line Comment
    /*
    Multi Line Comment
    */

    /**
     * isAccountPresent is a function to check account number is exist 
     * in the database or not , based on this it return true or false.
     * @param accountNumber
     * @return java.lang.Boolean
     *
     */

    public boolean isAccountPresent(int accountNumber){
        return true;
    }
    /**
     * withDraw is a function to check account number is exist 
     * in the database or not , based on this it return true or false.
     *
     *
     */
    public void withDraw(){
        //System.out.println("Check Account is Present or Not");
        isAccountPresent(1001); // Delegate 
        System.out.println("Account is Locked or Not");
        System.out.println("Check Balance is Present or Not");
        System.out.println("WithDraw");
        System.out.println("Update Balance");
        notification(); // Delegate 
        //System.out.println("Trans Notification ");

    }
    void notification(){
        System.out.println("SMS Notification ");

    }
}
