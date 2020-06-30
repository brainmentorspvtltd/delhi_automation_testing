package exceptionhandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.InputMismatchException;

public class Demo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			File file = new File("");
			file.createNewFile();
			
			// XLS Read
			try {
				// DB
				try {
					
				}
				catch(RuntimeException e) {
					
				}
			}
			catch(InputMismatchException e) {
				
			}
		}
		catch(FileNotFoundException e) {
			
		}
		catch(IOException e) {
			
		}

	}

}
