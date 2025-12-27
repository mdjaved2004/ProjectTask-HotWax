package com.projectTask.model;

import java.util.List;

public class OrderReadResponseModel {
	private CustomerDetailsModel customerDetailsModel;
	
	private List<ProductRelatedModel> listOfProductRelatedModel;

	public OrderReadResponseModel(CustomerDetailsModel customerDetailsModel,
			List<ProductRelatedModel> listOfProductRelatedModel) {
		super();
		this.customerDetailsModel = customerDetailsModel;
		this.listOfProductRelatedModel = listOfProductRelatedModel;
	}

	public CustomerDetailsModel getCustomerDetailsModel() {
		return customerDetailsModel;
	}

	public void setCustomerDetailsModel(CustomerDetailsModel customerDetailsModel) {
		this.customerDetailsModel = customerDetailsModel;
	}

	public List<ProductRelatedModel> getListOfProductRelatedModel() {
		return listOfProductRelatedModel;
	}

	public void setListOfProductRelatedModel(List<ProductRelatedModel> listOfProductRelatedModel) {
		this.listOfProductRelatedModel = listOfProductRelatedModel;
	}
	
}
