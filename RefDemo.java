public class RefDemo {
    public static void main(String[] args) {
        String name = "Amit";
        //String name3 = "Amit";

        String name2 = name;
        System.out.println(name==name2);
        name = "Kumar";
        name = "Ram";
        System.out.println(name==name2);
        System.out.println(name +" "+name2);
        name = "Amit";
        System.out.println("************************");
        System.out.println(name == name2);
        

    }
}