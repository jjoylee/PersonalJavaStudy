package ReflectionTest;

import static org.junit.Assert.*;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Test;

import Reflection.ReflectionTarget;

public class ReflectionTest {
	
	Class clazz;
	
	@Before
	public void setUp() throws ClassNotFoundException{
		clazz = Class.forName("Reflection.ReflectionTarget");
	}
	
	@Test
	public void forName_test(){
		assertEquals(System.identityHashCode(clazz), System.identityHashCode(ReflectionTarget.class));
	}
	
	@Test
	public void getConstructors_test(){
		Constructor[] constructors = clazz.getConstructors();
		assertEquals(3, constructors.length); // private 생성자 제외
	}
	
	//DECLARED의 차이 DECLARED일때는 접근자가 PRIVATE인 것도 찾을 수 있음 하지만 DECLARED가 없으면 PRIVATE는 찾지 못함
	@Test
	public void getConstructor_test() throws NoSuchMethodException, SecurityException {
		Constructor constructor = clazz.getConstructor(String.class,int[].class);
		assertEquals(2,constructor.getParameterCount());
		//constructor = clazz.getConstructor(Integer.TYPE); PRIVATE - NO SUCH METHOD EXCEPTION 발생
	}
	
	@Test
	public void getDeclaredConstructors_test(){
		Constructor[] constructors = clazz.getDeclaredConstructors();
		assertEquals(5, constructors.length);
	}
	
	@Test
	public void getDeclaredConstructor_test() throws NoSuchMethodException, SecurityException{
		Constructor constructor = clazz.getDeclaredConstructor(Integer.TYPE);
		assertEquals(1, constructor.getParameterCount());
	}
	
	@Test
	public void getDeclaredFields_test() throws NoSuchMethodException, SecurityException{
		Field[] fields = clazz.getDeclaredFields();
		assertEquals(5, fields.length);
	}
	
	@Test
	public void getDeclaredField_test() throws NoSuchFieldException{
		Field field = clazz.getDeclaredField("field1");
		assertEquals(Integer.TYPE,field.getType());
	}
	
	@Test
	public void getDeclaredMethods_test() throws NoSuchFieldException{
		Method[] methods = clazz.getDeclaredMethods();
		assertEquals(10, methods.length);
	}
	
	@Test
	public void getDeclaredMethod_invoke_test() throws  NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Method method = clazz.getDeclaredMethod("getField2");
		assertEquals("getField2",method.getName());
		ReflectionTarget target = new ReflectionTarget("string1", new int[]{1});
		assertEquals("string1", method.invoke(target));
	}
	
	@Test
	public void getName_test(){
		assertEquals("Reflection.ReflectionTarget",clazz.getName());
		assertEquals("ReflectionTarget",clazz.getSimpleName());
	}
	
	@Test
	public void newInstance_test() throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException{
		Object obj = clazz.newInstance();
		assertTrue(obj instanceof ReflectionTarget);
		Constructor constructor = clazz.getConstructor();
		Object obj2 = constructor.newInstance();
		 	
	}
}
