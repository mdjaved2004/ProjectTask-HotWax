package com.projectTask.model;

public class OrderInsertMessage {
	private int orderId;
	private String errorMessage;
	
	public OrderInsertMessage(int orderId, String errorMessage) {
		super();
		this.orderId = orderId;
		this.errorMessage = errorMessage;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
}
