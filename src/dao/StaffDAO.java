package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import beans.StaffBean;


public class StaffDAO {
	private final String DRIVER_NAME = "org.h2.Driver";
	private final String JDBC_URL = "jdbc:h2:file./staff;MODE=MYSQL;IFEXISTS=TRUE;";
	private final String DB_USER = "root";
	private final String DB_PASS = "root";

	public StaffBean selectForLogin(StaffBean staff){
		Connection conn = null;
		StaffBean loginStaff = null;
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			String sql ="SELECT staff_id,staff_name,password,created_id,created_at,updated_id,updated_at"
					+ " FROM m_staff"
					+ " WHERE staff_id=? AND password=?";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, staff.getStaffId());
			pStmt.setString(2, staff.getPassword());

			ResultSet rs = pStmt.executeQuery();

			if (rs.next()) {
				String staffId = rs.getString(1);
				String staffName = rs.getString(2);
				String password = rs.getString(3);
				String createdId = rs.getString(4);
				Date createdAt = rs.getDate(5);
				String updatedId = rs.getString(6);
				Date updatedAt = rs.getDate(7);
				loginStaff = new StaffBean(staffId, staffName, password, createdId, createdAt, updatedId, updatedAt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} finally {
			//データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return loginStaff;
	}
}
