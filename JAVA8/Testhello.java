package JAVA8;

public class Testhello {
public static void main(String[] args) {
	Hello h = new Hello() {
		
		@Override
		public void say() {
			System.out.println("hii baby");
			
		}
	};
	h.say(); 
}
}
		
//		@Override
//		public void say() {
//			System.out.println("Anonymous class called");
//			
//		}
//	};
//	h.say();
//}
//	
//
//	}


