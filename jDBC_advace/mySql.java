package jDBC_advace;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class mySql {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Marksheet","root","root");
		Statement stmt = conn.createStatement();
		int i =stmt.executeUpdate("update student set fname='akirti' where id =2");
		int in =stmt.executeUpdate("insert into student values(14,104,'Vishakha','tiwari',12,15,11)"); 
		ResultSet rs = stmt.executeQuery("select * from student order by id ");
		 while(rs.next())
		 {
			 
			 System.out.print(" "+rs.getString(1));
			 System.out.print(" "+rs.getString(2));
		     System.out.print(" "+rs.getString(3));
		     System.out.print(""+rs.getString(4));
		     System.out.print(" "+rs.getString(5));
		     System.out.print(" "+rs.getString(6));
		     System.out.print(" "+rs.getString(7));
		     System.out.println();
		 
		

	}
		 stmt.close();
		 conn.close();

	}
}
