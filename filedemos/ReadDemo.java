package filedemos;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadDemo {

	public static void main(String[] args) throws IOException {
		//String path = "/Users/amit/Documents/tpddl-automation/filedemos/src/filedemos/ReadDemo.java";
		String path = "/Users/amit/Documents/songs/Untitled 2.mov";
		File file = new File(path);
		final int EOF = -1;
		if(file.exists()) {
			
			FileInputStream fs = new FileInputStream(file);
			//fs.read()
			BufferedInputStream bs = new BufferedInputStream(fs);
			System.out.println("File Read Start");
			//int singleByte = fs.read();
			long startTime = System.currentTimeMillis();
			int singleByte = bs.read();
			while(singleByte!=EOF) {
				//System.out.print((char)singleByte);
				//System.out.println(singleByte);
				 singleByte = bs.read();
				//singleByte = fs.read();
			}
			long endTime = System.currentTimeMillis();
			System.out.println("File Read Done "+(endTime-startTime)+"ms");
			bs.close();
			fs.close();
			
		}

	}

}
