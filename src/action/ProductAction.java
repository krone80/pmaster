package action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import beans.ProductBean;
import beans.StaffBean;
import model.RegisterLogic;
import model.SearchLogic;
import model.UpdateLogic;

public class ProductAction extends ActionSupport implements SessionAware  {
	private String productId;
	private String productName;
	private String productVal;
	private String msg;
//	private StaffBean staff;
	private ProductBean product;
	private Map<String, Object> sessionMap;

	public String getProductId() {return productId;}
	public String getProductName() {return productName;}
	public String getProductVal() {return productVal;}
	public String getMsg() {return msg;}
	public ProductBean getProduct() {return product;}


	public void setProductId(String productId) {this.productId = productId;}
	public void setProductName(String productName) {this.productName = productName;}
	public void setProductVal(String productVal) {this.productVal = productVal;}
	public void setMsg(String msg) {this.msg = msg;}
	public void setProduct(ProductBean product) {this.product = product;}

	public void setSession(Map<String, Object> sessionMap) {this.sessionMap = sessionMap;}

	public String register() {
		System.out.println("Register");
		//loginStaffのstaffIdをcreatedIdとupdatedIdへ
		//入力内容(productId,productName,productVal)を該当箇所へ，productにセット
		StaffBean staff = (StaffBean) sessionMap.get("loginStaff");
		ProductBean product = new ProductBean(productId, productName, productVal, staff.getStaffId(), staff.getStaffId());
		//insertを実行し結果(成否，ID被り)をmsgにセット
		RegisterLogic rLogic = new RegisterLogic();
		setMsg(rLogic.execute(product));
		return "success";
	}

	public String search() {
		System.out.println("search");
		System.out.println(productId);
		//
		SearchLogic sLogic = new SearchLogic();
		ProductBean searched = sLogic.execute(productId);
		//
		if(searched == null) {
			System.out.println("search error");
			setMsg("該当する商品が見つかりません。");
		} else {
			System.out.println("search success");
			setProduct(searched);
		}

		return "success";
	}

	public String update() {
		System.out.println("update");
		//
		StaffBean staff = (StaffBean) sessionMap.get("loginStaff");
		UpdateLogic uLogic = new UpdateLogic();
		ProductBean product = new ProductBean(productId, productName, productVal, staff.getStaffId());
		//
		setMsg(uLogic.execute(product));
		return "success";
	}
}
