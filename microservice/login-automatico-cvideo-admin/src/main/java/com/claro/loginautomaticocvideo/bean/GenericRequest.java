package com.claro.loginautomaticocvideo.bean;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class GenericRequest<T> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idRequest;
	private T params;
	public String getIdRequest() {
		return idRequest;
	}
	public void setIdRequest(String idRequest) {
		this.idRequest = idRequest;
	}
	public T getParams() {
		return params;
	}
	public void setParams(T params) {
		this.params = params;
	}
	@Override
	public String toString() {
		return "GenericRequest [idRequest=" + idRequest + ", params=" + params + "]";
	}
}
