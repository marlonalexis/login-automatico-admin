package com.claro.loginautomaticocvideo.bean;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Subscriptions implements Serializable{

	private static final long serialVersionUID = 1L;
	private String planId;
	private String planDescription;
	private String initialDate;
	private String endDate;
	private String status;
	private Identification identification;
	private String email;
	private SubscriberInfo subscriberInfo;
	private PaymentMethod paymentMethod;
	public String getPlanId() {
		return planId;
	}
	public void setPlanId(String planId) {
		this.planId = planId;
	}
	public String getPlanDescription() {
		return planDescription;
	}
	public void setPlanDescription(String planDescription) {
		this.planDescription = planDescription;
	}
	public String getInitialDate() {
		return initialDate;
	}
	public void setInitialDate(String initialDate) {
		this.initialDate = initialDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Identification getIdentification() {
		return identification;
	}
	public void setIdentification(Identification identification) {
		this.identification = identification;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public SubscriberInfo getSubscriberInfo() {
		return subscriberInfo;
	}
	public void setSubscriberInfo(SubscriberInfo subscriberInfo) {
		this.subscriberInfo = subscriberInfo;
	}
	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	@Override
	public String toString() {
		return "Subscriptions [planId=" + planId + ", planDescription=" + planDescription + ", initialDate="
				+ initialDate + ", endDate=" + endDate + ", status=" + status + ", identification=" + identification
				+ ", email=" + email + ", subscriberInfo=" + subscriberInfo + ", paymentMethod=" + paymentMethod + "]";
	}
	
}
