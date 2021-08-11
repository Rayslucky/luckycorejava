package Exaception;

public class Familypropagation {

	public static void main(String[] args) {
	dad();
	}

	private static void dad() {
		try{
			mom();
		}
			catch (RuntimeException e){
System.out.println( "maar khayega londa");

	}
	}
	public static void mom() {
		son();
		
		
	}

	private static void son() {
		RuntimeException e = new RuntimeException("pese gir gye ");
				throw e;
		
	}

	}


