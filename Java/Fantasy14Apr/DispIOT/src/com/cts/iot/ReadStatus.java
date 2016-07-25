package com.cts.iot;
import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class ReadStatus{
	public static StatusVO GetStatus(){
		StatusVO ret = new StatusVO();
		File statusFile = new File("D:\\MQTT\\Data.xml");
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
			document = builder.parse(statusFile);
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


		NodeList nList = document.getElementsByTagName("Status");
		for (int temp = 0; temp < nList.getLength(); temp++)
		{
			org.w3c.dom.Node node = nList.item(temp);
			if (node.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE){
				Element eElement = (Element) node;
				ret.setAcStatus(new Boolean(eElement.getElementsByTagName("AC").item(0).getTextContent()));
				ret.setHeaterStatus(new Boolean(eElement.getElementsByTagName("Heater").item(0).getTextContent()));
				ret.setLightStatus(new Boolean(eElement.getElementsByTagName("Light").item(0).getTextContent()));
			}
		}
		return ret;
		}
}
