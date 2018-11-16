package com.claro.loginautomaticocvideo.bean;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class GenerarTokenRequest implements Serializable{

	private static final long serialVersionUID = 1L;
	private String customerId;
	private String claroVideoMail;
	private String claroWebSiteMail;
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getClaroVideoMail() {
		return claroVideoMail;
	}
	public void setClaroVideoMail(String claroVideoMail) {
		this.claroVideoMail = claroVideoMail;
	}
	public String getClaroWebSiteMail() {
		return claroWebSiteMail;
	}
	public void setClaroWebSiteMail(String claroWebSiteMail) {
		this.claroWebSiteMail = claroWebSiteMail;
	}
	@Override
	public String toString() {
		return "GenerarTokenRequest [customerId=" + customerId + ", claroVideoMail=" + claroVideoMail
				+ ", claroWebSiteMail=" + claroWebSiteMail + "]";
	}
}
