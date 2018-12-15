package model;

import beans.StaffBean;
import dao.StaffDAO;

public class LoginLogic {
	public StaffBean execute(StaffBean staff) {
		StaffDAO dao = new StaffDAO();
		StaffBean loginStaff = dao.selectForLogin(staff);
		return loginStaff;
	}
}
