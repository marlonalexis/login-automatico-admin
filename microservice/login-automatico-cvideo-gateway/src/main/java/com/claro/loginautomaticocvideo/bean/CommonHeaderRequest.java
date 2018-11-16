package com.claro.loginautomaticocvideo.bean;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class CommonHeaderRequest implements Serializable{

	private static final long serialVersionUID = 1L;
	private ChannelInfo channelInfo;
	private ConsumerInfo consumerInfo;
	private GeolocationInfo geolocationInfo;
	private OperationInfo operationInfo;
	public ChannelInfo getChannelInfo() {
		return channelInfo;
	}
	public void setChannelInfo(ChannelInfo channelInfo) {
		this.channelInfo = channelInfo;
	}
	public ConsumerInfo getConsumerInfo() {
		return consumerInfo;
	}
	public void setConsumerInfo(ConsumerInfo consumerInfo) {
		this.consumerInfo = consumerInfo;
	}
	public GeolocationInfo getGeolocationInfo() {
		return geolocationInfo;
	}
	public void setGeolocationInfo(GeolocationInfo geolocationInfo) {
		this.geolocationInfo = geolocationInfo;
	}
	public OperationInfo getOperationInfo() {
		return operationInfo;
	}
	public void setOperationInfo(OperationInfo operationInfo) {
		this.operationInfo = operationInfo;
	}
	@Override
	public String toString() {
		return "CommonHeaderRequest [channelInfo=" + channelInfo + ", consumerInfo=" + consumerInfo
				+ ", geolocationInfo=" + geolocationInfo + ", operationInfo=" + operationInfo + "]";
	}
}
