package IOstream;

import java.util.Scanner;

public class CalcY {
public static void main(String[] args) {
	
		Scanner c;
		{
			double a=0;
			double b=0;
			char operator;
			double result=0;
			c = new Scanner(System.in);
			System.out.println( " enter the value ");
			a =c.nextDouble();
			b =c.nextDouble();
			System.out.println("what operation");
			operator = c.next().charAt(0);
			
			
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


}