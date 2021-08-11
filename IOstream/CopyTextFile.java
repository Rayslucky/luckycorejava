package IOstream;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyTextFile {

	public static void main(String[] args) throws IOException {
		String source = "E:\\hello.txt";
		String target = "E:\\hellx.txt";
		FileReader fr = new FileReader(source);
		FileWriter fw = new FileWriter(target);
		
		int i = fr.read();
		while (i!=-1) {
			fw.write(i);
			i = fr.read();
			
		}
		fr.close();
		fw.close();
		System.out.println(source+"is copied to "+target);

	}

}
