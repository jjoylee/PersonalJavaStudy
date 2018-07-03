package DomSax;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class PersonParser {
	
	private final String TAG_PERSON = "person";
	private final String TAG_NAME = "name";
	private final String TAG_COMPANY = "company";
	private final String ATTR_ID = "id";
	
	private DocumentBuilderFactory factory;
	private DocumentBuilder builder;
	private Document doc;
	
	public PersonParser() throws ParserConfigurationException{
		factory = DocumentBuilderFactory.newInstance();
		builder = factory.newDocumentBuilder();
	}
	
	public ArrayList<PersonValue> parse(String filePath){
		ArrayList<PersonValue> rt = new ArrayList<>();
		
		if(filePath==null || "".equals(filePath))
			return rt;
		
		try{
			doc = builder.parse(filePath);
			NodeList nodeList = doc.getElementsByTagName(this.TAG_PERSON);
			for(int i = 0; i< nodeList.getLength() ; i++){
				PersonValue personVO = new PersonValue();
				Node node = nodeList.item(i);
				
				NamedNodeMap attrMap = node.getAttributes();
				for(int j = 0 ; j < attrMap.getLength() ; j++){
					Node attrNode = attrMap.item(j);
					if(this.ATTR_ID.equals(attrNode.getNodeName())){
						personVO.setId(Long.parseLong(attrNode.getNodeValue()));
						break;
					}
				}
				
				NodeList childNodeList = node.getChildNodes();
				
				for(int j = 0 ; j < childNodeList.getLength() ; j++){
					Node childNode = childNodeList.item(j);
					
					if(this.TAG_NAME.equals(childNode.getNodeName())){
						personVO.setName(childNode.getChildNodes().item(0).getNodeValue());
					}
					else if(this.TAG_COMPANY.equals(childNode.getNodeName())){
						personVO.setCompany(childNode.getChildNodes().item(0).getNodeValue());
					}
					else
						continue;
				}
				rt.add(personVO);
			}
			
		}catch(SAXException | IOException e){
			System.out.println("parsing error : " + e);
		}
		return rt;
	}
}
