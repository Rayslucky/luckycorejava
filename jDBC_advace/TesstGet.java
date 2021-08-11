package jDBC_advace;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

public class TesstGet {

	public static void main(String[] args) throws Exception{
		TestGet(11);
	}



	public static void TestGet(int i) throws Exception {
		
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Marksheet","root","root");
		PreparedStatement ps =  (PreparedStatement) conn.prepareStatement("select * from student where id=?");
		ps.setInt(1, i);
		
		ResultSet rs = ps.executeQuery();
		 while(rs.next())
		 {
			 
			 System.out.print(" "+rs.getString(1));
			 System.out.print(" "+rs.getString(2));
		     System.out.print(" "+rs.getString(3));
		     System.out.print(""+rs.getString(4));
		     System.out.print(" "+rs.getString(5));
		     System.out.print(" "+rs.getString(6));
		     System.out.println(" "+rs.getString(7));
		     
		 
		

	}
		
		   
	}

	}

