package com.claro.loginautomaticocvideo.bean;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class OperationInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	private String externalOperation;
	private String externalTransactionDate;
	private String externalTransactionId;
	private String operationId;
	
	//
	private String transactionDate;
	private String transactionId;
	
	public String getExternalOperation() {
		return externalOperation;
	}
	public void setExternalOperation(String externalOperation) {
		this.externalOperation = externalOperation;
	}
	public String getExternalTransactionDate() {
		return externalTransactionDate;
	}
	public void setExternalTransactionDate(String externalTransactionDate) {
		this.externalTransactionDate = externalTransactionDate;
	}
	public String getExternalTransactionId() {
		return externalTransactionId;
	}
	public void setExternalTransactionId(String externalTransactionId) {
		this.externalTransactionId = externalTransactionId;
	}
	public String getOperationId() {
		return operationId;
	}
	public void setOperationId(String operationId) {
		this.operationId = operationId;
	}
	
	public String getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	@Override
	public String toString() {
		return "OperationInfo [externalOperation=" + externalOperation + ", externalTransactionDate="
				+ externalTransactionDate + ", externalTransactionId=" + externalTransactionId + ", operationId="
				+ operationId + ", transactionDate=" + transactionDate + ", transactionId=" + transactionId + "]";
	}

}
