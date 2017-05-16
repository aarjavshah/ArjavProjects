

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.ibm.broker.config.proxy.BrokerProxy;
import com.ibm.broker.config.proxy.ConfigManagerProxyPropertyNotInitializedException;
import com.ibm.jsse2.util.e;
import com.ibm.security.krb5.internal.crypto.x;
import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import com.sun.xml.internal.txw2.Document;

public class BrokerXML {
	public static ArrayList<String> RetrievebrokerList(){
		ArrayList<String> brokerList = new ArrayList<String>();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		org.w3c.dom.Document document = null;
		try {
			document = builder.parse(new File(FilePaths.getBrokerDetails()));
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		
		document.getDocumentElement().normalize();
		 
		//Element root = document.getDocumentElement();
		//System.out.println(root.getNodeName());
		 
		
		NodeList nList = document.getElementsByTagName("broker");
		for (int temp = 0; temp < nList.getLength(); temp++)
		{
			org.w3c.dom.Node node = nList.item(temp);
		 if (node.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE){
		    Element eElement = (Element) node;
		    String tmp = eElement.getElementsByTagName("broker-name").item(0).getTextContent();
		    brokerList.add(tmp);
		   // System.out.println(tmp);
		 	}
		}
		return brokerList;
	}
	public static ArrayList<BrokerDetailsVO> RetrieveDetailedbrokerList(){
		ArrayList<BrokerDetailsVO> brokerList = new ArrayList<BrokerDetailsVO>();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		org.w3c.dom.Document document = null;
		try {
			document = builder.parse(new File(FilePaths.getBrokerDetails()));
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		
		document.getDocumentElement().normalize();
		 
		//Element root = document.getDocumentElement();
		//System.out.println(root.getNodeName());
		 
		
		NodeList nList = document.getElementsByTagName("broker");
		for (int temp = 0; temp < nList.getLength(); temp++)
		{
			org.w3c.dom.Node node = nList.item(temp);
		 if (node.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE){
		    Element eElement = (Element) node;
		    BrokerDetailsVO tmp = new BrokerDetailsVO();
		    tmp.setBrokerName(eElement.getElementsByTagName("broker-name").item(0).getTextContent());
		    tmp.setAlias(eElement.getElementsByTagName("alias").item(0).getTextContent());
		    tmp.setQueueManagerName(eElement.getElementsByTagName("Queue-manager").item(0).getTextContent());
		    tmp.setHost(eElement.getElementsByTagName("host").item(0).getTextContent());
		    tmp.setPort(Integer.parseInt(eElement.getElementsByTagName("port").item(0).getTextContent()));		    
		    brokerList.add(tmp);
		   // System.out.println(tmp);
		 	}
		}
		return brokerList;
	}
	
	public static BrokerDetailsVO RetrievebrokerDetails(BrokerDetailsVO x) {
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
			org.w3c.dom.Document document = builder.parse(new File(FilePaths.getBrokerDetails()));
		
		 
		
		document.getDocumentElement().normalize();
		 
		//Element root = document.getDocumentElement();
		//System.out.println(root.getNodeName());
		 
		
		NodeList nList = document.getElementsByTagName("broker");
		for (int temp = 0; temp < nList.getLength(); temp++)
		{
			org.w3c.dom.Node node = nList.item(temp);
		 if (node.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE)
		 {
		    Element eElement = (Element) node;
		    String tmp = eElement.getElementsByTagName("broker-name").item(0).getTextContent();
		    if(tmp.equals(x.getBrokerName())){
		    	x.setHost(eElement.getElementsByTagName("host").item(0).getTextContent());
		    	x.setAlias(eElement.getElementsByTagName("alias").item(0).getTextContent());
		    	x.setPort(Integer.parseInt(eElement.getElementsByTagName("port").item(0).getTextContent()));
		    	x.setQueueManagerName(eElement.getElementsByTagName("Queue-manager").item(0).getTextContent());
		    	break;
		    }
		 }
		
	}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return x;

}
	}
