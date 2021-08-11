package IOstream;

import java.io.FileInputStream;


import java.io.ObjectInputStream;

public class Employee_Ttest  {

		public static void main(String[] args) throws Exception {
			FileInputStream f = new FileInputStream("E:\\hello.ser");
		
			ObjectInputStream in = new ObjectInputStream(f);
			Employee e = (Employee)(in.readObject());
			
			System.out.println("ID ="+ e.getId());
			System.out.println("fname="+e.getFname());
			System.out.println("lname="+e.getLname());
			System.out.println("address="+e.getAdd());
			System.out.println("salary="+e.getSalary());
			
			System.out.println("done");
			
	}

}
