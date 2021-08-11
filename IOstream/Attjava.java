package IOstream;

import java.io.File;
import java.util.Date;

public class Attjava {

	public static void main(String[] args) {
		File f = new File("C:/Users/akhand/Desktop/luckycorejava");
		if(f.exists()){
			System.out.println("Name="+f.getName());
			System.out.println("Absolute path="+f.getAbsolutePath());
			System.out.println("Is writable="+f.canWrite());
			System.out.println("is readable="+f.canRead());
		    System.out.println("is file="+f.isFile());
			System.out.println("is directory"+f.isDirectory());
			System.out.println(""+new Date(f.lastModified()));
			System.out.println(""+f.length());
			
		}
	

	}

}
