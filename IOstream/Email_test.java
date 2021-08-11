package IOstream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;
  
public class Email_test {

	public static boolean isVaild(String line) throws Exception {

		String er = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";

		Pattern p = Pattern.compile(er);
		if (line == null) {
			return false;
		}
		return p.matcher(line).matches();
		

	}

	public static void main(String[] args) throws Exception {

		FileReader frr = new FileReader("E:\\hello.txt");
		BufferedReader brr = new BufferedReader(frr);

		String line = brr.readLine();

		//isVaild(line, brr);
		while (line!=null) {
			if(isVaild(line)) {
            System.out.println(line);
		    line = brr.readLine();
			}else {
				System.err.println(line);
			    line = brr.readLine();
				
			}
		}
    }

	}

