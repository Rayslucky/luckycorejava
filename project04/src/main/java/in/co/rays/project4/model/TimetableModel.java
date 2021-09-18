package in.co.rays.project4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import in.co.rays.project4.bean.SubjectBean;
import in.co.rays.project4.bean.TimetableBean;
import in.co.rays.project4.exception.ApplicationException;
import in.co.rays.project4.exception.DuplicateRecordException;
import in.co.rays.project4.util.JDBCDataSource;

public class TimetableModel {
	private String CourseName;
	private String SubjcetName;

	/**
	 * Find next PK of TIMETABLE.
	 *
	 * @return the integer
	 * @throws ApplicationException the application exception
	 */

	public Integer nextPk() throws ApplicationException {
		//log.debug("Timetable model nextPk method Started ");
		Connection conn = null;
		int pk = 0;

		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("SELECT MAX(id) FROM ST_TIMETABLE");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				pk = rs.getInt(1);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
			//log.error("database Exception ...", e);
			throw new ApplicationException("Exception in NextPk of TIMETABLE Model");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		//log.debug("TimeTable model nextpk method end");
		return pk + 1;
	}

/**
 * Add a TIMETABLE.
 *
 * @param bean the bean
 * @return the long
 * @throws ApplicationException the application exception
 * @throws DuplicateRecordException the duplicate record exception
 */

public int add(TimetableBean bean) throws ApplicationException, DuplicateRecordException {

	Connection conn = null;
	int pk = 0;
	try {
		pk = nextPk();
		conn = JDBCDataSource.getConnection();
		conn.setAutoCommit(false);
		PreparedStatement pstmt = conn.prepareStatement("INSERT INTO ST_TIMETABLE VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
		pstmt.setInt(1, pk);
		pstmt.setString(2, bean.getCourse_Name());
		pstmt.setInt(3, bean.getCourse_Id());
		pstmt.setString(4, bean.getSubject_Name());
		pstmt.setInt(5, bean.getSubject_Id());
	    pstmt.setDate(6, bean.getExam_Date());
		pstmt.setString(7, bean.getExam_Time());
		pstmt.setInt(8, bean.getSemester());
		pstmt.setString(9, bean.getCreatedBy());
		pstmt.setString(10, bean.getModifiedBy());
		pstmt.setTimestamp(11, bean.getCreatedDatetime());
		pstmt.setTimestamp(12, bean.getModifiedDatetime());
		pstmt.executeUpdate();
		
		
		

		conn.commit();
		pstmt.close();
	} catch (Exception e) {
		e.printStackTrace();
		//log.error("database Exception ...", e);
		try {
			conn.rollback();
		} catch (Exception ex) {
			throw new ApplicationException("Exception in the Rollback of TIMETABLE Model" + ex.getMessage());
		}
		throw new ApplicationException("Exception in Add method of TIMETABLE Model");
	} finally {
		JDBCDataSource.closeConnection(conn);
	}
	//log.debug("TimeTable model Add method End");
	return pk;
	
}

/**
 * Delete a TimeTable.
 *
 * @param bean the bean
 * @throws ApplicationException the application exception
 */

public void delete(TimetableBean bean) throws ApplicationException {
	//log.debug("TIMETABLE Model Delete method Started");
	Connection conn = null;
	try {
		conn = JDBCDataSource.getConnection();
		conn.setAutoCommit(false);
		PreparedStatement pstmt = conn.prepareStatement("DELETE FROM ST_TIMETABLE WHERE ID=?");
		pstmt.setLong(1, bean.getId());
		pstmt.executeUpdate();
		conn.commit();
	} catch (Exception e) {
		e.printStackTrace();
		//log.error("database Exception ...", e);

		try {
			conn.rollback();
		} catch (Exception ex) {
			throw new ApplicationException("Exception in Rollback of Delete Method of TIMETABLE Model" + ex.getMessage());
		}
		throw new ApplicationException("Exception in Delete Method of TIMETABLE Model");
	} finally {
		JDBCDataSource.closeConnection(conn);
	}
	//log.debug("TIMETABLE Model Delete method End");
}

/**
 * Update a TIMETABLE.
 *
 * @param bean the bean
 * @throws ApplicationException the application exception
 * @throws DuplicateRecordException the duplicate record exception
 */

public void update(TimetableBean bean) throws ApplicationException, DuplicateRecordException {
Connection conn = null;

	
	try {
		conn = JDBCDataSource.getConnection();
		conn.setAutoCommit(false);
		PreparedStatement pstmt = conn.prepareStatement(
				"UPDATE ST_TIMETABLE SET COURSE_NAME=?,COURSE_ID=?,SUBJECT_NAME=?,SUBJECT_ID=?,EXAM_DATE=?,EXAM_TIME=?,SEMESTER=?,CREATEDBY=?,MODIFIEDBY=?,CREATEDDATETIME=?,MODIFIEDDATETIME=? WHERE ID=?");
		
		pstmt.setString(1, bean.getCourse_Name());
		pstmt.setInt(2, bean.getCourse_Id());
		pstmt.setString(3, bean.getSubject_Name());
		pstmt.setInt(4, bean.getSubject_Id());
	    pstmt.setDate(5, bean.getExam_Date());
		pstmt.setString(6, bean.getExam_Time());
		pstmt.setInt(7, bean.getSemester());
		pstmt.setString(8, bean.getCreatedBy());
		pstmt.setString(9, bean.getModifiedBy());
		pstmt.setTimestamp(10, bean.getCreatedDatetime());
		pstmt.setTimestamp(11, bean.getModifiedDatetime());
		pstmt.setLong(12, bean.getId());
		
	pstmt.executeUpdate();

		conn.commit();
		pstmt.close();

	} catch (Exception e) {
		e.printStackTrace();
		//log.error("database Exception....", e);
		try {
			conn.rollback();
		} catch (Exception ex) {
			throw new ApplicationException(
					"Exception in Rollback of Update Method of TimeTable Model" + ex.getMessage());
		}
		throw new ApplicationException("Exception in update Method of TimeTable Model");
	} finally {
		JDBCDataSource.closeConnection(conn);
	}
	//log.debug("TimeTable Model Update method End");
}

/**
 * Find User by TimeTable Name.
 *
 * @param name            : get parameter
 * @return bean
 * @throws ApplicationException the application exception
 */

public TimetableBean findByName(String name) throws ApplicationException {
	//log.debug("TimeTable Model findByName method Started");
	StringBuffer sql = new StringBuffer("SELECT * FROM ST_TIMETABLE WHERE SubjectName = ?");
	Connection conn = null;
	TimetableBean bean = null;

	try {
		conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		pstmt.setString(1, name);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			bean = new TimetableBean();

			bean.setId(rs.getInt(1));
			bean.setCourse_Name(rs.getString(2));
			bean.setCourse_Id(rs.getInt(3));
			bean.setSubject_Name(rs.getString(4));
			bean.setSubject_Id(rs.getInt(5));
			bean.setExam_Date(rs.getDate(6));
			bean.setExam_Time(rs.getString(7));
		    bean.setSemester(rs.getInt(8));
			bean.setCreatedBy(rs.getString(9));
			bean.setModifiedBy(rs.getString(10));
			bean.setCreatedDatetime(rs.getTimestamp(11));
			bean.setModifiedDatetime(rs.getTimestamp(12));
		}
		rs.close();
	} catch (Exception e) {
		e.printStackTrace();
		//log.error("database Exception....", e);
		throw new ApplicationException("Exception in findByName Method of TimeTable Model");
	} finally {
		JDBCDataSource.closeConnection(conn);
	}
	//log.debug("TimeTable Model findByName method End");
	return bean;

}

public TimetableBean findByPk(long pk) throws ApplicationException {
	//log.debug("TimeTable Model findBypk method Started");
	StringBuffer sql = new StringBuffer("SELECT * FROM ST_TIMETABLE WHERE ID=?");
	Connection conn = null;
	TimetableBean  bean = null;

	try {
		conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		pstmt.setLong(1, pk);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			bean = new TimetableBean();
			
			bean.setId(rs.getInt(1));
			bean.setCourse_Name(rs.getString(2));
			bean.setCourse_Id(rs.getInt(3));
			bean.setSubject_Name(rs.getString(4));
			bean.setSubject_Id(rs.getInt(5));
			bean.setExam_Date(rs.getDate(6));
			bean.setExam_Time(rs.getString(7));
		    bean.setSemester(rs.getInt(8));
			bean.setCreatedBy(rs.getString(9));
			bean.setModifiedBy(rs.getString(10));
			bean.setCreatedDatetime(rs.getTimestamp(11));
			bean.setModifiedDatetime(rs.getTimestamp(12));
		}
		rs.close();
	} catch (Exception e) {
		e.printStackTrace();
		//log.error("database Exception....", e);
		throw new ApplicationException("Exception in findByPk Method of Subject Model");
	} finally {
		JDBCDataSource.closeConnection(conn);

	}
	//log.debug("Subject Model findByPk method End");
	return bean;

}
}

