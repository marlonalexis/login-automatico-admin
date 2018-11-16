package com.claro.loginautomaticocvideo.bean;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class FormaPagoSucursal implements Serializable {

	private static final long serialVersionUID = 1L;
	private String messagecode;
	private String messagedescription;
	private String customerid;
	private String paymentmethodid;
	public String getMessagecode() {
		return messagecode;
	}
	public void setMessagecode(String messagecode) {
		this.messagecode = messagecode;
	}
	public String getMessagedescription() {
		return messagedescription;
	}
	public void setMessagedescription(String messagedescription) {
		this.messagedescription = messagedescription;
	}
	public String getCustomerid() {
		return customerid;
	}
	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}
	public String getPaymentmethodid() {
		return paymentmethodid;
	}
	public void setPaymentmethodid(String paymentmethodid) {
		this.paymentmethodid = paymentmethodid;
	}
	@Override
	public String toString() {
		return "FormaPagoSucursal [messagecode=" + messagecode + ", messagedescription=" + messagedescription
				+ ", customerid=" + customerid + ", paymentmethodid=" + paymentmethodid + "]";
	}
	
}
