public class StringDemo {
    public static void main(String[] args) {
        Integer w = 150;
        Integer w2 = 150;
        System.out.println(w==w2);

        Float ww = 9992.22f;
        int f1 = ww.intValue();
        Double g1 = 888.22;
        String a = "Hello".intern();
        String b = "Hello".intern();
        String c = new String("Hello").intern();
        System.out.println(a==c);
        System.out.println(a==b);
    }

}