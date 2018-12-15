package beans;

import java.io.Serializable;
import java.util.Date;

public class StaffBean implements Serializable {
	private String staffId;
	private String staffName;
	private String password;
	private String createdId;
	private Date createdAt;
	private String updatedId;
	private Date updatedAt;

	public StaffBean() {	}

	/**
	 * 全部入り
	 * @param staffId
	 * @param staffName
	 * @param password
	 * @param createdId
	 * @param createdAt
	 * @param updatedId
	 * @param updatedAt
	 */
	public StaffBean(String staffId, String staffName, String password, String createdId, Date createdAt,
			String updatedId, Date updatedAt) {
		this.staffId = staffId;
		this.staffName = staffName;
		this.password = password;
		this.createdId = createdId;
		this.createdAt = createdAt;
		this.updatedId = updatedId;
		this.updatedAt = updatedAt;
	}

	/**
	 * ログイン認証用
	 * @param staffId
	 * @param password
	 */
	public StaffBean(String staffId, String password) {
		super();
		this.staffId = staffId;
		this.password = password;
	}

	/**
	 * getter
	 * @return
	 */
	public String getStaffId() {
		return staffId;
	}

	public String getStaffName() {
		return staffName;
	}

	public String getPassword() {
		return password;
	}

	public String getCreatedId() {
		return createdId;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public String getUpdatedId() {
		return updatedId;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

}
