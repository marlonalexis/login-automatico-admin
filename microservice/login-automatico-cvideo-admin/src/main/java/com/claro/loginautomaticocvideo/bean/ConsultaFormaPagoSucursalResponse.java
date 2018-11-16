package com.claro.loginautomaticocvideo.bean;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ConsultaFormaPagoSucursalResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<FormaPagoSucursal> formaPagoSucursal;
	public List<FormaPagoSucursal> getFormaPagoSucursal() {
		return formaPagoSucursal;
	}
	public void setFormaPagoSucursal(List<FormaPagoSucursal> formaPagoSucursal) {
		this.formaPagoSucursal = formaPagoSucursal;
	}
	@Override
	public String toString() {
		return "ConsultaFormaPagoSucursalResponse [formaPagoSucursal=" + formaPagoSucursal + "]";
	}
}
