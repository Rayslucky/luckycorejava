package IOstream;

public class ThreadDemo extends Thread {

	
		private  String name = null;
		public ThreadDemo (String n)
		{
	       this.name = n;
		}
		@Override
		public void run() {
			for (int i = 0; i < 500; i++) {
				System.out.println(i +"Hello "+name);
		super.run();
		}

	}
 
}
