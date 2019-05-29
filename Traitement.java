package projet_java_xml;

import org.w3c.dom.*;
import javax.xml.xpath.*;
import javax.xml.parsers.*;
import org.xml.sax.*;


public class Traitement {
	
	
	public static void getNodeNameandValue(Document doc, XPath xpath) {
		
		XPathExpression exp;
		
		Object res = null;
		
		try {
			//exp = xpath.compile("//avion/*/text()");
			exp = xpath.compile("//avion/*/text()");
			res = exp.evaluate(doc, XPathConstants.NODESET);
			
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}
		
		NodeList node = (NodeList) res;
		for(int i=0; i<node.getLength();i++) {
			System.out.println(/*node.item(i).getParentNode().getNodeName() + " " +*/ node.item(i).getNodeValue());
		}
		
	}

	public static void main(String[] args) {
		
		DocumentBuilderFactory domfactory = DocumentBuilderFactory.newInstance();
		domfactory.setNamespaceAware(true);
		
		DocumentBuilder builder;
		
		Document doc = null;
		
		try {
			builder = domfactory.newDocumentBuilder();
			doc = builder.parse("./src/avion_xml.xml");
			
			XPath xpath = XPathFactory.newInstance().newXPath();
			
			getNodeNameandValue(doc, xpath);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		

	}

}
