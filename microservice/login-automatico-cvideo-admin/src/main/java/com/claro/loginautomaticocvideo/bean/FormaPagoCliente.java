package com.claro.loginautomaticocvideo.bean;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class FormaPagoCliente implements Serializable {

	private static final long serialVersionUID = 1L;
	private String messagecode;
	private String messagedescription;
	private String paymentmethodid;
	private String paymenttypeid;
	private String paymenttypedescription;
	private String bankid;
	private String bankname;
	private String accounttype;
	private String pendingdebt;
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
	public String getPaymentmethodid() {
		return paymentmethodid;
	}
	public void setPaymentmethodid(String paymentmethodid) {
		this.paymentmethodid = paymentmethodid;
	}
	public String getPaymenttypeid() {
		return paymenttypeid;
	}
	public void setPaymenttypeid(String paymenttypeid) {
		this.paymenttypeid = paymenttypeid;
	}
	public String getPaymenttypedescription() {
		return paymenttypedescription;
	}
	public void setPaymenttypedescription(String paymenttypedescription) {
		this.paymenttypedescription = paymenttypedescription;
	}
	public String getBankid() {
		return bankid;
	}
	public void setBankid(String bankid) {
		this.bankid = bankid;
	}
	public String getBankname() {
		return bankname;
	}
	public void setBankname(String bankname) {
		this.bankname = bankname;
	}
	public String getAccounttype() {
		return accounttype;
	}
	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}
	public String getPendingdebt() {
		return pendingdebt;
	}
	public void setPendingdebt(String pendingdebt) {
		this.pendingdebt = pendingdebt;
	}
	@Override
	public String toString() {
		return "FormaPagoCliente [messagecode=" + messagecode + ", messagedescription=" + messagedescription
				+ ", paymentmethodid=" + paymentmethodid + ", paymenttypeid=" + paymenttypeid
				+ ", paymenttypedescription=" + paymenttypedescription + ", bankid=" + bankid + ", bankname=" + bankname
				+ ", accounttype=" + accounttype + ", pendingdebt=" + pendingdebt + "]";
	}

}
