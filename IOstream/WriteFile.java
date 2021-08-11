package IOstream;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteFile {

	public static void main(String[] args) throws IOException {
		FileWriter fw = new FileWriter("E:\\hello.txt");
		PrintWriter pw = new PrintWriter(fw);
		for (int i = 0; i < 5; i++) {
			pw.write("Lucky");
		}
		pw.close();
		fw.close();
		System.out.println("file is sucessfully written");

	}

}
