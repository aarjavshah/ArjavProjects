package com.cts.iot;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.json.JSONException;
import org.json.JSONObject;

public class GenerateJSON {
	public static String ConvertToJSON(SensorInputVO vo){
		String ret="";
		JSONObject innerObject = new JSONObject();
		Date d = new Date(System.currentTimeMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyhhmmssSSS");
		String newFormat = sdf.format(d);
		try {
			innerObject.put("ID", "IOTSIM");
			innerObject.put("TEMP", vo.getTemp());
			innerObject.put("LIGHT", vo.getLight());
			innerObject.put("MOTION", vo.getMotion());
			innerObject.put("TIME", newFormat);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		JSONObject object = new JSONObject();
		try {
			object.put("Record", innerObject);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		ret=object.toString();
		return ret;
	}
}
//{"ID": "ROOM101","TEMP": 30,"LIGHT": 100,"MOTION": 1}