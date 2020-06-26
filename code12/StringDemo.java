package stringdemo;

public class StringDemo {

	public static void main(String[] args) {
		String name = "Amit";
		String name2 = new String("Amit");
		name2.replace('m', 'n');
		StringBuilder sql = new StringBuilder();
		synchronized (sql) {
			sql.append("Hello");
		}
		//StringBuffer sql = new StringBuffer();
		System.out.println(sql.capacity());
		System.out.println(sql.length());
		System.out.println("**********************");
		sql.delete(2, 5);
		sql.deleteCharAt(0);
		sql.replace(0, 4,"ABCD");
		//sql.toString().replace(oldChar, newChar)
		sql.insert(1, 'A');
		sql.append( "select  name, price from itedjkdfhgjkdfgkjhfghkjmjhdfjghdfgkjhdfjkghdjkfhgjkhdfgh mnvbdshjghjdsg");
		System.out.println(sql.capacity());
		System.out.println(sql.length());
		
		if(true) {
			sql.append("where price<=2000");
			//sql += " where price<=2000";
		}
		System.out.println("**********************");
		System.out.println(sql.capacity());
		System.out.println(sql.length());
		String name1 = "Ram";
		System.out.println(name.charAt(0));
		System.out.println(name1.compareTo("ram"));
		System.out.println("Aamit".compareTo("aAmit"));
		System.out.println("AMIT".compareToIgnoreCase("amit"));
		System.out.println(name1.concat("Kumar"));
		System.out.println(name1.contains("m"));
		System.out.println(name1.endsWith("Kumar"));
		System.out.println(name1.startsWith("Ram"));
		System.out.println(name1.indexOf('R'));
		System.out.println(name1.lastIndexOf('R'));
		System.out.println(name1.isBlank());
		System.out.println(name1.length());
		System.out.println(name1.repeat(10));
		System.out.println(name1.replace('a', 'e'));
		System.out.println(name1.substring(1));
		System.out.println(name1.substring(1,2));
		String address = "Raj Nagar, Delhi-7";
		String arr [] = address.split(",");
		boolean result = name1.equals("Ram");
		//name1 = null;
		result = name1.equalsIgnoreCase("ram");
		result = "ram".equals(name1);
		char arr1[] =name1.toCharArray();
		String e = new String(arr1);
		byte ww [] = e.getBytes();
		String newString = name1.toLowerCase();
		String new2 = name1.toUpperCase();
		String d = name1.trim(); // Leading and Trailing get remove
		int e1 = 100;
		String www = String.valueOf(e1);
		
		
		
		

	}

}
