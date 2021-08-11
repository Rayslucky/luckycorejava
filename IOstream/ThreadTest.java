package IOstream;

public class ThreadTest {

	public static void main(String[] args) throws InterruptedException {
	ThreadDemo t1 = new ThreadDemo("Lucky");
	ThreadDemo t2 = new ThreadDemo("nikki");
	t1.start();
	
	t2.start();
	for (int i = 0; i < 5000; i++) {
		System.out.println("Main Thread");
		
	}
	

	}

}
