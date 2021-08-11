package IOstream;

import java.io.BufferedReader;
import java.io.FileReader;


public class Email {

	public static void main(String[] args) throws Exception {
		FileReader fr = new FileReader("E:\\hello.txt");
		
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();
		while (line!=null) {
			if (line.contains("gmail.com")) {
				System.out.println("gmail id is valid=" +line);
				line =br.readLine();
				
			}
			else 
			{ 
				
			System.out.println("gmail id not valid="+line);
			line = br.readLine();
				
			}
		}
		
		
		

	}

}
