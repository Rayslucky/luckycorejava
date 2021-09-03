package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import bean.StudentBean;

public class StudentModel {
	public long pk() throws Exception {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/project_4", "root", "root");

		long pk = 0;
		PreparedStatement ps = (PreparedStatement) conn.prepareStatement("SELECT MAX(ID) FROM ST_STUDENT");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			pk = rs.getLong(1);

		}
		return pk + 1;
	}

	public Long add(StudentBean SB) throws Exception {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/project_4", "root", "root");

		conn.setAutoCommit(false);

		PreparedStatement ps = (PreparedStatement) conn
				.prepareStatement("Insert into ST_STUDENT values(?,?,?,?,?,?,?,?,?,?,?,?)");
		ps.setLong(1, pk());
		ps.setLong(2, SB.getCollegeid());
		ps.setString(3, SB.getCollegeName());
		ps.setString(4, SB.getFirstName());
		ps.setString(5, SB.getLastName());
		ps.setDate(6, SB.getDob());
		ps.setString(7, SB.getMobileNo());
		ps.setString(8, SB.getEmail());
		ps.setString(9, SB.getCreatedBy());
		ps.setString(10, SB.getModifiedBy());
		ps.setTimestamp(11, SB.getCreatedDatetime());
		ps.setTimestamp(12, SB.getModifiedDatetime());

		ps.execute();
		conn.commit();

		System.out.println(" SUCCESSFULLY");
		ps.close();
		conn.close();
		return null;

	}

	public void delete(StudentBean sB) throws Exception {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/project_4", "root", "root");

		conn.setAutoCommit(false);

		PreparedStatement ps = (PreparedStatement) conn.prepareStatement("DELETE FROM ST_STUDENT  WHERE ID=?");

		ps.setLong(1, sB.getId());

		ps.executeUpdate();
		conn.commit();

		System.out.println(" SUCCESSFULLY");
		ps.close();
		conn.close();
	}

public void update(StudentBean SB1) throws Exception {
	Class.forName("com.mysql.jdbc.Driver").newInstance();
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/project_4", "root", "root");

	conn.setAutoCommit(false);

	PreparedStatement ps = (PreparedStatement) conn.prepareStatement("UPDATE  ST_STUDENT SET COLLEGE_ID=?,COLLEGE_NAME=?,FIRST_NAME=?,LAST_NAME=?,DATE_OF_BIRTH=?,MOBILE_NO=?,EMAIL=?,CREATED_BY=?,MODIFIED_BY=?,CREATED_DATETIME=?,MODIFIED_DATETIME=? WHERE ID=?");

	ps.setLong(1, SB1.getCollegeid());
	ps.setString(2, SB1.getCollegeName());
	ps.setString(3, SB1.getFirstName());
	ps.setString(4, SB1.getLastName());
	ps.setDate(5, SB1.getDob());
	ps.setString(6, SB1.getMobileNo());
	ps.setString(7, SB1.getEmail());
	
	ps.setString(8, SB1.getCreatedBy());
	ps.setString(9, SB1.getModifiedBy());
	ps.setTimestamp(10, SB1.getCreatedDatetime());
	ps.setTimestamp(11, SB1.getModifiedDatetime());
	ps.setLong(12, SB1.getId());

	ps.executeUpdate();
	conn.commit();

	System.out.println(" SUCCESSFULLY");
	ps.close();
	conn.close();
}

}

