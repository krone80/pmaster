package beans;

import java.io.Serializable;

public class ProductBean implements Serializable {
	private String productId;
	private String productName;
	private String productVal;
	private String createdId;
	private String createdAt;
	private String updatedId;
	private String updatedAt;

	public ProductBean() {	}

	/**
	 * @param productId
	 * @param productName
	 * @param productVal
	 * @param createdId
	 * @param createdAt
	 * @param updatedId
	 * @param updatedAt
	 */
	public ProductBean(String productId, String productName, String productVal, String createdId, String createdAt,
			String updatedId, String updatedAt) {
		this.productId = productId;
		this.productName = productName;
		this.productVal = productVal;
		this.createdId = createdId;
		this.createdAt = createdAt;
		this.updatedId = updatedId;
		this.updatedAt = updatedAt;
	}

	/**
	 * @param productId
	 * @param productName
	 * @param productVal
	 */
	public ProductBean(String productId, String productName, String productVal) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productVal = productVal;
	}

	/**
	 * 新規登録用
	 * @param productId
	 * @param productName
	 * @param productVal
	 * @param createdId
	 * @param updatedId
	 */
	public ProductBean(String productId, String productName, String productVal, String createdId, String updatedId) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productVal = productVal;
		this.createdId = createdId;
		this.updatedId = updatedId;
	}

	/**
	 * 更新用
	 * @param productId
	 * @param productName
	 * @param productVal
	 * @param updatedId
	 */
	public ProductBean(String productId, String productName, String productVal, String updatedId) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productVal = productVal;
		this.updatedId = updatedId;
	}

	/**
	 * getter
	 * @return
	 */
	public String getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

	public String getProductVal() {
		return productVal;
	}

	public String getCreatedId() {
		return createdId;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public String getUpdatedId() {
		return updatedId;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}


}
