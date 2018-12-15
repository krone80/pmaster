package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ProductBean;
import model.SearchLogic;

/**
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Search(doGet)");
		RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/productInfo.jsp");
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Search(doPost)");
		System.out.println(request.getParameter("productId"));
		//
		SearchLogic sLogic = new SearchLogic();
		ProductBean product = sLogic.execute(request.getParameter("productId"));
		//
		if(product == null) {
			request.setAttribute("msg", "該当する商品が見つかりません。");
		} else {
			request.setAttribute("product", product);
		}
		RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/productInfo.jsp");
		dis.forward(request, response);

	}

}
