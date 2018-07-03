package DomSax;

import java.io.CharArrayWriter;
import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class PersonHandler extends DefaultHandler{
	private final String TAG_PERSON = "person";
	private final String TAG_NAME = "name";
	private final String TAG_COMPANY = "company";
	private final String ATTR_ID = "id";
	
	private ArrayList<PersonValue> personList;
	private PersonValue personVo;
	private CharArrayWriter text;
	
	public PersonHandler(){
		personList = new ArrayList<PersonValue>();
		text = new CharArrayWriter();
	}
	
	public void startElement(String namespaceURI, String localName, String qName, Attributes attributes) throws SAXException{
		if(TAG_PERSON.equals(qName)){
			personVo = new PersonValue();
			long id = Long.parseLong(attributes.getValue(ATTR_ID));
			personVo.setId(id);
		}
	}
	
	public void endElement(String uri, String localName, String qName) throws SAXException{
		if(TAG_PERSON.equals(qName)){
			personList.add(personVo);
		}else if(TAG_NAME.equals(qName)){
			personVo.setName(getText());
			resetText();
		}
		else if(TAG_COMPANY.equals(qName)){
			personVo.setCompany(getText());
			resetText();
		}
	}
	
	public void characters(char[] ch, int offset, int length) throws SAXException{
		text.write(ch, offset, length);
	}
	
	public void resetText() {
		text.reset();
	}

	public String getText() {
		return text.toString().trim();
	}
	
	public ArrayList<PersonValue> getPersonList(){
		return this.personList;
	}
}
