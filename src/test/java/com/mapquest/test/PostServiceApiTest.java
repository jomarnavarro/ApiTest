package com.mapquest.test;

import java.util.List;
import java.util.Map;
import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mapquest.util.Post;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostServiceApiTest {
	private static final String URL = "http://localhost:3000";
	
	@Test
	public void testGet() {
		RequestSpecification getReqSpec = RestAssured.given();
		Response resp = getReqSpec.get(URL + "/posts/2");
		Map<String, Object> jsonResponse = resp.jsonPath().getMap("$");
		System.out.println(jsonResponse);
		for(String key: jsonResponse.keySet()) {
			System.out.println(key + ": " + jsonResponse.get(key));
		}		
	}
	
	@Test
	public void testGetIds() {
		RequestSpecification getReqSpec = RestAssured.given();
		Response res = getReqSpec.get(URL + "/posts");
		List<String> idList = res.jsonPath().getList("id");
		System.out.println(idList.get(0));
	}
	
	@Test
	public void testPost() {
		RequestSpecification reqSpec = RestAssured.given();
		reqSpec.header("Content-Type", "application/json");
		
		JSONObject json = new JSONObject();
		json.put("id", new Random().nextInt(50000) + "");
		json.put("title", "Selenium WebDriver");
		json.put("author", "Omar Navarro");
		
		
		
		reqSpec.body( new Post("Amor en tiempos del huachicoleo", "Felipe Calderon"));//json.toJSONString());
		
		Response resp = reqSpec.post(URL + "/posts");
		
		Assert.assertEquals(201, resp.getStatusCode());
		
		
	}
	
	@Test
	public void testDelete() {
		
		RequestSpecification reqSpec = RestAssured.given();
		reqSpec.header("Content-Type", "application/json");
		
		JSONObject json = new JSONObject();
		json.put("id", "25");
		json.put("title", "Selenium WebDriver");
		json.put("author", "Omar Navarro");
		
		reqSpec.body(json.toJSONString());
		
		Response resp = reqSpec.post(URL + "/posts");
		
		Assert.assertEquals(201, resp.getStatusCode());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestSpecification delReqSpec = RestAssured.given();
		resp = delReqSpec.delete(URL + "/posts/25");
		Assert.assertEquals(200, resp.getStatusCode());
	}
	
	@Test
	public void testPut() {
		RequestSpecification putReqSpec = RestAssured.given();
		putReqSpec.header("Content-Type", "application/json");
		JSONObject json = new JSONObject();
		json.put("id", "2");
		json.put("title", "Cucumber" + new Random().nextInt(5000));
		json.put("author", "Pedro Ramirez" + new Random().nextInt(5000));
		
		putReqSpec.body(json.toJSONString());
		
		Response resp = putReqSpec.put(URL + "/posts/2");
		Assert.assertEquals(200, resp.getStatusCode());		
	}
	
	@Test
	public void testPutIntegerIds() {
		RequestSpecification rs = RestAssured.given();
		Response res = rs.get(URL + "/posts");
		List<Map<String, String>> idList = res.jsonPath().getList("$");
		for(Map<String, String> entry: idList) {
			RequestSpecification putReqSpec = RestAssured.given();
			putReqSpec.header("Content-Type", "application/json");
			JSONObject json = new JSONObject();
			json.put("id", Integer.parseInt(entry.get("id")));
			json.put("author", entry.get("author"));
			json.put("title", entry.get("title"));
			putReqSpec.body(json.toJSONString());
			
			Response putRes = putReqSpec.put(URL + "/posts/" + entry.get("id"));
			Assert.assertEquals(200, putRes.getStatusCode());
		}
	}
}
