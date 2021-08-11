package IOstream;

import java.io.File;
import java.io.IOException;

public class Creatfile {

	public static void main(String[] args) {
		
		File f =new File ("C:\\Users\\akhand\\Desktop\\luckycorejava\\lc.txt");
		  try {
			
		if (f.createNewFile())
		{
			System.out.println("file successfully created");
		}
		else {
			System.out.println("file does not exist");
		}
		}
		  catch (IOException e) {
			System.out.println("Exception handle..");
			e.fillInStackTrace();
		}
		
	}
}

