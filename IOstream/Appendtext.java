package IOstream;

import java.io.BufferedWriter;

import java.io.FileWriter;
import java.io.IOException;

public class Appendtext {

	public static void main(String[] args) throws IOException {
		FileWriter fw = new FileWriter("E:\\hello.txt",true);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write("welcome to my world");
		bw.newLine();
		bw.write("welcome");
		bw.close();
		fw.close();
		System.out.println("done");

	}

}
