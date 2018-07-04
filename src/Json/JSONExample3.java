package json;

import java.util.Iterator;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONExample3 {
	public static void main(String[] args){
		JSONExample3 example = new JSONExample3();
		String str = example.getStringByJSONObject();
		Object obj = example.parseJSON(str);
		example.analysis(obj);
		
		System.out.println("========================");
		
		str = example.getStringByJSONArray();
		obj = example.parseJSON(str);
		example.analysis(obj);
	}

	private String getStringByJSONArray() {
		JSONArray rtArray = new JSONArray();
		rtArray.add("Mongolia");
		rtArray.add("The Great Korea");
		rtArray.add("ITALY");
		return rtArray.toJSONString();
	}

	private void analysis(Object obj) {
		if(obj instanceof JSONArray){
			JSONArray array = (JSONArray)obj;
			Iterator iter = array.iterator();
			while(iter.hasNext()){
				System.out.print("[" + iter.next() + "]");
			}
			System.out.println("");
		}
		else if(obj instanceof JSONObject){
			JSONObject jsonObj = (JSONObject)obj;
			Set keySet = jsonObj.keySet();
			for(Object key : keySet){
				Object value = jsonObj.get(key);
				System.out.println("[" + key + "/" + value + "]");
			}
		}
		else{
			System.out.println("can't analysis");
		}
	}

	private Object parseJSON(String jsonString) {
		Object rt = null;
		JSONParser parser = new JSONParser();
		try{
			rt = parser.parse(jsonString);
		}catch(ParseException e){
			e.printStackTrace();
		}
		return rt;
	}

	private String getStringByJSONObject() {
		JSONObject rtObj = new JSONObject();
		rtObj.put("NAME", "Benjamin Kim");
		rtObj.put("LOCATION", "SeongName City");
		rtObj.put("FIELD", "JAVA Programming");
		return rtObj.toJSONString();
	}
}
