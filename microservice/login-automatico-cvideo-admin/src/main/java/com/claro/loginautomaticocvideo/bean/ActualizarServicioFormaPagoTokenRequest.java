package com.claro.loginautomaticocvideo.bean;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ActualizarServicioFormaPagoTokenRequest implements Serializable{

	private static final long serialVersionUID = 1L;
	private String token;
	private String paymentMethodId;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getPaymentMethodId() {
		return paymentMethodId;
	}
	public void setPaymentMethodId(String paymentMethodId) {
		this.paymentMethodId = paymentMethodId;
	}
	@Override
	public String toString() {
		return "ActualizarServicioFormaPagoTokenRequest [token=" + token + ", paymentMethodId=" + paymentMethodId + "]";
	}
	
}
