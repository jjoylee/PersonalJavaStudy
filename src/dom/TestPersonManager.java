package dom;

import java.io.File;
import java.util.ArrayList;

import junit.framework.TestCase;

public class TestPersonManager extends TestCase{
	
	public void testPersonParser(){
		File xmlFile = new File("E:/Eclipse/workspace/java/src/DomSax/personlist.xml");
		
		try{
			PersonManager personMgr = new PersonManager();
			ArrayList<PersonValue> personList = personMgr.getPersonList(xmlFile);
			for(int i = 0 ; i < personList.size() ; i++){
				System.out.println(personList.get(i).toString());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
