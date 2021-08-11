package jDBC_advace;

import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.jdbc.PreparedStatement;

public class PrepareDlt {
           public static void main(String[] args) throws Exception{
			testDelete();

		}

		public static void testDelete() throws Exception{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Marksheet","root","root");
			
			int id = 15;
			/*int Roll_no = 105;
			String fname = "kavya";
			String Lname = "Gour";
			int Physics = 45;
			int chemistry = 50;
			int math = 89;*/
			
			PreparedStatement ps =  (PreparedStatement) conn.prepareStatement("Delete from student where id=?");
			ps.setInt(1,id);
			
			
			int i = ps.executeUpdate();
			System.out.println("Delete");
			ps.close();
			conn.close();
		}

	

	}


