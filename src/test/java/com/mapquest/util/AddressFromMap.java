package com.mapquest.util;

import java.util.HashMap;
import java.util.Map;

public class AddressFromMap {

	public static void main(String[] args) {
		Map<String, Object> h = new HashMap<String, Object>();
		h.put("lat", 20.62814);
		h.put("lng", -103.40812);
		System.out.println(h.get("lat") + "," + h.get("lng"));
	}

}
