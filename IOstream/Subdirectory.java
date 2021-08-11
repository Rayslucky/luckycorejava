package IOstream;

import java.io.File;


public class Subdirectory {

	public static void main(String[] args) {
		File D =new File("C:/Users/akhand/Desktop/luckycorejava");
         String [] list = D.list();
         for (int i = 0; i < list.length; i++) {
        	 System.out.println((i+1)+" : "+list[i] );
        	 
			
		}
	}

}
