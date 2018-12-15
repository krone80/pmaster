package model;

import beans.ProductBean;
import dao.ProductDAO;

public class SearchLogic {
	public ProductBean execute(String productId) {
		System.out.println("SearchLogic");
		ProductDAO dao = new ProductDAO();
		ProductBean product = dao.selectById(productId);
		return product;
	}
}
