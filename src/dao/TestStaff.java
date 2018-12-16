package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestStaff {

	public static void main(String[] args) {
		final String DRIVER_NAME = "org.h2.Driver";
		final String JDBC_URL = "jdbc:h2:file:./db/staff;MODE=MYSQL;IFEXISTS=TRUE;";
		final String DB_USER = "root";
		final String DB_PASS = "root";

		Connection conn = null;
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			String sql ="CREATE TABLE m_staff ("
					+ "staff_id varchar(10) PRIMARY KEY COMMENT 'スタッフID'"
					+ ",  staff_name VARCHAR(40) COMMENT 'スタッフ名'"
					+ ",  `password` VARCHAR(40) NOT NULL COMMENT 'パスワード'"
					+ ",  `created_id` VARCHAR(10) COMMENT '作成者ID'"
					+ ",  `created_at` DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時'"
					+ ",  `updated_id` VARCHAR(10) COMMENT '更新者ID'"
					+ ",  `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時'"
					+ ")";

			PreparedStatement pStmt = conn.prepareStatement(sql);


			int result = pStmt.executeUpdate();
			if(result != 1) {
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
