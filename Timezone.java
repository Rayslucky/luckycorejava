package in.co.corejava;

public class Timezone
{

	public static void main(String[] args)
	{
		int time = 25;
		if (time < 12)
		{
			System.out.println("good morning");
		} 
		else if(time <= 15)
		{
			System.out.println("good afternoon");
		}
		
		else if (time < 19)
		  {
		
			System.out.println("good evening");
		 }
		else if (time <= 24)
		{
			System.out.println("good night");
		}
		else 
		{
			System.out.println("start a new day");
		}
		
		}
			
		}


