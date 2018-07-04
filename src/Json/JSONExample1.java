package Json;

import java.util.HashMap;

import org.json.simple.JSONObject;

public class JSONExample1 {
	public static void main(String[] args){
		JSONExample1 example = new JSONExample1();
		JSONObject obj = example.createJSONObject();
		HashMap map = example.getMapObject();
		System.out.println("result1 : " + obj.toJSONString());
		System.out.println("result2 : " + JSONObject.toJSONString(map));
	}

	public HashMap getMapObject() {
		HashMap map = new HashMap();
		map.put("URL", "www.facebook.com");
		map.put("ID", "byungboor");
		map.put("PW","1234");
		return map;
	}

	public JSONObject createJSONObject() {
		JSONObject obj = new JSONObject();
		obj.put("Name", "Benjamin");
		obj.put("Age", new Integer(33));
		obj.put("Marriage", new Boolean(true));
		obj.put("Location", "SeongNam City");
		return obj;
	}
}
