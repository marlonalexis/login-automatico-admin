package com.claro.loginautomaticocvideo.bean;

import java.io.Serializable;

public class ChannelInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	private String mediaDetailId;
	private String mediaId;
	
	public String getMediaDetailId() {
		return mediaDetailId;
	}
	public void setMediaDetailId(String mediaDetailId) {
		this.mediaDetailId = mediaDetailId;
	}
	public String getMediaId() {
		return mediaId;
	}
	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}
	@Override
	public String toString() {
		return "ChannelInfo [mediaDetailId=" + mediaDetailId + ", mediaId=" + mediaId + "]";
	}
}
