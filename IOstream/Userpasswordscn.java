package IOstream;

import java.util.Scanner;

import javax.print.DocFlavor.INPUT_STREAM;

public class Userpasswordscn {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String user, pass;
       System.out.println("Enter Your Username:");
       user = sc.nextLine();
       System.out.println("Enter your Password:");
       pass = sc.nextLine();
       if (user.equals("Lucky@") &&(pass.equals("Singh"))) {
		System.err.println("I am the Devil of my World:");
	}
	}

}
