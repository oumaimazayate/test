package projet_java_xml;
import org.xml.sax.*;
import org.w3c.dom.*;

import java.io.IOException;

import javax.xml.parsers.*;

public class Lire {
	
	public static Document getDocument(String docstring) {
		
		try {
			
		DocumentBuilderFactory docfactory = DocumentBuilderFactory.newInstance();
		
		docfactory.setIgnoringComments(true);
		docfactory.setValidating(true);
		docfactory.setIgnoringElementContentWhitespace(true);
		
		DocumentBuilder builder = docfactory.newDocumentBuilder();
		
		return builder.parse(new InputSource(docstring));
		
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public static void getElementandAttribute(NodeList avionlist,String element) {
		
		try {
			for(int i=0; i<avionlist.getLength(); i++) {
				Node avion = avionlist.item(i);
				
				Element avion_elt = (Element)avion;
				
				NodeList typeList = avion_elt.getElementsByTagName(element);
				
				Element typeElt = (Element)typeList.item(0);
				
				NodeList typeEltList = typeElt.getChildNodes();
				
				System.out.println(element + ": "+(typeEltList.item(0).getNodeValue().trim()));
			
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static void main(String[] args) {
		Document xmldoc = getDocument("./src/avion_xml.xml");
		
		System.out.println("Root : "+xmldoc.getDocumentElement().getNodeName());
		
		NodeList avionlist = xmldoc.getElementsByTagName("avion");
		
		String element = "type_avion";
		
		getElementandAttribute(avionlist, element);
		
	}

}
