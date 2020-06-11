class Second{
public static void main(String args[]){
    int sum = 0;
    for(int i =0; i<args.length; i++){
        sum+= Integer.parseInt(args[i]);
    }
    System.out.println("Sum is "+sum);
    /*
    if(args.length==2){
    int a =Integer.parseInt(args[0]); // a as variable of int type   
    int b =Integer.parseInt(args[1]);
    int c = a + b; 
    System.out.println("Sum is "+c);
    }
    else{
        System.out.println("Invalid No of Args");
    }*/
}
}