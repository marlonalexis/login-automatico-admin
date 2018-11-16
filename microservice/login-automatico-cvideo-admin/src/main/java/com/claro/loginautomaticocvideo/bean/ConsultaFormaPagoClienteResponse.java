package com.claro.loginautomaticocvideo.bean;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ConsultaFormaPagoClienteResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<FormaPagoCliente> formaPagoCliente;
	
	public List<FormaPagoCliente> getFormaPagoCliente() {
		return formaPagoCliente;
	}
	public void setFormaPagoCliente(List<FormaPagoCliente> formaPagoCliente) {
		this.formaPagoCliente = formaPagoCliente;
	}
	@Override
	public String toString() {
		return "ConsultaFormaPagoClienteResponse [formaPagoCliente=" + formaPagoCliente + "]";
	}
	
}
