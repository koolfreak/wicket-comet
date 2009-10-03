/**
 * 
 */
package com.sxi.cometd.utils;

import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author Emmanuel Nollase - emanux
 * created: Jul 14, 2009 - 4:05:35 PM
 *
 */
public final class JSONUtils {

	public static JSONObject getJSON(final Map<String, String> datas)
	{
		return new JSONObject(datas);
	}
	
	public static String jsonToString(final Map<String, String> datas)
	{
		final JSONObject json = getJSON(datas);
		json.remove(RemoteConstants.OUTGOING);
		return json.toString();
	}
	
	public static boolean isOutgoing(final Map<String, String> datas)
	{
		try {
			final JSONObject json = getJSON(datas);
			return json.getBoolean(RemoteConstants.OUTGOING);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		throw new IllegalArgumentException("Provide JSON key.");
	}
	
	public static String findStringValue(final Map<String, String> datas,final String key)
	{
		try {
			final JSONObject json = getJSON(datas);
			return json.getString(key);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		throw new IllegalArgumentException("Provide JSON key.");
	}
	
	public static boolean findBooleanValue(final Map<String, String> datas,final String key)
	{
		return Boolean.valueOf(findStringValue(datas,key));
	}
	
	public static String acceptMessage(final Map<String, String> datas)
	{
		final JSONObject json = getJSON(datas);
		json.remove(RemoteConstants.OUTGOING);
		
		return json.toString();
	}
	
	public static String rejectMessage(final Map<String, String> datas)
	{
		final JSONObject json = getJSON(datas);
		try {
			json.remove(RemoteConstants.OUTGOING);
			json.append("status", "Override Approved!");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return json.toString();
	}
	private JSONUtils(){}
}
