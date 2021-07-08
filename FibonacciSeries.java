package in.co.corejava;

public class FibonacciSeries {

	public static void main(String[] args) {
		int a =1;
		int b =1;
		int x = 0;
		System.out.print("0 1 ");
		while (x <= 50)
		{
			x = a+b;
			System.out.print(" "+x);
			a =b;
			b=x;
		}
			
			
			

	}

}
