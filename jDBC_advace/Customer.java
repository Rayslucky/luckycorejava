package jDBC_advace;

public class Customer implements Cloneable {

	public String name = null;
    public  BankAccount account;
    public CustomerAddress address = null;

	public Customer(String n) {
		name = n;
		account = new BankAccount(98);
		address = new CustomerAddress();
	}
		public Object clone() throws CloneNotSupportedException {
		Customer c = (Customer) super.clone();
		c.account = (BankAccount) account.clone();
		return c;
	}

		

	}


