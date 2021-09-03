package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import bean.UserBean;

public class UserModel {
	public long pk() throws Exception {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/project_4", "root", "root");

		long pk = 0;
		PreparedStatement ps = (PreparedStatement) conn.prepareStatement("SELECT MAX(ID) FROM ST_USER");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			pk = rs.getLong(1);

		}
		return pk + 1;
	}

	public Long add(UserBean UB) throws Exception {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/project_4", "root", "root");

		conn.setAutoCommit(false);

		PreparedStatement ps = (PreparedStatement) conn
				.prepareStatement("Insert into ST_USER values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		ps.setLong(1, pk());
		ps.setString(2, UB.getFirstName());
		ps.setString(3, UB.getLastName());
		ps.setString(4, UB.getLogin());
		ps.setString(5, UB.getPassword());
		ps.setString(6, UB.getConfirmPassword());
		ps.setDate(7, UB.getDob());
		ps.setString(8, UB.getMobileNo());
		ps.setLong(9, UB.getRoleId());
		ps.setInt(10, UB.getUnSuccessfulLogin());
		ps.setString(11, UB.getGender());
		ps.setTimestamp(12, UB.getLastLogin());
		ps.setString(13, UB.getUserlock());
		ps.setString(14, UB.getRegisteredIP());
		ps.setString(15, UB.getLastLoginIP());
		ps.setString(16, UB.getCreatedBy());
		ps.setString(17, UB.getModifiedBy());
		ps.setTimestamp(18, UB.getCreatedDatetime());
		ps.setTimestamp(19, UB.getModifiedDatetime());

		ps.execute();
		conn.commit();

		System.out.println(" SUCCESSFULLY");
		ps.close();
		conn.close();
		return null;
	}

	public void delete(UserBean uB) throws Exception {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/project_4", "root", "root");

		conn.setAutoCommit(false);

		PreparedStatement ps = (PreparedStatement) conn.prepareStatement("DELETE FROM ST_USER  WHERE ID=?");

		ps.setLong(1, uB.getId());

		ps.executeUpdate();
		conn.commit();

		System.out.println(" SUCCESSFULLY");
		ps.close();
		conn.close();
	}

	public void update(UserBean UB1) throws Exception {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/project_4", "root", "root");

		conn.setAutoCommit(false);

		PreparedStatement ps = (PreparedStatement) conn.prepareStatement(
				"UPDATE ST_USER SET FIRST_NAME=?,LAST_NAME=?,LOGIN=?,PASSWORD=?,CONFIRM_PASSWORD=?,DOB=?,MOBILE_NO=?,ROLE_ID=?,UNSUCCESSFULL_LOGIN=?,GENDER=?,LAST_LOGIN=?,USER_LOCK=?,REGISTERED_IP=?,LAST_LOGIN_IP=?,CREATED_BY=?,MODIFIED_BY=?,CREATED_DATETIME=?,MODIFIED_DATETIME=? WHERE ID=?");
		ps.setString(1, UB1.getFirstName());
		ps.setString(2, UB1.getLastName());
		ps.setString(3, UB1.getLogin());
		ps.setString(4, UB1.getPassword());
		ps.setString(5, UB1.getConfirmPassword());
		ps.setDate(6, UB1.getDob());
		ps.setString(7, UB1.getMobileNo());
		ps.setLong(8, UB1.getRoleId());
		ps.setInt(9, UB1.getUnSuccessfulLogin());
		ps.setString(10, UB1.getGender());
		ps.setTimestamp(11, UB1.getLastLogin());
		ps.setString(12, UB1.getUserlock());
		ps.setString(13, UB1.getRegisteredIP());
		ps.setString(14, UB1.getLastLoginIP());
		ps.setString(15, UB1.getCreatedBy());
		ps.setString(16, UB1.getModifiedBy());
		ps.setTimestamp(17, UB1.getCreatedDatetime());
		ps.setTimestamp(18, UB1.getModifiedDatetime());
		ps.setLong(19, UB1.getId());

		ps.executeUpdate();
		conn.commit();

		System.out.println(" SUCCESSFULLY");
		ps.close();
		conn.close();
	}

}
