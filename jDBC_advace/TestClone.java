package jDBC_advace;

public class TestClone {public static void main(String[] args) throws Exception {

	Customer c1 = new Customer("shivam");
	c1.account.balance = 1000;
	c1.address.city = "indore";

	Customer c2 = (Customer) c1.clone();
	c2.name = "mayank";
	c2.account.balance = 10000;
	c2.address.city = "indore";
	
	Customer c3 = (Customer) c1.clone();
	c3.name = "ankit";
	c3.account.balance = 30000;
	c3.address.city = "bhopal";

	System.out.println("Original Object ");
	System.out.println("Name : " + c1.name);
	System.out.println("Balance of Account : " + c1.account.balance);
	System.out.println("City : " + c1.address.city);

	System.out.println("\n--------------------------");
	System.out.println("Cloned Object");
	System.out.println("Name : " + c2.name);
	System.out.println("Balance of Account : " + c2.account.balance);
	System.out.println("City : " + c2.address.city);
	
	System.out.println("\n--------------------------");
	System.out.println("Cloned Object");
	System.out.println("Name : " + c3.name);
	System.out.println("Balance of Account : " + c3.account.balance);
	System.out.println("City : " + c3.address.city);
}


}
