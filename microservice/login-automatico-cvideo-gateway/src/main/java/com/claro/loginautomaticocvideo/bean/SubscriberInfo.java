package com.claro.loginautomaticocvideo.bean;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class SubscriberInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	private String name;
	private String lastName;
	private AddressInfo addressInfo;
	private List<ContactInfo> contactInfo;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public AddressInfo getAddressInfo() {
		return addressInfo;
	}
	public void setAddressInfo(AddressInfo addressInfo) {
		this.addressInfo = addressInfo;
	}
	public List<ContactInfo> getContactInfo() {
		return contactInfo;
	}
	public void setContactInfo(List<ContactInfo> contactInfo) {
		this.contactInfo = contactInfo;
	}
	@Override
	public String toString() {
		return "SubscriberInfo [name=" + name + ", lastName=" + lastName + ", addressInfo=" + addressInfo
				+ ", contactInfo=" + contactInfo + "]";
	}
	
}
