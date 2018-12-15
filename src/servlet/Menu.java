package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Menu
 */
@WebServlet("/Menu")
public class Menu extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = null;
		String action = request.getParameter("action");

		if(action == null) {
			path = "/WEB-INF/jsp/menu.jsp";
		} else {
			switch (action) {
			case "toRegister":
				path = "/WEB-INF/jsp/register.jsp";
				break;

			case "toProductInfo":
				path = "/WEB-INF/jsp/productInfo.jsp";
				break;

			default:
				path = "/WEB-INF/jsp/menu.jsp";
				break;
			}
		}
		RequestDispatcher dis = request.getRequestDispatcher(path);
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
