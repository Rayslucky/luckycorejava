package jDBC_advace;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class Collable_store {


		public static void main (String[]args) throws Exception{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Marksheet","root","root");
			
			CallableStatement callstmt = conn.prepareCall("{?=Call MARKSHEET_COUNT()}");
			
			callstmt.registerOutParameter(1,Types.INTEGER);
	//	callstmt.setString(16,);
			
			callstmt.execute();
			
			int count = callstmt.getInt(1);
			System.out.println("Student count"+count);


	}

}
