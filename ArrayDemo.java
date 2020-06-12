public class ArrayDemo {
    public static void main(String[] args) {
        int arr [] = {10,20,30,40,50};
        int [] arr2 = {10,20,30,40,50};
        int [] arr3 = new int[5]; // all are init with 0 value
        int [] arr4 = new int[]{10,20,30,40,50};
        /*for(int i = 0; i<arr2.length; i++){
            System.out.println(arr2[i]);
        }*/
        // Enhance for loop Java 1.5
        for(int i : arr2){
            System.out.println(i);
        }


    }
    
}