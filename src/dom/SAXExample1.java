package dom;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXExample1 {
	
	public static void main(String[] args){
		SAXExample1 example = new SAXExample1();
		try{
			example.parse();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private void parse() throws ParserConfigurationException, SAXException, IOException {
		File f = new File("E:/Eclipse/workspace/java/src/DomSax/personlist.xml");
		
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		SimpleHandler handler = new SimpleHandler();
		parser.parse(f, handler);
	}
	
	class SimpleHandler extends DefaultHandler{
		
		public void startDocument() throws SAXException{
			System.out.println("parsing start");
		}
		
		public void endDocument() throws SAXException{
			System.out.println("parsing end");
		}
		
		public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException{
			StringBuilder sb =  new StringBuilder();
			sb.append("uri = ").append(uri).append(", ");
			sb.append("localname = ").append(localName).append(", ");
			sb.append("qName = ").append(qName).append(" [");
			
			for(int i = 0 ; i < attributes.getLength() ; i++){
				sb.append(attributes.getQName(i) + " = " + attributes.getValue(i));
			}
			
			sb.append("]");
			System.out.println(sb.toString());
		}
	}
}
