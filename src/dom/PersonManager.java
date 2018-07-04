package dom;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class PersonManager {
	private SAXParser parser;
	
	public PersonManager() throws Exception{
		SAXParserFactory factory = SAXParserFactory.newInstance();
		parser = factory.newSAXParser();
	}
	
	public ArrayList<PersonValue> getPersonList(File file) throws Exception{
		PersonHandler handler = new PersonHandler();
		parser.parse(file, handler);
		return handler.getPersonList();
	}
}
