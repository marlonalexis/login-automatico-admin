package com.claro.loginautomaticocvideo.bean;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ActualizarFormaPagoResponse implements Serializable{

	private static final long serialVersionUID = 1L;
	private String messagecode;
	private String messagedescription;
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
		return "ActualizarFormaPagoResponse [messagecode=" + messagecode + ", messagedescription=" + messagedescription
				+ "]";
	}
	
}
