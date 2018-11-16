package com.claro.loginautomaticocvideo.bean;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class QueryCustomerResponse implements Serializable{

	private static final long serialVersionUID = 1L;
	private CommonHeaderResponse CommonHeaderResponse;
	private QuerySubscriptionsResponseMessage querySubscriptionsResponseMessage;
	private String cod_error;
	private String mensaje;
	
	private String nombres;
	private String apellidos;
	private String mail;
	private String token;
	
	public CommonHeaderResponse getCommonHeaderResponse() {
		return CommonHeaderResponse;
	}
	public void setCommonHeaderResponse(CommonHeaderResponse commonHeaderResponse) {
		CommonHeaderResponse = commonHeaderResponse;
	}
	public QuerySubscriptionsResponseMessage getQuerySubscriptionsResponseMessage() {
		return querySubscriptionsResponseMessage;
	}
	public void setQuerySubscriptionsResponseMessage(QuerySubscriptionsResponseMessage querySubscriptionsResponseMessage) {
		this.querySubscriptionsResponseMessage = querySubscriptionsResponseMessage;
	}
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
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	@Override
	public String toString() {
		return "QueryCustomerResponse [CommonHeaderResponse=" + CommonHeaderResponse
				+ ", querySubscriptionsResponseMessage=" + querySubscriptionsResponseMessage + ", cod_error="
				+ cod_error + ", mensaje=" + mensaje + ", nombres=" + nombres + ", apellidos=" + apellidos + ", mail="
				+ mail + ", token=" + token + "]";
	}


}
