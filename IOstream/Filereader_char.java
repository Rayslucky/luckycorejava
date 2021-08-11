package IOstream;

import java.io.FileReader;
import java.io.IOException;

public class Filereader_char {

	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("E:\\hello.txt");
      int ch = fr.read();
      char chr;
      while (ch!=-1) {
    	  chr =(char)ch;
          System.out.print(chr);
          ch = fr.read();
    	 
	}

	  		
	}

}
