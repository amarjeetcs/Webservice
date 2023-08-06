package com.amarjeet.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="AMARJEET_CLOUD_VENDOR")
public class CloudVendor {
	
	@Id
	private String vendorId;
	private String vendorName;
	private String vendorAddress;
	private String vendorPhoneNumber;

	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getVendorAddress() {
		return vendorAddress;
	}

	public void setVendorAddress(String vendorAddress) {
		this.vendorAddress = vendorAddress;
	}

	public String getVendorPhoneNumber() {
		return vendorPhoneNumber;
	}

	public void setVendorPhoneNumber(String vendorPhoneNumber) {
		this.vendorPhoneNumber = vendorPhoneNumber;
	}

	public CloudVendor() {
		super();
		
	}

	public CloudVendor(String vendorId, String vendorName, String vendorAddress, String vendorPhoneNumber) {
		super();
		this.vendorId = vendorId;
		this.vendorName = vendorName;
		this.vendorAddress = vendorAddress;
		this.vendorPhoneNumber = vendorPhoneNumber;
	}

	@Override
	public String toString() {
		return "CloudVendor [vendorId=" + vendorId + ", vendorName=" + vendorName + ", vendorAddress=" + vendorAddress
				+ ", vendorPhoneNumber=" + vendorPhoneNumber + "]";
	}

}
