package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import bean.CollegeBean;

public class CollegeModel {

	public long pk() throws Exception {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/project_4", "root", "root");

		long pk = 0;
		PreparedStatement ps = (PreparedStatement) conn.prepareStatement("select max(id) from st_college");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			pk = rs.getLong(1);

		}
		return pk + 1;
	}

	public Long add(CollegeBean CB) throws Exception {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/project_4", "root", "root");

		conn.setAutoCommit(false);

		PreparedStatement ps = (PreparedStatement) conn
				.prepareStatement("Insert into st_college values(?,?,?,?,?,?,?,?,?,?)");
		ps.setLong(1, pk());
		ps.setString(2, CB.getName());
		ps.setString(3, CB.getAddress());
		ps.setString(4, CB.getCity());
		ps.setString(5, CB.getState());
		ps.setString(6, CB.getPhoneNo());
		ps.setString(7, CB.getCreatedBy());
		ps.setString(8, CB.getModifiedBy());
		ps.setTimestamp(9, CB.getCreatedDatetime());
		ps.setTimestamp(10, CB.getModifiedDatetime());

		ps.execute();
		conn.commit();

		System.out.println(" SUCCESSFULLY");
		ps.close();
		conn.close();
		return null;

	}

	public void delete(CollegeBean cB) throws Exception {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/project_4", "root", "root");

		conn.setAutoCommit(false);

		PreparedStatement ps = (PreparedStatement) conn.prepareStatement("DELETE FROM ST_COLLEGE WHERE ID=?");

		ps.setLong(1, cB.getId());

		ps.executeUpdate();
		conn.commit();

		System.out.println(" SUCCESSFULLY");
		ps.close();
		conn.close();

	}

	public void update(CollegeBean CB1) throws Exception {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/project_4", "root", "root");

		conn.setAutoCommit(false);

		PreparedStatement ps = (PreparedStatement) conn.prepareStatement(
				"UPDATE ST_COLLEGE SET NAME=?,ADDRESS=?,STATE=?,CITY=?,PHONE_NO=?,CREATED_BY=?,MODIFIED_BY=?,CREATED_DATETIME=?,MODIFIED_DATETIME=? WHERE ID=?");

		ps.setString(1, CB1.getName());
		ps.setString(2, CB1.getAddress());
		ps.setString(3, CB1.getState());
		ps.setString(4, CB1.getCity());
		ps.setString(5, CB1.getPhoneNo());
		ps.setString(6, CB1.getCreatedBy());
		ps.setString(7, CB1.getModifiedBy());
		ps.setTimestamp(8, CB1.getCreatedDatetime());
		ps.setTimestamp(9, CB1.getModifiedDatetime());
		ps.setLong(10, CB1.getId());

		ps.executeUpdate();
		conn.commit();

		System.out.println(" SUCCESSFULLY");
		ps.close();
		conn.close();
	}

	public CollegeBean FindbyName(CollegeBean bean) throws Exception {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/project_4", "root", "root");

		conn.setAutoCommit(false);

		PreparedStatement ps = conn.prepareStatement("SELECT * FROM ST_COLLEGE WHERE NAME=?");

		ps.setString(1, bean.getName());
		ResultSet r = ps.executeQuery();
		CollegeBean cb = null;

		while (r.next()) {
			cb = new CollegeBean();

			cb.setName(r.getString(1));
			cb.setAddress(r.getString(2));
			cb.setState(r.getString(3));
			cb.setCity(r.getString(4));
			cb.setPhoneNo(r.getString(5));
			cb.setCreatedBy(r.getString(6));
			cb.setModifiedBy(r.getString(7));
			cb.setCreatedDatetime(r.getTimestamp(8));
			cb.setModifiedDatetime(r.getTimestamp(9));

		}
		conn.commit();

		ps.close();
		conn.close();
		return cb;

	}
}
