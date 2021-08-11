package IOstream;

import java.io.FileOutputStream;

import java.io.ObjectOutputStream;

public class Employee_test {

	public static void main(String[] args) throws Exception {
		FileOutputStream f = new FileOutputStream("E:\\hello.ser");
	
		ObjectOutputStream Out = new ObjectOutputStream(f);
		
		Employee e =new Employee();
		e.setId(004);
		e.setFname("Lucky");
		e.setLname("rajpoot");
		e.setAdd("bangali");
		e.setSalary(50000);
		Out.writeObject(e);
        Out.close();
        System.out.println("done");
		
		

	}

}
