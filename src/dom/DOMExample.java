package dom;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class DOMExample {
	
	public static void main(String[] args){
		DOMExample domParser = new DOMExample();
		String xmlFilePath = "E:/Eclipse/workspace/java/src/DomSax/personlist.xml";
		
		try{
			Document domObj = domParser.getTreeObj(xmlFilePath);
			if(domObj != null)
				System.out.println("parsing success");
			else
				System.out.println("parsing fail");
		}catch(Exception e){
			System.out.println("Dom parsing error" + e);
		}
	}

	private Document getTreeObj(String path) throws ParserConfigurationException, SAXException, IOException {
		Document rtObj = null;
		
		if(path == null || "".equals(path))
			throw new IllegalArgumentException("Parameter should not be null");
		
		File xmlFile = new File(path);
		if(!(xmlFile.exists() && xmlFile.isFile()))
			throw new IllegalArgumentException("Wrong Parameter");
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		rtObj = builder.parse(xmlFile);
		
		return rtObj;
	}
}
