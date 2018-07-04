package dom;

import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import junit.framework.TestCase;

public class TestPersonParser extends TestCase{
	
	public void testPersonParser(){
		String filePath = "E:/Eclipse/workspace/java/src/DomSax/personlist.xml";
		
		try{
			PersonParser parser = new PersonParser();
			ArrayList<PersonValue> personList = parser.parse(filePath);
			for(int i = 0 ; i < personList.size(); i++){
				System.out.println(personList.get(i).toString());
			}
		}catch(ParserConfigurationException e){
			e.printStackTrace();
		}
	}
}
