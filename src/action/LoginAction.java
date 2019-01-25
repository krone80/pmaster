package action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import beans.StaffBean;
import model.GenerateDataBase;
import model.LoginLogic;

public class LoginAction extends ActionSupport implements SessionAware {
	private String staffId;
	private String password;
	private String msg;
	private Map<String, Object> sessionMap;

	public String getStaffId() {return staffId;}
	public String getPassword() {return password;}
	public String getMsg() {return msg;}

	public void setStaffId(String staffId) {this.staffId = staffId;}
	public void setPassword(String password) {this.password = password;}
	public void setMsg(String msg) {this.msg = msg;}

	public void setSession(Map<String, Object> sessionMap) {this.sessionMap = sessionMap;}
	public String execute() throws Exception{
		System.out.println("LoginAction");
		//dbにテストデータを生成
		GenerateDataBase gdb = new GenerateDataBase();
		gdb.execute();
		//入力値(staffId,password)をリクエストパラメーターから取得，staffにセット
		StaffBean staff = new StaffBean(staffId,password);
		//staffとID,passが一致するデータを取得loginStaffにセット
		LoginLogic lLogic = new LoginLogic();
		StaffBean loginStaff = lLogic.execute(staff);
		//loginStaffがnullのときはエラーメッセージをリクエストスコープ にセット，ログイン画面にフォワード
		//nullでないときはセッションスコープにセットし，メインメニューにフォワード
		if(loginStaff == null) {
			System.out.println("loginStaff==null");
			setMsg("エラー：社員IDもしくはパスワードが誤っているためログインできません。再度入力してください。");
			return "input";
		} else {
			System.out.println("loginStaff!=null");
			sessionMap.put("loginStaff", loginStaff);
			return "success";
		}
	}
}
