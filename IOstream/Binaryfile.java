package IOstream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Binaryfile {

	public static void main(String[] args) throws IOException {
		String source = "C:\\Users\\akhand\\Desktop\\html\\fb.JPG";
		String target ="C:/Users/akhand/Desktop/html/love.jpg";
		FileInputStream r =new FileInputStream(source);
		FileOutputStream w = new FileOutputStream(target);
		int c =r.read();
		while(c!=-1){
			w.write(c);
			c=r.read();
		}
		w.close();
		r.close();
		System.out.println(source+"is copied to "+target);

	}

}
