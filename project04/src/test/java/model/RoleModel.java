package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import bean.RoleBean;

public class RoleModel {
	public long pk() throws Exception {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/project_4", "root", "root");

		long pk = 0;
		PreparedStatement ps = (PreparedStatement) conn.prepareStatement("SELECT MAX(ID) FROM ST_ROLE");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			pk = rs.getLong(1);

		}
		return pk + 1;
	}

	public Long add(RoleBean RB) throws Exception {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/project_4", "root", "root");

		conn.setAutoCommit(false);

		PreparedStatement ps = (PreparedStatement) conn.prepareStatement("Insert into ST_ROLE values(?,?,?,?,?,?,?)");
		ps.setLong(1, pk());
		ps.setString(2, RB.getName());
		ps.setString(3, RB.getDescription());
		ps.setString(4, RB.getCreatedBy());
		ps.setString(5, RB.getModifiedBy());
		ps.setTimestamp(6, RB.getCreatedDatetime());
		ps.setTimestamp(7, RB.getModifiedDatetime());

		ps.execute();
		conn.commit();

		System.out.println(" SUCCESSFULLY");
		ps.close();
		conn.close();
		return null;

	}

	public void delete(RoleBean rB) throws Exception {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/project_4", "root", "root");

		conn.setAutoCommit(false);

		PreparedStatement ps = (PreparedStatement) conn.prepareStatement("DELETE FROM ST_ROLE WHERE ID=?");

		ps.setLong(1, rB.getId());

		ps.executeUpdate();
		conn.commit();

		System.out.println(" SUCCESSFULLY");
		ps.close();
		conn.close();
	}

	public void update(RoleBean RB1) throws Exception {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/project_4", "root", "root");

		conn.setAutoCommit(false);

		PreparedStatement ps = (PreparedStatement) conn.prepareStatement(
				"UPDATE ST_ROLE SET NAME=?,DESCRIPTION=?,CREATED_BY=?,MODIFIED_BY=?,CREATED_DATETIME=?,MODIFIED_DATETIME=? WHERE ID=?");

		ps.setString(1, RB1.getName());
		ps.setString(2, RB1.getDescription());
        ps.setString(3, RB1.getCreatedBy());
		ps.setString(4, RB1.getModifiedBy());
		ps.setTimestamp(5, RB1.getCreatedDatetime());
		ps.setTimestamp(6, RB1.getModifiedDatetime());
		ps.setLong(7, RB1.getId());

		ps.executeUpdate();
		conn.commit();

		System.out.println(" SUCCESSFULLY");
		ps.close();
		conn.close();
	}

}
