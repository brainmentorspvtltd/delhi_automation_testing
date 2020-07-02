package filedemos;

import java.io.File;

public class ScanDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "/Users/amit/Documents/songs";
		String hack  = "hack";
		int count = 1;
		File file= new File(path);
		if(file.exists()) {
			File files [] = file.listFiles();
			for(File f : files) {
				if(f.isFile()) {
					f.renameTo(new File(path+"/"+hack+count+".haha"));
					count++;
					//f.delete();
					//System.out.println("<FILE> "+f.getPath());
					
				}
				else
				if(f.isDirectory()) {
					System.out.println("<DIR> "+f.getName());
				}
			}
			System.out.println("All Rename");
		}
		
	}

}
