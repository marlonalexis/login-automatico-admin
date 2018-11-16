package com.claro.loginautomaticocvideo.bean;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ConsultaSucursalMacRequest implements Serializable{

	private static final long serialVersionUID = 1L;
	private String macAddress;
	public String getMacAddress() {
		return macAddress;
	}
	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}
	@Override
	public String toString() {
		return "ConsultaSucursalMacRequest [macAddress=" + macAddress + "]";
	}
}
