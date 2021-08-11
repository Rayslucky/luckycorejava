package IOstream;

import java.io.File;
import java.util.Date;

public class Testfile {

	public static void main(String[] args) {
		File f =new File("E:\\hello.txt");
if (f.exists()) {
	System.out.println("Name"+f.getName());
	System.out.println(""+f.getAbsolutePath());
	System.out.println(""+f.canWrite());
	System.out.println(""+f.canRead());
	System.out.println(""+f.isFile());
	System.out.println(""+f.isDirectory());
	System.out.println(""+f.lastModified());
	System.out.println(""+ new Date(f.lastModified()));
	System.out.println(""+f.getFreeSpace());
	System.out.println(""+f.length());
}
	}

}


