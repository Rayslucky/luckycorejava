package jDBC_advace;

import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.jdbc.PreparedStatement;

public class Preparedstmt {

	public static void main(String[] args) throws Exception{
		testAdd();

	}

	public static void testAdd() throws Exception{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Marksheet","root","root");
		
		int id = 15;
		int Roll_no = 105;
		String fname = "kavya";
		String Lname = "Gour";
		int Physics = 45;
		int chemistry = 50;
		int math = 89;
		
		PreparedStatement ps =  (PreparedStatement) conn.prepareStatement("Insert into student values(?,?,?,?,?,?,?)");
		ps.setInt(1,id);
		ps.setInt(2, Roll_no);
		ps.setString(3,fname);
		ps.setString(4,Lname);
		ps.setInt(5, Physics);
		ps.setInt(6, chemistry);
		ps.setInt(7, math);
		
		int i = ps.executeUpdate();
		System.out.println("insert");
		ps.close();
		conn.close();
	}

}
