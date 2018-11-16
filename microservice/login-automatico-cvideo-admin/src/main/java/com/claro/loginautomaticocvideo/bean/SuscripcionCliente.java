package com.claro.loginautomaticocvideo.bean;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class SuscripcionCliente implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String messagecode;
	private String messagedescription;
	private String planid;
	private String plandescription;
	private String initialdate;
	private String enddate;
	private String status;
	private String token;
	private String clarovideomail;
	private String quota;
	private String amountused;
	private String balance;
	private String customernames;
	private String customersurnames;
	private String serviceaddress;
	private String paymentmethodid;
	private String paymenttypeid;
	private String paymenttypedescription;
	private String bankid;
	private String bankname;
	private String accounttype;
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
	public String getPlanid() {
		return planid;
	}
	public void setPlanid(String planid) {
		this.planid = planid;
	}
	public String getPlandescription() {
		return plandescription;
	}
	public void setPlandescription(String plandescription) {
		this.plandescription = plandescription;
	}
	public String getInitialdate() {
		return initialdate;
	}
	public void setInitialdate(String initialdate) {
		this.initialdate = initialdate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getClarovideomail() {
		return clarovideomail;
	}
	public void setClarovideomail(String clarovideomail) {
		this.clarovideomail = clarovideomail;
	}
	public String getQuota() {
		return quota;
	}
	public void setQuota(String quota) {
		this.quota = quota;
	}
	public String getAmountused() {
		return amountused;
	}
	public void setAmountused(String amountused) {
		this.amountused = amountused;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	public String getCustomernames() {
		return customernames;
	}
	public void setCustomernames(String customernames) {
		this.customernames = customernames;
	}
	public String getCustomersurnames() {
		return customersurnames;
	}
	public void setCustomersurnames(String customersurnames) {
		this.customersurnames = customersurnames;
	}
	public String getServiceaddress() {
		return serviceaddress;
	}
	public void setServiceaddress(String serviceaddress) {
		this.serviceaddress = serviceaddress;
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
	@Override
	public String toString() {
		return "SuscripcionCliente [messagecode=" + messagecode + ", messagedescription=" + messagedescription
				+ ", planid=" + planid + ", plandescription=" + plandescription + ", initialdate=" + initialdate
				+ ", enddate=" + enddate + ", status=" + status + ", token=" + token + ", clarovideomail="
				+ clarovideomail + ", quota=" + quota + ", amountused=" + amountused + ", balance=" + balance
				+ ", customernames=" + customernames + ", customersurnames=" + customersurnames + ", serviceaddress="
				+ serviceaddress + ", paymentmethodid=" + paymentmethodid + ", paymenttypeid=" + paymenttypeid
				+ ", paymenttypedescription=" + paymenttypedescription + ", bankid=" + bankid + ", bankname=" + bankname
				+ ", accounttype=" + accounttype + "]";
	}
}
