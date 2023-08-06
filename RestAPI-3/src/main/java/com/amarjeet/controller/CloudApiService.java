package com.amarjeet.controller;


import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amarjeet.model.CloudVendor;


@RestController
@RequestMapping("/cloudvendor")
public class CloudApiService {
	
	CloudVendor cloudVendor;

	@GetMapping("{vendorId}")
	public CloudVendor getCloudVendorDetails(String vendorId) {
		return cloudVendor;
				//new CloudVendor ("C1","sanjeet","Banglore","6261535069");

	}

	@PostMapping
	public String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor) {
		this.cloudVendor=cloudVendor;
		return "cloud vendor create successfully";	
	}

	@PutMapping
	public String updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor) {
		this.cloudVendor=cloudVendor;
		return "cloud vendor updated successfully";
	}
	
	@DeleteMapping("{vendorid}")
	public String deleteCloudVendorDetails(String vendorId) {
		this.cloudVendor=null;
		return "cloud vendor deleted successfully";
	}
	
	
}
