package jDBC_advace;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

import com.mysql.jdbc.PreparedStatement;

public class Collable_add {


	public static void main (String[]args) throws Exception{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Marksheet","root","root");
		
		CallableStatement callstmt = conn.prepareCall("{Call STUDENTCOUNT(?)}");
		
		callstmt.registerOutParameter(1,Types.INTEGER);
		
		callstmt.execute();
		
		int count = callstmt.getInt(1);
		System.out.println("Student count"+count);
		
	
	}
	}
