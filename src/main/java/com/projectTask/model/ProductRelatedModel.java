package com.projectTask.model;

public class ProductRelatedModel {
	private int productId;
    private String productName;
    private int quantity;
    private String status;
	
    public ProductRelatedModel(int productId, String productName, int quantity, String status) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.quantity = quantity;
		this.status = status;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
  
}
