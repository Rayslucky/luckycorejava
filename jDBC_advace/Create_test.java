package jDBC_advace;

import java.sql.Connection;
import java.sql.DriverManager;
import com.mysql.jdbc.PreparedStatement;

public class Create_test {
	

	


		public static void main(String[] args) throws Exception {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Marksheet","root","root");
			
			conn.setAutoCommit(false);
	         
			
		PreparedStatement ps1=	(PreparedStatement) conn.prepareStatement("Insert into student values(32, 301,'rahul','jain', 35,45,45)");
		PreparedStatement ps2=	(PreparedStatement) conn.prepareStatement("Insert into student values(33, 302,'rahul','pal', 95,40,65)");	
			
		
		
		ps1.executeUpdate();
		ps2.executeUpdate();
		
			
			System.out.println("insert");
			
			conn.commit();
			
			ps1.close();
			ps2.close();
			conn.close();
		}
}
		
				
			
		