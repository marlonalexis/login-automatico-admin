package com.claro.loginautomaticocvideo.bean;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ConsultaFormaPagoClienteRequest implements Serializable{

	private static final long serialVersionUID = 1L;
	private String customerId;
	private String onlyServicesFlag;
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getOnlyServicesFlag() {
		return onlyServicesFlag;
	}
	public void setOnlyServicesFlag(String onlyServicesFlag) {
		this.onlyServicesFlag = onlyServicesFlag;
	}
	@Override
	public String toString() {
		return "ConsultaFormaPagoClienteRequest [customerId=" + customerId + ", onlyServicesFlag=" + onlyServicesFlag
				+ "]";
	}

}
