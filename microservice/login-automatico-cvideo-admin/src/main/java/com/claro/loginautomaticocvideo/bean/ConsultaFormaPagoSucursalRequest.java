package com.claro.loginautomaticocvideo.bean;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ConsultaFormaPagoSucursalRequest implements Serializable{

	private static final long serialVersionUID = 1L;
	private String addressId;
	public String getAddressId() {
		return addressId;
	}
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}
	@Override
	public String toString() {
		return "ConsultaFormaPagoSucursalRequest [addressId=" + addressId + "]";
	}
	
}
