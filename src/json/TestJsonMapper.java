package json;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import junit.framework.TestCase;

public class TestJsonMapper extends TestCase{
	
	public void testGetJSONObject(){
		long beginTime = System.nanoTime();
		
		TestValue testVo = new TestValue();
		testVo.setAge(33);
		testVo.setCutomerName("Benjamin Kim");
		testVo.setHeight(174.3D);
		testVo.setMarried(true);
		testVo.setName("bungboor");
		testVo.setWeight(73.2F);
		
		JSONMapper<TestValue> mapper = new JSONMapper<TestValue>();
		try{
			JSONObject obj = mapper.getJSONObject(testVo);
			System.out.println(obj);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			double execTime = (double)(System.nanoTime() - beginTime)/1000000;
			System.out.println(execTime + " ms");
		}
	}
	
	public void testGetJSONArray(){
		long beginTime = System.nanoTime();
		
		TestValue testVo = new TestValue();
		testVo.setAge(33);
		testVo.setCutomerName("Benjamin Kim");
		testVo.setHeight(174.3D);
		testVo.setMarried(true);
		testVo.setName("bungboor");
		testVo.setWeight(73.2F);
		
		ArrayList<TestValue> testList = new ArrayList<TestValue>();
		for(int i = 0; i < 10 ; i++){
			testList.add(testVo);
		}
		
		JSONMapper<TestValue> mapper = new JSONMapper<TestValue>();
		try{
			JSONArray jsonArray = mapper.getJSONArray(testList);
			System.out.println(jsonArray);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			double execTime = (double)(System.nanoTime() - beginTime)/1000000;
			System.out.println(execTime + " ms");
		}
	}
	
	public void testGetValueObject(){
		long beginTime = System.nanoTime();
		
		JSONObject obj = new JSONObject();
		obj.put("age",33);
		obj.put("cutomerName","Benjamin Kim");
		obj.put("height",174.3D);
		obj.put("married",true);
		obj.put("name","bungboor");
		obj.put("weight",73.2F);
		
		JSONMapper<TestValue> mapper = new JSONMapper<TestValue>();
		try{
			TestValue vo = mapper.getValueObject(TestValue.class,obj);
			System.out.println(vo.getAge());
			System.out.println(vo.getCutomerName());
			System.out.println(vo.getHeight());
			System.out.println(vo.getName());
			System.out.println(vo.getWeight());
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			double execTime = (double)(System.nanoTime() - beginTime)/1000000;
			System.out.println(execTime + " ms");
		}
	}
	
	public void testGetValueList(){
		long beginTime = System.nanoTime();
		JSONArray jsonArray = new JSONArray();
		
		for(int i = 0 ; i < 10 ; i++){
			JSONObject obj = new JSONObject();
			obj.put("age",i);
			obj.put("cutomerName","Benjamin Kim");
			obj.put("height",174.3D);
			obj.put("married",true);
			obj.put("name","bungboor");
			obj.put("weight",73.2F);
			jsonArray.add(obj);
		}
		
		JSONMapper<TestValue> mapper = new JSONMapper<TestValue>();
		try{
			ArrayList<TestValue> testList = mapper.getValueObjectList(TestValue.class,jsonArray);
			for(TestValue test : testList){
				System.out.println(test.getName() + test.getAge());
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			double execTime = (double)(System.nanoTime() - beginTime)/1000000;
			System.out.println(execTime + " ms");
		}
	}
}
