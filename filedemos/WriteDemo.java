package filedemos;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class WriteDemo {

	public static void main(String[] args) throws IOException {
		FileOutputStream fs = new FileOutputStream("/Users/amit/Documents/applogs/a.txt");
		System.out.println("Enter the Data to Write");
		String data = new Scanner(System.in).nextLine();
		fs.write(data.getBytes());
		fs.close();
		System.out.println("Data Write...");
	

	}

}
