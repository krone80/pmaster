package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.StaffBean;
import model.LoginLogic;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Login(doPost)");
		HttpSession ses = request.getSession();
		String path = null;
		//入力値(staffId,password)をリクエストパラメーターから取得，staffにセット
		StaffBean staff = new StaffBean(request.getParameter("staffId"),request.getParameter("password"));
		//staffとID,passが一致するデータを取得loginStaffにセット
		LoginLogic lLogic = new LoginLogic();
		StaffBean loginStaff = lLogic.execute(staff);
		//loginStaffがnullのときはエラーメッセージをリクエストスコープ にセット，ログイン画面にフォワード
		//nullでないときはセッションスコープにセットし，メインメニューにフォワード
		if(loginStaff == null) {
			System.out.println("loginStaff==null");
			request.setAttribute("msg", "エラー：社員IDもしくはパスワードが誤っているためログインできません。再度入力してください。");
			path = "/index.html";
		} else {
			System.out.println("loginStaff!=null");
			ses.setAttribute("loginStaff", loginStaff);
			path = "/Menu";
		}
		RequestDispatcher dis = request.getRequestDispatcher(path);
		dis.forward(request, response);
	}
}
