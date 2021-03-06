package com.claro.loginautomaticocvideo.bean.admin;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ActivarServicioClaroVideoRequest implements Serializable{

	private static final long serialVersionUID = 1L;
	private String token;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	@Override
	public String toString() {
		return "ActivarServicioClaroVideoRequest [token=" + token + "]";
	}

}
