package Exaception;

public class InsufficientFundException extends Exception {

	public InsufficientFundException(){
		super("insufficent amount");
	}

public void  authenticate (String amount) throws InsufficientFundException{
	InsufficientFundException e= new InsufficientFundException();
	 String b = e.getMessage();
	 if (b==null) {
		 throw new InsufficientFundException();
		
	}
		

	}

}
