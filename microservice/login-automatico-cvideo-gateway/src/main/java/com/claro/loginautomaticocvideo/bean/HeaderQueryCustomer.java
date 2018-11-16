package com.claro.loginautomaticocvideo.bean;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class HeaderQueryCustomer implements Serializable{

	private static final long serialVersionUID = 1L;
	private CommonHeaderRequest CommonHeaderRequest;
	public CommonHeaderRequest getCommonHeaderRequest() {
		return CommonHeaderRequest;
	}
	public void setCommonHeaderRequest(CommonHeaderRequest commonHeaderRequest) {
		CommonHeaderRequest = commonHeaderRequest;
	}
	@Override
	public String toString() {
		return "HeaderQueryCustomer [commonHeaderRequest=" + CommonHeaderRequest + "]";
	}
	
}
