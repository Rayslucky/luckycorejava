package in.co.rays.project4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.project4.bean.RoleBean;
import in.co.rays.project4.exception.ApplicationException;
import in.co.rays.project4.exception.DataBaseException;
import in.co.rays.project4.exception.DuplicateRecordException;
import in.co.rays.project4.exception.RecordNotFoundException;
import in.co.rays.project4.util.JDBCDataSource;

public class RoleModel {/**
	 * Find next PK of Role
	 *
	 * @throws DatabaseException
	 */
	public Integer nextPK() throws DataBaseException {
		// log.debug("Model nextPK Started");
		Connection conn = null;
		int pk = 0;
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("SELECT MAX(ID) FROM ST_ROLE");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				pk = rs.getInt(1);
			}
			rs.close();

		} catch (Exception e) {
			// log.error("Database Exception..", e);
			throw new DataBaseException("Exception : Exception in getting PK");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		// log.debug("Model nextPK End");
		return pk + 1;
	}

	/**
	 * Add a Role
	 *
	 * @param bean
	 * @throws RecordNotFoundException
	 * @throws DatabaseException
	 *
	 */

	public int add(RoleBean bean) throws ApplicationException, DuplicateRecordException, RecordNotFoundException {
		// log.debug("Model and Started");
		Connection conn = null;
		int pk = 0;
		// int n=0;
		// RoleBean DuplicateException= findByname(bean.getName());
		// //create role if already exists
		// if(DuplicateException !=null){
		// throw new DuplicateException("Role alraedy exists");
		// }
		try {
			conn = JDBCDataSource.getConnection();
			pk = nextPK();
			// get auto generated next primary key;
			System.out.println(pk + "in Model JDBC");
			conn.setAutoCommit(false);// Begin transaction
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO ST_ROLE VALUES(?,?,?,?,?,?,?)");
			pstmt.setInt(1, pk);
			// pstmt.setInt(1, bean.getId());
			pstmt.setString(2, bean.getName());
			pstmt.setString(3, bean.getDescription());
			pstmt.setString(4, bean.getCreatedBy());
			pstmt.setString(5, bean.getModifiedBy());
			pstmt.setTimestamp(6, bean.getCreatedDatetime());
			pstmt.setTimestamp(7, bean.getModifiedDatetime());
			pstmt.executeUpdate();
			conn.commit();
			pstmt.close();

		} catch (Exception e) {
			e.printStackTrace();
			// log.error("DataException.", e);
			try {
				conn.rollback();
			} catch (Exception ex) {
				ex.printStackTrace();
				// throw new ApplicationException("Exception: add rollback
				// exception" + ex.getMessage());
			}
			// throw new ApplicationException("Exception: Exception in add
			// Role");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		// log.debug("Model add End");
		return pk;
	}

	/**
	 * Delete a Role
	 *
	 * @param bean
	 * @throws ApplicationException
	 * @throws DatabaseException
	 */
	public void delete(RoleBean bean) throws ApplicationException {
		// log.debug("Model deleted started");
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);// Begin transaction
			PreparedStatement pstmt = conn.prepareStatement("DELETE FROM ST_ROLE WHERE ID=?");
			pstmt.setLong(1, bean.getId());
			pstmt.executeUpdate();
			conn.commit();// End transaction
			pstmt.close();
		} catch (Exception e) {
			// log.error("Database Exception",e);
			try {
				conn.rollback();
			} catch (Exception ex) {
				throw new ApplicationException("Exception:Delete rollback exception" + ex.getMessage());
			}
			// throw new ApplicationException("Exception: Exception in deleted
			// role");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		// log.debug("Model Delete Started");

	}

	/**
	 * Update a Role
	 *
	 * @param bean
	 * @throws DatabaseException
	 */
	public void update(RoleBean bean) throws ApplicationException {
		// log.debug("Model Updated Started");
		Connection conn = null;
		// RoleBean duplicateRole=findByName(bean.getName());
		// Check if updated Role already exists
		// if(duplicateRole!=null&&duplicateRole.getId()!=bean.getId()){
		// throw new DuplicateRecordException("Role already exists");
		// }

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);// Begin transaction
			PreparedStatement pstmt = conn.prepareStatement(
					"UPDATE ST_ROLE SET NAME=?,DESCRIPTION=?,CREATED_BY=?,MODIFIED_BY=?,CREATED_DATETIME=?,MODIFIED_DATETIME=? WHERE ID=?");
			pstmt.setString(1, bean.getName());
			pstmt.setString(2, bean.getDescription());
			pstmt.setString(3, bean.getCreatedBy());
			pstmt.setString(4, bean.getModifiedBy());
			pstmt.setTimestamp(5, bean.getCreatedDatetime());
			pstmt.setTimestamp(6, bean.getModifiedDatetime());
			pstmt.setLong(7, bean.getId());
			pstmt.executeUpdate();
			conn.commit();// End Transaction
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			// log.error("Database Exception.., e");
			try {
				conn.rollback();
			} catch (Exception ex) {
				throw new ApplicationException("Exception : Delete rollback exception " + ex.getMessage());
			}
			throw new ApplicationException("Exception in Updating Role");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		// log.debug("Model Update End");
	}

	/**
	 * Find Role by PK
	 *
	 * @param pk
	 *            : get parameter
	 * @return bean
	 * @throws ApplicationException
	 * @throws DatabaseException
	 */
	public RoleBean findByPK(long pk) throws ApplicationException {
		// log.debug("Model FindByPK Started");
		// StringBuffer sql = new StringBuffer("SELECT * FROM ST_ROLE WHERE
		// ID=?");
		RoleBean bean = null;
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM ST_ROLE WHERE ID=?");
			pstmt.setLong(1, pk);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				bean = new RoleBean();
				bean.setId(rs.getInt(1));
				bean.setName(rs.getString(2));
				bean.setDescription(rs.getString(3));
				bean.setCreatedBy(rs.getString(4));
				bean.setModifiedBy(rs.getString(5));
				bean.setCreatedDatetime(rs.getTimestamp(6));
				bean.setModifiedDatetime(rs.getTimestamp(7));
			}
			rs.close();
		} catch (Exception e) {
			// e.printStackTrace();
			// log.error("DataBase Exception.."e);
			// throw new ApplicationException("Exception :Exception in getting
			// by user pk");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		// log.debug("Model FindByPK End");
		return bean;

	}

	/**
	 * Find FindByName User by Role
	 *
	 * @param name
	 *            : get parameter
	 * @return bean
	 * @throws RecordNotFoundException
	 * @throws DatabaseException
	 */
	public RoleBean findByName(String Name) {
		// log.debug("Model FindBY EmailId Started");
		RoleBean bean = null;
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM ST_ROLE WHERE NAME=?");
			pstmt.setString(1, Name);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				bean = new RoleBean();
				bean.setId(rs.getInt(1));
				bean.setName(rs.getString(2));
				bean.setDescription(rs.getString(3));
				bean.setCreatedBy(rs.getString(4));
				bean.setModifiedBy(rs.getString(5));
				bean.setCreatedDatetime(rs.getTimestamp(6));
				bean.setModifiedDatetime(rs.getTimestamp(7));
			}
			rs.close();

		} catch (Exception e) {
			e.printStackTrace();
			// throw new RecordNotFoundException("name not avalaible");

		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		// log.debug("Model FindByEmail End");
		return bean;

	}

	/**
	 * Search Role
	 *
	 * @param bean
	 *            : Search Parameters
	 * @throws DatabaseException
	 */
	public List search(RoleBean bean) throws ApplicationException {
		return Search(bean, 0, 0);
	}

	/**
	 * Search Role with pagination
	 *
	 * @return list : List of Roles
	 * @param bean
	 *            : Search Parameters
	 * @param pageNo
	 *            : Current Page No.
	 * @param pageSize
	 *            : Size of Page
	 *
	 * @throws DatabaseException
	 */

	public List Search(RoleBean bean, int pageNo, int pageSize) {
		// log.debug("Model Search Started");

		StringBuffer sql = new StringBuffer("SELECT * FROM ST_ROLE WHERE 1=1");

		ArrayList list = new ArrayList();
		
		
		if (bean != null) {
			if (bean.getId() > 0) {
				sql.append(" And id = " + bean.getId());
			}
			if (bean.getName() != null && bean.getName().length() > 0) {
				sql.append(" And Name Like '" + bean.getName() + "%'");
			}
			if (bean.getDescription() != null && bean.getDescription().length() > 0) {
				sql.append(" And Description like '" + bean.getDescription() + "%'");
				System.out.println(sql);
			}
		}
		// if page size is greater than zero then apply pagination
		if (pageSize > 0) {
			// calculate start record index
			pageNo = (pageNo - 1) * pageSize;
			sql.append(" Limit " + pageNo + "," + pageSize);
		}
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				bean = new RoleBean();
				bean.setId(rs.getInt(1));
				bean.setName(rs.getString(2));
				bean.setDescription(rs.getString(3));
				bean.setCreatedBy(rs.getString(4));
				bean.setModifiedBy(rs.getString(5));
				bean.setCreatedDatetime(rs.getTimestamp(6));
				bean.setModifiedDatetime(rs.getTimestamp(7));
				list.add(bean);
			}
			

			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		// log.debug("Model search end");
		return list;
	}

	/**
	 * Get List of Role with pagination
	 *
	 * @return list : List of Role
	 * @param pageNo
	 *            : Current Page No.
	 * @param pageSize
	 *            : Size of Page
	 * @throws DatabaseException
	 */
	public List list() throws ApplicationException{
		return list(0,0);
		
	}
	public List list(int pageNo, int pageSize) throws ApplicationException {
		// log.debug("Model list Started");
		ArrayList list = new ArrayList();
		StringBuffer sql = new StringBuffer("SELECT * FROM ST_ROLE");
		// if page size is greater than zero then apply pagination
		if (pageSize > 0) {
			// Calculate start record index
			pageNo = (pageNo - 1) * pageSize;
			sql.append(" limit " + pageNo + "," + pageSize);
		}

		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				RoleBean bean = new RoleBean();
				bean.setId(rs.getInt(1));
				bean.setName(rs.getString(2));
				bean.setDescription(rs.getString(3));
				bean.setCreatedBy(rs.getString(4));
				bean.setModifiedBy(rs.getString(5));
				bean.setCreatedDatetime(rs.getTimestamp(6));
				bean.setModifiedDatetime(rs.getTimestamp(7));
				list.add(bean);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
			// log.error("Database Exception..", e);
			// throw new ApplicationException("Exception : Exception in getting
			// list of Role");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}

		// log.debug("Model list End");
		return list;

	}
}

	
	

	