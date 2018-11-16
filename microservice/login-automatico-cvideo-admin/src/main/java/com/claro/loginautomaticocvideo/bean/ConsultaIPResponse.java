package com.claro.loginautomaticocvideo.bean;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ConsultaIPResponse implements Serializable{

	private static final long serialVersionUID = 1L;
	private String messagecode;
	private String messagedescription;
	private String customerid;
	private String macaddress;
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
	public String getMacaddress() {
		return macaddress;
	}
	public void setMacaddress(String macaddress) {
		this.macaddress = macaddress;
	}
	@Override
	public String toString() {
		return "ConsultaIPResponse [messagecode=" + messagecode + ", messagedescription=" + messagedescription
				+ ", customerid=" + customerid + ", macaddress=" + macaddress + "]";
	}	
}