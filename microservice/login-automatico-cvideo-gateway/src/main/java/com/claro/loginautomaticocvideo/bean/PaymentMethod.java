package com.claro.loginautomaticocvideo.bean;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class PaymentMethod implements Serializable{

	private static final long serialVersionUID = 1L;
	private String paymentMethodId;
	private String paymentName;
	private List<Items> items;
	public String getPaymentMethodId() {
		return paymentMethodId;
	}
	public void setPaymentMethodId(String paymentMethodId) {
		this.paymentMethodId = paymentMethodId;
	}
	public String getPaymentName() {
		return paymentName;
	}
	public void setPaymentName(String paymentName) {
		this.paymentName = paymentName;
	}
	public List<Items> getItems() {
		return items;
	}
	public void setItems(List<Items> items) {
		this.items = items;
	}
	@Override
	public String toString() {
		return "PaymentMethod [paymentMethodId=" + paymentMethodId + ", paymentName=" + paymentName + ", items=" + items
				+ "]";
	}
	
}
