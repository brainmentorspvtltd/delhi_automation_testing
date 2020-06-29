package exceptionhandling;

import java.io.File;
import java.io.IOException;

public class CheckedAndUnCheckedDemo {

	public static void main(String[] args) {
		// Unchecked 
		String name = "Ram";
		System.out.println(name.length());
		String path = "/Users/amit/Documents/tpddl-automation/exceptionhandling/src/exceptionhandling/test.txt";
		
		// Checked
		File file = new File(path);
		try {
			file.createNewFile();
			System.out.println("File created...");
		} catch (IOException e) {
			System.out.println("File Creation Exception "+e);
		}

	}

}
