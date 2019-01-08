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
import model.UpdateLogic;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Update(doPost)");

		HttpSession ses = request.getSession();
		//
		StaffBean staff = (StaffBean) ses.getAttribute("loginStaff");
		UpdateLogic uLogic = new UpdateLogic();
		ProductBean product = new ProductBean(request.getParameter("productId"), request.getParameter("productName")
											, request.getParameter("productVal"), staff.getStaffId());
		//
		String msg = uLogic.execute(product);
		request.setAttribute("msg", msg);

		RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/productInfo.jsp");
		dis.forward(request, response);
	}

}
