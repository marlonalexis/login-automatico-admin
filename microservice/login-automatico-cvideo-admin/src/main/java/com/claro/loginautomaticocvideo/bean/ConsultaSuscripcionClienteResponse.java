package com.claro.loginautomaticocvideo.bean;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ConsultaSuscripcionClienteResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<SuscripcionCliente> suscripcionCliente;
	public List<SuscripcionCliente> getSuscripcionCliente() {
		return suscripcionCliente;
	}
	public void setSuscripcionCliente(List<SuscripcionCliente> suscripcionCliente) {
		this.suscripcionCliente = suscripcionCliente;
	}
	@Override
	public String toString() {
		return "ConsultaSuscripcionClienteResponse [suscripcionCliente=" + suscripcionCliente + "]";
	}
}
