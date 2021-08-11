package Exaception;

import oopproject.Account;

public class Excep {

	public static void main(String[] args) throws InsufficientFundException {
		Account ac = new Account();
		System.out.println(ac.withdrawal(800));
		

	}

}
