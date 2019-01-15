package com.mapquest.util;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LocationRequest {
	
	String location;
	LocationOptions options;
	
	public LocationRequest(String address) {
		this.location = address;
		this.options = new LocationOptions();
	}
	
	public LocationRequest(String address, LocationOptions lop) {
		this.location = address;
		this.options = lop;
	}
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public LocationOptions getOptions() {
		return options;
	}
	public void setOptions(LocationOptions loc) {
		this.options = loc;
	}

	public String toJson() throws IOException{
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(new File("./file.json"), this);
		return mapper.writeValueAsString(this);
	}

}
