public class PartyProblem {
    public static void main(String[] args) {
        int arr [] = {1 ,2 ,3 ,5 ,7,10,12,44,55,66,77};
        // Max Number
        int max = 0;
        for(int ele : arr){
            if(ele>max){
                max  = ele;
            }
        }
        int visited []  = new int[max+1]; // fill with 0
        for(int ele : arr){
            if(visited[ele]!=0){
                System.out.println("Boys Party");
                return;
            }
            visited[ele]= 1;
        }
        System.out.println("Girls Party");


        /*for(int i = 0; i<arr.length; i++){
           for(int j = 0; j<arr.length; j++){
            if(i==j){
                continue;
            }
            if(arr[i]==arr[j]){
                System.out.println("Boys Party");
                return ; // exit from a function
            }
           }  // inner loop ends
        } // outer loop ends
        System.out.println("Girls Party");
        */
    }
    
}