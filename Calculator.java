package in.co.corejava;

import java.util.Scanner;

public class Calculator 
{
		
	public static void main(String[] args) 
	{
		int a=0;
		int b=0;
		char operator;
		double result=0;
		Scanner sc = new Scanner(System.in);
		System.out.println( " enter the value ");
		a =sc.nextInt();
		b =sc.nextInt();
		System.out.println("what operation");
		operator = sc.next().charAt(0);
		
		
	 switch(operator)
	 {
		case '+':
			result = a+b;
		
			
			break;
		case '-':
			result = a-b;
		
			break;
			
		case '*':
			result = a*b;
			
			break;
		case '/':
			result = a/b;
			 break;
	 }	 
			 
				 System.out.println("the final result:");

				 System.out.println(result); 

	}	 

		
}
	

