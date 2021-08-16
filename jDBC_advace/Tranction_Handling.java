package jDBC_advace;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Tranction_Handling {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Marksheet","root","root");
		
		conn.setAutoCommit(false);
          
		Statement stmt = conn.createStatement();
		try {
			
		
		
		 stmt.executeUpdate("Insert into student values(26,106,'jubin','jain',45,55,69)");
		 stmt.executeUpdate("Insert into student values(27,106,'jubin','jain',45,55,69)");
		 stmt.executeUpdate("Insert into student values(28,106,'jubin','jain',45,55,69)");
		 stmt.executeUpdate("Insert into student values(29,106,'jubin','jain',45,55,69)");
		conn.commit();
		System.out.println("updated");
		
		} 
		catch (SQLException e ) {
			conn.rollback();
		}
		
		stmt.close();
		conn.close(); 
		}
}



