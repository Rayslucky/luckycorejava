package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import bean.MarksheetBean;

public class MarksheetModel {
	public long pk() throws Exception {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/project_4", "root", "root");

		long pk = 0;
		PreparedStatement ps = (PreparedStatement) conn.prepareStatement("select max(ID) from ST_MARKSHEET");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			pk = rs.getLong(1);

		}
		return pk + 1;

	}

	public Long add(MarksheetBean MB) throws Exception {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/project_4", "root", "root");

		conn.setAutoCommit(false);

		PreparedStatement ps = (PreparedStatement) conn
				.prepareStatement("Insert into ST_MARKSHEET values(?,?,?,?,?,?,?,?,?,?,?)");
		ps.setLong(1, pk());
		ps.setString(2, MB.getRollNo());
		ps.setLong(3, MB.getStudentid());
		ps.setString(4, MB.getName());
		ps.setInt(5, MB.getPhysics());
		ps.setInt(6, MB.getChemistry());
		ps.setInt(7, MB.getMaths());
		ps.setString(8, MB.getModifiedBy());
		ps.setString(9, MB.getModifiedBy());
		ps.setTimestamp(10, MB.getCreatedDatetime());
		ps.setTimestamp(11, MB.getModifiedDatetime());

		ps.execute();
		conn.commit();

		System.out.println(" SUCCESSFULLY");
		ps.close();
		conn.close();
		return null;

	}

	public void delete(MarksheetBean mb) throws Exception {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/project_4", "root", "root");

		conn.setAutoCommit(false);

		PreparedStatement ps = (PreparedStatement) conn.prepareStatement("DELETE FROM ST_MARKSHEET WHERE ID=?");

		ps.setLong(1, mb.getId());

		ps.executeUpdate();
		conn.commit();

		System.out.println(" SUCCESSFULLY");
		ps.close();
		conn.close();
	}

	public void update(MarksheetBean MB1) throws Exception {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/project_4", "root", "root");

		conn.setAutoCommit(false);

		PreparedStatement ps = (PreparedStatement) conn.prepareStatement(
				"UPDATE ST_MARKSHEET SET ROLL_NO=?,STUDENT_ID=?,NAME=?,PHYSICS=?,CHEMISTRY=?,MATHS=?,CREATED_BY=?,MODIFIED_BY=?,CREATED_DATETIME=?,MODIFIED_DATETIME=? WHERE ID=?");
		ps.setString(1, MB1.getRollNo());
		ps.setLong(2, MB1.getStudentid());
		ps.setString(3, MB1.getName());
		ps.setInt(4, MB1.getPhysics());
		ps.setInt(5, MB1.getChemistry());
		ps.setInt(6, MB1.getMaths());
		ps.setString(7, MB1.getCreatedBy());
		ps.setString(8, MB1.getModifiedBy());
		ps.setTimestamp(9, MB1.getCreatedDatetime());
		ps.setTimestamp(10, MB1.getModifiedDatetime());
		ps.setLong(11, MB1.getId());

		ps.executeUpdate();
		conn.commit();

		System.out.println(" SUCCESSFULLY");
		ps.close();
		conn.close();
	}

}
