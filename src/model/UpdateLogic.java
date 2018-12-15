package model;

import beans.ProductBean;
import dao.ProductDAO;

public class UpdateLogic {
	public String execute(ProductBean product) {
		String msg = null;
		ProductDAO dao = new ProductDAO();
		if(dao.update(product)){
			msg = "商品コード：" + product.getProductId() + " の更新完了。";
		} else {
			msg = "更新に失敗しました。";
		}
		return msg;
	}
}
