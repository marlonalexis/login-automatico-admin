package com.claro.loginautomaticocvideo.bean;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ActivateSubscriptionResponse implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String cod_error;
	private String mensaje;
	public String getCod_error() {
		return cod_error;
	}
	public void setCod_error(String cod_error) {
		this.cod_error = cod_error;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	@Override
	public String toString() {
		return "ActivateSubscriptionResponse [cod_error=" + cod_error + ", mensaje=" + mensaje + "]";
	}
}
