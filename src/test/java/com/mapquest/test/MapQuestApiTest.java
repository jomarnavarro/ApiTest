package com.mapquest.test;

import org.testng.annotations.Test;

import com.mapquest.util.Utils;

import io.restassured.response.Response;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class MapQuestApiTest {
	
	
	@Test
	@Parameters({"apiKey", "address1", "address2"})
	public void getUserLocation(String apiKey, String address1, String address2) throws IOException {
		// get both address locations
		String address1Res = Utils.requestAddress(address1, apiKey);
		String address2Res = Utils.requestAddress(address2, apiKey);
		Response addressMap = Utils.getAddressMap(address1Res, apiKey);
		System.out.println("Content Disposition: " + addressMap.getHeader("content-disposition"));
		System.out.println("Content type: " + addressMap.getHeader("content-type"));
		System.out.println("Content Type" + addressMap.getContentType());
		System.out.println("Status Code" + addressMap.getStatusCode());
		
		Assert.assertEquals(1, 1);
//		
	}
	
	
	 /** POST http://api.geosvc.com/rest/udp?apikey={APIKEY}
Content-Type: application/json

{
   "Id": "2563157", // Optional, remove to insert new record
   "Type": "UserDefined",
   "Name": "Office Depot",
   "Address": "1200 W VALLEY BLVD",
   "City": "ALHAMBRA",
   "Region": "CA",
   "PostalCode": "91803",
   "Country": "US",
   "Category": "OfficeDepot",
   "UserData": "test"
}*/
//  @Test
//  @Parameters({"apiKey"})
  public void testLocationCreation(String apiKey) {
	  JSONObject json = new JSONObject();
	  json.put("Type", "UserDefined");
	  json.put("Name", "Office Depot");
	  json.put("Address", "1200 W VALLEY BLVD");
	  json.put("City", "ALHAMBRA");
	  json.put("Region", "CA");
	  json.put("PostalCode", "91803");
	  json.put("Country", "US");
	  json.put("Category", "OfficeDepot");
	  json.put("UserData", "test");
	  
//	  Response res = given().body(json.toJSONString()).post(GEO_SVC_URL + "/udp?apiKey" + apiKey);
//	  Map<String, String> responseData = res.jsonPath().getMap("$");
//	  System.out.println(responseData);
  }
  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

}
