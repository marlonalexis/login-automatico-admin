package com.claro.loginautomaticocvideo.bean;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class GenerarTokenResponse implements Serializable{

	private static final long serialVersionUID = 1L;
	private String token;
	private String messagecode;
	private String messagedescription;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
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
	@Override
	public String toString() {
		return "GenerarTokenResponse [token=" + token + ", messagecode=" + messagecode + ", messagedescription="
				+ messagedescription + "]";
	}

}
