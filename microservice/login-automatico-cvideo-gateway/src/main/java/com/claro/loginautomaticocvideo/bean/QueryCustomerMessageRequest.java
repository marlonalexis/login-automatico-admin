package com.claro.loginautomaticocvideo.bean;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class QueryCustomerMessageRequest implements Serializable{

	private static final long serialVersionUID = 1L;
	private CustomerInfo customerInfo;
	public CustomerInfo getCustomerInfo() {
		return customerInfo;
	}
	public void setCustomerInfo(CustomerInfo customerInfo) {
		this.customerInfo = customerInfo;
	}
	@Override
	public String toString() {
		return "QueryCustomerMessageRequest [customerInfo=" + customerInfo + "]";
	}
	
}
