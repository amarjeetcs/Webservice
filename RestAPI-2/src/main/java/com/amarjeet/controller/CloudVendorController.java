package com.amarjeet.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amarjeet.model.CloudVendor;
import com.amarjeet.resopnse.ResponseHandler;
import com.amarjeet.service.CloudVendorService;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorController {

	CloudVendorService cloudVendorService;

	public CloudVendorController(CloudVendorService cloudVendorService) {
		this.cloudVendorService = cloudVendorService;
	}

	@GetMapping("{vendorId}")
	public ResponseEntity<Object> getCloudVendorDetails(@PathVariable("vendorId") String vendorId) {
		return ResponseHandler.responseBuilder("Request Vendor details is given here",
				HttpStatus.OK,
				cloudVendorService.getCloudVendor(vendorId));
		
	}

	@GetMapping()
	public List<CloudVendor> getAllCloudVendorDetails() {
		return cloudVendorService.getAllCloudVendors();
	}

	@PostMapping()
	public String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor) {
		cloudVendorService.createCloudVendor(cloudVendor);
		return "cloud vendor create successfully";
	}

	@PutMapping()
	public String updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor) {
		cloudVendorService.updateCloudVendor(cloudVendor);
		return "cloud vendor updated successfully";
	}

	@DeleteMapping("{vendorid}")
	public String deleteCloudVendorDetails(@PathVariable("vendorid") String vendorId) {
		cloudVendorService.deleteCloudVendor(vendorId);
		return "cloud vendor deleted successfully";
	}

	@DeleteMapping()
	public List<CloudVendor> deleteCloudVendorDetails1(String vendorId) {

		return cloudVendorService.deleteAllCloudVendors();

	}

}
