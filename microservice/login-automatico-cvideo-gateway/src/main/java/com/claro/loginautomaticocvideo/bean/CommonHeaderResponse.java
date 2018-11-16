package com.claro.loginautomaticocvideo.bean;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class CommonHeaderResponse implements Serializable{

	private static final long serialVersionUID = 1L;
	private OperationInfo operationInfo;
	public OperationInfo getOperationInfo() {
		return operationInfo;
	}
	public void setOperationInfo(OperationInfo operationInfo) {
		this.operationInfo = operationInfo;
	}
	@Override
	public String toString() {
		return "CommonHeaderResponse [operationInfo=" + operationInfo + "]";
	}
	
}
