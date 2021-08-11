package jDBC_advace;

       public class BankAccount implements Cloneable {

		public double balance = 0;

		public BankAccount() {
		}

		public BankAccount(double b) {
			balance = b;
		}
       

		@Override
		public Object clone() throws CloneNotSupportedException {
			return super.clone();
		}

		public static void main(String[] args) throws Exception {

			BankAccount a1 = new BankAccount(10);
			BankAccount a2 = (BankAccount) a1.clone();
			a2.balance = 20;
			BankAccount a3 = (BankAccount)a1.clone();
			a3.balance = 30;

			System.out.println(a1.balance);
			System.out.println(a2.balance);
			System.out.println(a3.balance);
		}

	
	}


