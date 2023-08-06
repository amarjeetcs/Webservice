package com.amarjeet.controller;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.amarjeet.model.CloudVendor;
import com.amarjeet.service.CloudVendorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

@WebMvcTest(CloudVendorController.class)
public class CloudVendorControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private CloudVendorService cloudVendorService;
	CloudVendor cloudVendorOne;
	CloudVendor cloudVendorTwo;

	List<CloudVendor> cloudVendorList = new ArrayList<>();
	
	@BeforeEach
	void SetUp()
	{
		cloudVendorOne=new CloudVendor("1","Amazon","USA","XXXX");
		cloudVendorTwo=new CloudVendor("2","GCP","UK","XXXX");
		cloudVendorList.add(cloudVendorOne);
		cloudVendorList.add(cloudVendorTwo);
		
	}
	
	@AfterEach
    void tearDown() {
    }

    @Test
    void getCloudVendorDetails() throws Exception {
        when(cloudVendorService.getCloudVendor("1")).thenReturn(cloudVendorOne);
        this.mockMvc.perform(get("/cloudvendor/" + "1")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void getAllCloudVendorDetails() throws  Exception {
        when(cloudVendorService.getAllCloudVendors()).thenReturn(cloudVendorList);
        this.mockMvc.perform(get("/cloudvendor"))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    void createCloudVendorDetails() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(cloudVendorOne);

        when(cloudVendorService.createCloudVendor(cloudVendorOne)).thenReturn("Success");
        this.mockMvc.perform(post("/cloudvendor")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    void updateCloudVendorDetails() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(cloudVendorOne);

        when(cloudVendorService.updateCloudVendor(cloudVendorOne))
                .thenReturn("Cloud Vendor Updated Successfully");
        this.mockMvc.perform(put("/cloudvendor")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    void deleteCloudVendorDetails() throws Exception {
        when(cloudVendorService.deleteCloudVendor("1"))
                .thenReturn("Cloud Vendor Deleted Successfully");
        this.mockMvc.perform(delete("/cloudvendor/" + "1"))
                .andDo(print()).andExpect(status().isOk());

    }
}
