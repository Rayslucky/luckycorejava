package jDBC_advace;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

public class PrepapeUpdate {

	public static void main(String[] args) throws Exception{
		testUpdate();

	}

	public static void testUpdate() throws Exception{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Marksheet","root","root");
		
		//Statement stmt = conn.createStatement();
		
		int Roll_no = 106;
		String fname = "shivam";
		String Lname = "bairagii";
		int Physics = 50;
		int chemistry = 85;
		int math = 99;
		int id = 14;
		PreparedStatement ps =  (PreparedStatement) conn.prepareStatement("Update student set Roll_no=?,Fname =?,Lname=?,Physics=?,chemistry=?,math=? where id=? ");
		
		ps.setInt(1, Roll_no);
		ps.setString(2,fname);
		ps.setString(3,Lname);
		ps.setInt(4, Physics);
		ps.setInt(5, chemistry);
		ps.setInt(6, math);
		ps.setInt(7, id);
		
		int i = ps.executeUpdate();
		
		
		System.out.println("UPDATE");
		ps.close();
		conn.close();
	}

}


