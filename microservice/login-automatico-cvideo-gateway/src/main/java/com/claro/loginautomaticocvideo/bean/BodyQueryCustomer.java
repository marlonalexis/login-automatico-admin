package com.claro.loginautomaticocvideo.bean;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class BodyQueryCustomer implements Serializable{

	private static final long serialVersionUID = 1L;
	private QueryCustomerMessageRequest queryCustomerMessageRequest;
	public QueryCustomerMessageRequest getQueryCustomerMessageRequest() {
		return queryCustomerMessageRequest;
	}
	public void setQueryCustomerMessageRequest(QueryCustomerMessageRequest queryCustomerMessageRequest) {
		this.queryCustomerMessageRequest = queryCustomerMessageRequest;
	}
	@Override
	public String toString() {
		return "BodyQueryCustomer [queryCustomerMessageRequest=" + queryCustomerMessageRequest + "]";
	}
	
}
