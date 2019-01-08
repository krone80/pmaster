package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.ProductBean;
import beans.StaffBean;
import model.RegisterLogic;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Register(doGet)");
		RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/register.jsp");
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Register(doPost)");
		HttpSession ses = request.getSession();
		//loginStaffのstaffIdをcreatedIdとupdatedIdへ
		//入力内容(productId,productName,productVal)を該当箇所へ，Productにセット
		StaffBean staff = (StaffBean) ses.getAttribute("loginStaff");
		ProductBean product = new ProductBean(request.getParameter("productId"), request.getParameter("productName")
											, request.getParameter("productVal"), staff.getStaffId(), staff.getStaffId());
		//insertを実行し結果(成否，ID被り)をmsgにセット，リクエストパラメーターに保存
		RegisterLogic rLogic = new RegisterLogic();
		String msg = rLogic.execute(product);
		request.setAttribute("msg", msg);

		RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/register.jsp");
		dis.forward(request, response);

	}

}
