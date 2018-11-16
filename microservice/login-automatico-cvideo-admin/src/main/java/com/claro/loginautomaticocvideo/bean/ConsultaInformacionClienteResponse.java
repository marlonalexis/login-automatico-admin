package com.claro.loginautomaticocvideo.bean;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ConsultaInformacionClienteResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	private String messagecode;
	private String messagedescription;
	private String names;
	private String surnames;
	private String billingmail; //mailfactura
	private String clarowebsitemail; //mailclaro
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
	public String getNames() {
		return names;
	}
	public void setNames(String names) {
		this.names = names;
	}
	public String getSurnames() {
		return surnames;
	}
	public void setSurnames(String surnames) {
		this.surnames = surnames;
	}
	public String getBillingmail() {
		return billingmail;
	}
	public void setBillingmail(String billingmail) {
		this.billingmail = billingmail;
	}
	public String getClarowebsitemail() {
		return clarowebsitemail;
	}
	public void setClarowebsitemail(String clarowebsitemail) {
		this.clarowebsitemail = clarowebsitemail;
	}
	@Override
	public String toString() {
		return "ConsultaInformacionClienteResponse [messagecode=" + messagecode + ", messagedescription="
				+ messagedescription + ", names=" + names + ", surnames=" + surnames + ", billingmail=" + billingmail
				+ ", clarowebsitemail=" + clarowebsitemail + "]";
	}
	
}
