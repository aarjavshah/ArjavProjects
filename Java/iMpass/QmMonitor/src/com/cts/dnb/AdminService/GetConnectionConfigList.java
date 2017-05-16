package com.cts.dnb.AdminService;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.cts.dnb.Application1.FilePaths;
import com.cts.dnb.Application1.QMUtilityVO;
import com.cts.dnb.model3.ConnectConfig;

public class GetConnectionConfigList {
	
	public static ArrayList<QMUtilityVO> RetrieveQmConnectList(){
		ArrayList<QMUtilityVO> voList = new ArrayList<QMUtilityVO>();
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
			document = builder.parse(new File(FilePaths.getCON_LIST()));
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
		 
		
		NodeList nList = document.getElementsByTagName("QM");
		for (int temp = 0; temp < nList.getLength(); temp++)
		{
			org.w3c.dom.Node node = nList.item(temp);
			
		 if (node.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE){
		    Element eElement = (Element) node;
		    ConnectConfig tmp = new ConnectConfig();
		    QMUtilityVO vo =new QMUtilityVO();
		    tmp.setQMname(eElement.getElementsByTagName("QMname").item(0).getTextContent());
		    tmp.setQMhost(eElement.getElementsByTagName("QMhost").item(0).getTextContent());
		    tmp.setQMport(eElement.getElementsByTagName("QMport").item(0).getTextContent());
		    tmp.setQMchannel(eElement.getElementsByTagName("QMchannel").item(0).getTextContent());
		    tmp.setQMusername(eElement.getElementsByTagName("QMusername").item(0).getTextContent());
		    String env = eElement.getElementsByTagName("QMEnv").item(0).getTextContent();
		    vo.setCon(tmp);
		    vo.setEnv(env);
		    voList.add(vo);
		   // System.out.println(tmp);
		 	}
		}
		return voList;
	}
	
	public static ArrayList<String> getQMName(){
		ArrayList<String> qmList = new ArrayList<String>();
		for(QMUtilityVO tmp : RetrieveQmConnectList()){
			qmList.add(tmp.getCon().getQMname());
		}
		return qmList;
	}
	
	public static QMUtilityVO getQMConParam(String qmName){
		QMUtilityVO ret = new QMUtilityVO();
		if(isQMExisting(qmName)){
			for(QMUtilityVO tmp : RetrieveQmConnectList()){
				if(tmp.getCon().getQMname().equals(qmName)){
					ret = tmp;
				}
			}
		}else{
			ret = null;
		}
		return ret;
	}
	
	public static boolean isQMExisting(String qmName){
		boolean ret = false;
		for(String x:getQMName()){
			if(x.equals(qmName)){
				ret = true;
				break;
			}
		}
		return ret;
	}
}
