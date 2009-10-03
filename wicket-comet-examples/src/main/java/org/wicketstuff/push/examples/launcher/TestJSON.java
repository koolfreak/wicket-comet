package org.wicketstuff.push.examples.launcher;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

public class TestJSON {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final Map<String, Object> jsonmap = new HashMap<String, Object>();
		jsonmap.put("eman", "nollase");
		jsonmap.put("mie", "almerol");
		
		JSONObject json = new JSONObject(jsonmap);
		System.out.println(json.toString());
	}

}
