package com.projectTask.model;

import java.util.Date;
import java.util.List;

public class OrderHeader {
	private int orderId;
    private Date orderDate;
    private int customerId;
    private int shippingContactMechId;
    private int billingContactMechId;
    private List<OrderItem> orderItems;
	
    public OrderHeader(int orderId, Date orderDate, int customerId, int shippingContactMechId, int billingContactMechId,
			List<OrderItem> orderItems) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.customerId = customerId;
		this.shippingContactMechId = shippingContactMechId;
		this.billingContactMechId = billingContactMechId;
		this.orderItems = orderItems;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getShippingContactMechId() {
		return shippingContactMechId;
	}

	public void setShippingContactMechId(int shippingContactMechId) {
		this.shippingContactMechId = shippingContactMechId;
	}

	public int getBillingContactMechId() {
		return billingContactMechId;
	}

	public void setBillingContactMechId(int billingContactMechId) {
		this.billingContactMechId = billingContactMechId;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
    
    
    
    

}
