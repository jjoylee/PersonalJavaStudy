package DomSax;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMExample2 {

	public static void main(String[] args){
		DOMExample2 exam = new DOMExample2();
		Document doc = exam.parse();
		exam.printTagValue(doc, "list");
		exam.printTagValue(doc, "person");
		exam.printTagValue(doc, "name");
		exam.printTagValue(doc, "company");
		
		exam.printAttribute(doc, "list");
		exam.printAttribute(doc, "person");
		exam.printAttribute(doc, "name");
		exam.printAttribute(doc, "company");
	}

	private void printAttribute(Document doc, String tagName) {
		NodeList nodeList = doc.getElementsByTagName(tagName);
		
		for(int i =0 ; i < nodeList.getLength() ; i++){
			NamedNodeMap attrMap = nodeList.item(i).getAttributes();
			
			for(int j = 0 ; j < attrMap.getLength() ; j++){
				Node node = attrMap.item(j);
				System.out.println("AttrName : " + node.getNodeName() + " AttrValue : " + node.getNodeValue());
			}
		}
	}

	private void printTagValue(Document doc, String tagName) {
		NodeList nodeList = doc.getElementsByTagName(tagName);
		
		if(nodeList.getLength() == 0)
		{
			System.out.println("NO MATCHED NODE");
			return;
		}
		
		for(int i = 0 ; i < nodeList.getLength() ; i++){
			Node valueNode = nodeList.item(i).getChildNodes().item(0);
			
			if(valueNode.getNodeType() != Node.TEXT_NODE && valueNode.getNodeType() != Node.CDATA_SECTION_NODE)
				continue;
			
			String value = valueNode.getNodeValue();
			if(value != null)
				value = value.trim();
			System.out.println("TagName : " + tagName + "  value : " + value);
		}
	}

	private Document parse() {
		Document rtObj = null;
		String path = "E:/Eclipse/workspace/java/src/DomSax/personlist.xml";
		try{
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			rtObj = builder.parse(path);
		}catch(ParserConfigurationException|SAXException|IOException e){
			System.out.println("parsing error " + e);
		}
		return rtObj;
	}
}
