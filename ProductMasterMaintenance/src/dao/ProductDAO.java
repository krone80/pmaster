package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import beans.ProductBean;

public class ProductDAO {
	private final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/product";
	private final String DB_USER = "root";
	private final String DB_PASS = "root";

	public ProductBean selectById(String productId){
		Connection conn = null;
		ProductBean product = null;
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			String sql ="SELECT product_id,product_name,product_val,created_id,created_at,updated_id,updated_at"
					+ " FROM m_product"
					+ " WHERE product_id=?";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, productId);

			ResultSet rs = pStmt.executeQuery();

			if (rs.next()) {
				productId = rs.getString(1);
				String productName = rs.getString(2);
				String productVal = rs.getString(3);
				String createdId = rs.getString(4);
				Date createdAt = rs.getDate(5);
				String updatedId = rs.getString(6);
				Date updatedAt = rs.getDate(7);
				product = new ProductBean(productId, productName, productVal, createdId, createdAt, updatedId, updatedAt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return product;
	}

	public boolean insert(ProductBean product){
		Connection conn = null;
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			String sql ="INSERT INTO m_product (product_id,product_name,product_val,created_id,updated_id)"
					+ " VALUES (?,?,?,?,?)";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, product.getProductId());
			pStmt.setString(2, product.getProductName());
			pStmt.setString(3, product.getProductVal());
			pStmt.setString(4, product.getCreatedId());
			pStmt.setString(5, product.getUpdatedId());

			int result = pStmt.executeUpdate();
			if(result != 1) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return true;
	}

	public boolean update(ProductBean product){
		Connection conn = null;
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			String sql ="UPDATE m_product"
					+ " SET product_name=?,product_val=?,updated_id=?"
					+ " WHERE product_id=?";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, product.getProductName());
			pStmt.setString(2, product.getProductVal());
			pStmt.setString(3, product.getUpdatedId());
			pStmt.setString(4, product.getProductId());

			int result = pStmt.executeUpdate();
			if(result != 1) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return true;
	}

}
