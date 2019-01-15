package com.mapquest.util;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.Map;

import org.json.simple.JSONObject;

import io.restassured.response.Response;

public class Utils {
	
	public static final String MAPQUEST_URL = "http://www.mapquestapi.com";
	
	public static JSONObject getAddressJson(String address) {
		JSONObject optionsJson = new JSONObject();
		optionsJson.put("thumbMaps", false);
		optionsJson.put("maxResults", 1);
		JSONObject locationJson = new JSONObject();
		locationJson.put("location", address);
		locationJson.put("options", optionsJson);
		return locationJson;
	}

	public static String requestAddress(String address1, String apiKey) throws IOException {
		Response res = given().
				contentType("application/json").
				body( new LocationRequest(address1) ). //Utils.getAddressJson(address1).toJSONString()).
				post(MAPQUEST_URL + "/geocoding/v1/address?key=" + apiKey);
		Map<String, Object> locationHash = res.jsonPath().getMap("results[0].locations[0].latLng");
		return locationHash.get("lat") + "," + locationHash.get("lng");
	}
	
	public static Response getAddressMap(String coordinates, String apiKey) {
		return given().
				get(MAPQUEST_URL + "/staticmap/v5/map?key=" + apiKey + 
						"&type=map&size=225,160&locations=" + coordinates +
						"|marker-sm-50318A-1&scalebar=true&zoom=15&rand=-1793310972");
	}
	//MAPQUEST_URL
	
	

}
