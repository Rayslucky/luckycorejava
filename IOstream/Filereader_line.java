package IOstream;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;


public class Filereader_line {

	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("E:\\hello.txt");
		BufferedReader br = new BufferedReader(fr);
		String l = br.readLine();
        while (l!=null)
        {
        	System.out.println(l);
        	l = br.readLine();	
		}
        fr.close();
        br.close();
        
	} 

}
