import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class FilePaths {
	public static String BROKER_DETAILS="/dnbusr1/mqm/jboss/apache-tomcat-6.0.33/conf/qmmonitor/qmmon/connections/bkrcon.xml";
//	public static String BROKER_DETAILS=		"\\\\\\\\PC310366\\\\Users\\\\Public\\\\DnBSharing\\\\DnBTool\\\\BrokerDetails\\\\BrokerDetails1.xml";
	public static String BROKER_STATUS="/dnbusr1/mqm/jboss/apache-tomcat-6.0.33/conf/qmmonitor/qmmon/bkrstatus/bkrstatus.xml";
//	public static String BROKER_STATUS="\\\\\\\\PC310366\\\\Users\\\\Public\\\\DnBSharing\\\\DnBTool\\\\BrokerStatus\\\\BrokerStatusXML.xml";
	public static String  ADDED_TO="/dnbusr1/mqm/jboss/apache-tomcat-6.0.33/conf/qmmonitor/qmmon/connections/temp.xml";
//	public static String  ADDED_TO=	"\\\\\\\\PC310366\\\\Users\\\\Public\\\\DnBSharing\\\\DnBTool\\\\BrokerDetails\\\\BrokerDetailsTemp.xml";
	public static String  LOG="/dnbusr1/mqm/jboss/apache-tomcat-6.0.33/conf/qmmonitor/qmmon/logs/accesslogs.log";
//	public static String  LOG="\\\\\\\\PC310366\\\\Users\\\\Public\\\\DnBSharing\\\\DnBTool\\\\ServiceMonitorLogs\\\\LogFile.log";
	public static String REQ_LOG="/dnbusr1/mqm/jboss/apache-tomcat-6.0.33/conf/qmmonitor/qmmon/logs/requests.xml";
	public static String QM_CONFIG="/dnbusr1/mqm/jboss/apache-tomcat-6.0.33/conf/qmmonitor/qmmon/connections/qmconfig.xml";
	public static String CH_INPUT="DNB.CHANNEL.STATUS.INPUT";
	public static String CH_OUTPUT="DNB.CHANNEL.STATUS.OUTPUT";
	public static String USER_LIST="/dnbusr1/mqm/jboss/apache-tomcat-6.0.33/conf/qmmonitor/qmmon/connections/users.xml";
	public static String CON_LIST="/dnbusr1/mqm/jboss/apache-tomcat-6.0.33/conf/qmmonitor/qmmon/connections/qmcon.xml";
	public static String QM_IP="158.151.157.130";
	public static int QM_PORT=1414;
	public static String QM_NAME="CL01";
	public static String QM_CHL="ESB.QMMON.SVRCONN";
	public static int WAIT_TIME_MIN = 10;
	public static final String  CONFIG_PATH_PRIMARY = "/dnbusr1/mqm/qmmonitor/config/mqmonconfig.xml"; 
	//public static final String  CONFIG_PATH_PRIMARY = "C:\\Users\\Public\\DnBSharing\\DnBTool\\Config\\ServiceMonitorConfig.xml";
	/*
	 * To be hard coded to unique Location 
	 */
	public static final String CONFIG_PATH = "/dnbusr1/mqm/jboss/apache-tomcat-6.0.33/conf/qmmonitor/qmmon/config/mqmonconfig.xml";
//	public static final String CONFIG_PATH = "C:\\Users\\Public\\DnBSharing\\DnBTool\\Config\\ServiceMonitorConfig.xml";
	
	public static int getWAIT_TIME_MIN() {
		setPaths();
		return WAIT_TIME_MIN;
		}
	public static String getBrokerDetails() {
		setPaths();
		return BROKER_DETAILS;
		}
	public static String getBrokerStatus() {	
		setPaths();
		return BROKER_STATUS;
		}
	public static String getAddedTo() {
		setPaths();
		return ADDED_TO;
		}
	public static String getLOG() {
		setPaths();
		return LOG;
	}	
	public static String getREQ_LOG() {
		setPaths();
		return REQ_LOG;
	}
	public static String getQM_CONFIG() {
		setPaths();
		return QM_CONFIG;
	}
	public static String getCH_INPUT() {
		setPaths();
		return CH_INPUT;
	}
	public static String getCH_OUTPUT() {
		setPaths();
		return CH_OUTPUT;
	}
	public static String getQM_CHL() {
		setPaths();
		return QM_CHL;
	}
	public static String getQM_IP() {
		setPaths();
		return QM_IP;
	}
	public static int getQM_PORT() {
		setPaths();
		return QM_PORT;
	}
	public static String getQM_NAME() {
		setPaths();
		return QM_NAME;
	}
	public static String getUSER_LIST() {
		setPaths();
		return USER_LIST;
	}
	
	public static String getCON_LIST() {
		setPaths();
		return CON_LIST;
	}
	public static void setPaths(){
		File c = new File(FilePaths.CONFIG_PATH_PRIMARY);
		String configPath;
		if(c.exists()){
			configPath = FilePaths.CONFIG_PATH_PRIMARY;
		}else{
			configPath = FilePaths.CONFIG_PATH;
		}
		//String configPath = CONFIG_PATH; 
				//"\\\\PC244928\\Users\\Public\\BSCExchange\\ServiceMonitor\\Config\\ServiceMonotrConfig.xml";
		//getting Data From config.XML file
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
			document = builder.parse(new File(configPath));
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		
		document.getDocumentElement().normalize();
		
		NodeList nList = document.getElementsByTagName("config");
		org.w3c.dom.Node node = nList.item(0);
		 if (node.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE){
			 Element eElement = (Element) node;
			 BROKER_DETAILS = eElement.getElementsByTagName("BrokerDetails").item(0).getTextContent();
			 BROKER_STATUS = eElement.getElementsByTagName("BrokerStatus").item(0).getTextContent();
			 WAIT_TIME_MIN = Integer.parseInt(eElement.getElementsByTagName("WaitTime").item(0).getTextContent());
			 ADDED_TO = eElement.getElementsByTagName("TempFile").item(0).getTextContent();
			 LOG = eElement.getElementsByTagName("LogFile").item(0).getTextContent();
			 REQ_LOG = eElement.getElementsByTagName("UpdateRequestFile").item(0).getTextContent();
			 QM_CONFIG = eElement.getElementsByTagName("QMConfigFile").item(0).getTextContent();
			 USER_LIST = eElement.getElementsByTagName("UserList").item(0).getTextContent();
			 CON_LIST = eElement.getElementsByTagName("QMConList").item(0).getTextContent();
			 CH_INPUT = eElement.getElementsByTagName("MsgFlowQIn").item(0).getTextContent();
			 CH_OUTPUT = eElement.getElementsByTagName("MsgFlowQOut").item(0).getTextContent();
			 QM_IP = eElement.getElementsByTagName("MsgFlowQMIP").item(0).getTextContent();
			 QM_NAME = eElement.getElementsByTagName("MsgFlowQMName").item(0).getTextContent();
			 QM_PORT = Integer.parseInt(eElement.getElementsByTagName("MsgFlowQMPort").item(0).getTextContent());
			 QM_CHL = eElement.getElementsByTagName("MsgFlowQMChl").item(0).getTextContent();
		 }
		}
	}