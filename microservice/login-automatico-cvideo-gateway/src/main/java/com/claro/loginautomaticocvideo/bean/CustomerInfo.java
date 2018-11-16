package com.claro.loginautomaticocvideo.bean;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class CustomerInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	private ServiceInfo serviceInfo;
	public ServiceInfo getServiceInfo() {
		return serviceInfo;
	}
	public void setServiceInfo(ServiceInfo serviceInfo) {
		this.serviceInfo = serviceInfo;
	}
	@Override
	public String toString() {
		return "CustomerInfo [serviceInfo=" + serviceInfo + "]";
	}
	
}
