package com.projectTask.model;

public class OrderItemDetails  {

	 private int orderItemSeqId;
    private int productId;
    private String productName;
    private String color;
    private String size;
    private int quantity;
    private String status;
	
    public OrderItemDetails(int orderItemSeqId, int productId, String productName, String color, String size,
			int quantity, String status) {
		super();
		this.orderItemSeqId = orderItemSeqId;
		this.productId = productId;
		this.productName = productName;
		this.color = color;
		this.size = size;
		this.quantity = quantity;
		this.status = status;
	}

	public int getOrderItemSeqId() {
		return orderItemSeqId;
	}

	public void setOrderItemSeqId(int orderItemSeqId) {
		this.orderItemSeqId = orderItemSeqId;
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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
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
