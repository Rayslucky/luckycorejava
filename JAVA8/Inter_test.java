package JAVA8;

public class Inter_test implements Inter {


//	@Override
//	public void show() {
//	System.out.println("show");
//		
//	};



public static void main(String[] args) {
	Inter t = new Inter() {
		
		
		@Override
		public void show() {
			System.out.println("show...");
			
		}
	};
	
t.show();
}
}

