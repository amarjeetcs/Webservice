package com.amarjeet.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.amarjeet.exception.CloudVendorNotFoundException;
import com.amarjeet.model.CloudVendor;
import com.amarjeet.repository.CloudVendorRepository;
import com.amarjeet.service.CloudVendorService;

@Service
public class CloudVendorServiceImpl implements CloudVendorService {

	CloudVendorRepository cloudVendorRepository;

	public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository) {
		this.cloudVendorRepository = cloudVendorRepository;
	}

	public String createCloudVendor(CloudVendor cloudVendor) {
		cloudVendorRepository.save(cloudVendor);
		return "Success";
	}

	public String updateCloudVendor(CloudVendor cloudVendor) {
		cloudVendorRepository.save(cloudVendor);
		return "Success";
	}

	public String deleteCloudVendor(String cloudVendorId) {
		cloudVendorRepository.deleteById(cloudVendorId);
		return "Success";
	}

	public CloudVendor getCloudVendor(String cloudVendorId) {
		if(cloudVendorRepository.findById(cloudVendorId).isEmpty())
			throw new CloudVendorNotFoundException("Requested cloud vendor is not exist..");
		return cloudVendorRepository.findById(cloudVendorId).get();
	}

	public List<CloudVendor> getAllCloudVendors() {
		return cloudVendorRepository.findAll();
	}

	@Override
	public List<CloudVendor> deleteAllCloudVendors() {
		 cloudVendorRepository.deleteAll();
		return null;
		 
		
	}

	@Override
	public List<CloudVendor> getByVendorName(String vendorName) {
		return 	cloudVendorRepository.findByVendorName(vendorName);
	
	}


}
