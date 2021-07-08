package in.co.corejava;

import java.util.Scanner;

public class Scanner1 {

	public static void main(String[] args) 
	{
		int a,b;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the value of a and b");
		a=sc.nextInt();
		b=sc.nextInt();
		int c=a+b;
		int d=a-b;
		int e=a*b;
		int f=a/b;
		int x=a%b;
	
	    System.out.println("Addition="+c);
		System.out.println("Substraction="+d);
		System.out.println("Multiplication="+e);
		System.out.println("Division="+f);
		System.out.println("percentage" +x);
		
	}
	

}
