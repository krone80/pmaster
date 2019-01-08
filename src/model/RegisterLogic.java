package model;

import beans.ProductBean;
import dao.ProductDAO;

public class RegisterLogic {
	public String execute(ProductBean product) {
		String msg = null;
		ProductDAO dao = new ProductDAO();
		ProductBean exist = dao.selectById(product.getProductId());
		if(exist == null) {
			if(dao.insert(product)){
				msg = "商品コード：" + product.getProductId() + " の登録完了。";
			} else {
				msg = "登録に失敗しました。";
			}
		} else {
			msg = "既にその商品コードは使用されています。";
		}
		return msg;

	}
}
