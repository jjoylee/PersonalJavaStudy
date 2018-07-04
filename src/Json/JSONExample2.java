package json;

import java.util.Vector;

import org.json.simple.JSONArray;

public class JSONExample2 {
	public static void main(String[] args){
		JSONExample2 example2 = new JSONExample2();
		JSONArray array1 = example2.createJSONArray();
		JSONArray array2 = example2.createMixedJSONArray();
		Vector vector = example2.createVector();
		
		System.out.println("result1 : " + array1.toString());
		System.out.println("result2 : " + array2.toString());
		System.out.println("result3 : " + JSONArray.toJSONString(vector));
	}

	private Vector createVector() {
		Vector vector = new Vector();
		vector.add("www.facebook.com");
		vector.add("www.daum.net");
		vector.add("www.google.co.kr");
		return vector;
	}

	private JSONArray createMixedJSONArray() {
		JSONExample1 exam = new JSONExample1();
		JSONArray array = new JSONArray();
		array.add("SEOUL");
		array.add("NEW YORK");
		array.add("KUALA LUMPUR");
		array.add(exam.createJSONObject());
		return array;
	}

	private JSONArray createJSONArray() {
		JSONArray array = new JSONArray();
		array.add("Benjamin");
		array.add("Hamzani");
		array.add("Lodoss");
		return array;
	}
}
