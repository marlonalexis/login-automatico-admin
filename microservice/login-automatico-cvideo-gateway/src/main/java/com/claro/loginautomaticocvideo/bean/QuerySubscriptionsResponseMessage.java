package com.claro.loginautomaticocvideo.bean;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class QuerySubscriptionsResponseMessage implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer code;
	private String message;
	private List<Subscriptions> subscriptions;
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<Subscriptions> getSubscriptions() {
		return subscriptions;
	}
	public void setSubscriptions(List<Subscriptions> subscriptions) {
		this.subscriptions = subscriptions;
	}
	@Override
	public String toString() {
		return "QuerySubscriptionsResponseMessage [code=" + code + ", message=" + message + ", subscriptions="
				+ subscriptions + "]";
	}
}
