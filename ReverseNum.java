package in.co.corejava;

public class ReverseNum {

	public static void main(String[] args)
	{
		int i = 449456,r, sum =0;
		while (i!= 0)
		{
			r =i%10;
			i = i/10;
			sum = sum*10 + r;}
		
	
			System.out.println("the reverse num" + sum);
					
			
		}
		
		
		
}