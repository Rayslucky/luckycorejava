package Exaception;

public class MultipleCatchBlock {

	public static void main(String[] args) {
		String name ="vijay";
		try {
			System.out.println("lenght of name"+name.length());
			System.out.println("character at 3th position="+name.charAt(2));
			
		} catch (StringIndexOutOfBoundsException e) {
			System.out.println("String abhii choti hai");
			}
		catch (NullPointerException e) {
			System.out.println("Error="+e.getMessage());
			
		}
		finally {
			System.out.println("kya kroge");
			
		}
		

	}

}
