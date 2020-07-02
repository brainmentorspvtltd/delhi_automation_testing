package filedemos;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FileDemo {

	public static void main(String[] args) throws IOException {
		String path = "/Users/amit/Documents/applogs/a.txt";
		File file= new File(path);
		if(file.exists()) {
			System.out.println("File Already Exist "+file.getAbsolutePath());
			System.out.println(file.getName());
			System.out.println(file.getParent());
			System.out.println(file.getFreeSpace());
			System.out.println(file.setWritable(false));
			System.out.println(file.canWrite());
			System.out.println(file.isFile());
			System.out.println(file.isHidden());
			System.out.println(new Date(file.lastModified()));
			file.delete();
		}
		else {
			file.createNewFile();
			System.out.println("File Created..");
		}

	}

}
