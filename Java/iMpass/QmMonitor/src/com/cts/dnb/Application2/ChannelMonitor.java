package com.cts.dnb.Application2;

import com.cts.dnb.Application1.BrokerDetailsVO;
import com.cts.dnb.Application1.FilePaths;
import com.cts.dnb.model3.QueueManager;
import com.ibm.mq.MQC;
import com.ibm.mq.MQEnvironment;
import com.ibm.mq.MQGetMessageOptions;
import com.ibm.mq.MQMessage;
import com.ibm.mq.MQPutMessageOptions;
import com.ibm.mq.MQQueue;
import com.ibm.mq.MQQueueManager;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ChannelMonitor {

	
	public static ChannelStatus getChannelStatus(String chName,String qmName){
		ChannelStatus chstatus = null;
		boolean flag =false;
		for(ChannelStatus tmp:ParseOutput(qmName)){
			if(tmp.getChName().equals(chName)){
				chstatus=tmp;
				flag= true;
				break;
			}
		}
		if(!flag){
			chstatus = new ChannelStatus();
			chstatus.setChName(chName);
			chstatus.setChStatus("Inactive");
			chstatus.setHost("Not Available");
		}
		return chstatus;
	}
	
	public static ArrayList<ChannelStatus> ParseOutput(String qmName){
		ArrayList<ChannelStatus> statuses = new ArrayList<ChannelStatus>();
		QueueManager qm = QueueBrowser.setQueueManagerParams(qmName);		
		String request = "a^C^"+qm.getConnectConfig().getQMname()+"^"+qm.getConnectConfig().getQMhost()+"^"+qm.getConnectConfig().getQMport()+"^"+qm.getConnectConfig().getQMchannel()+"^"+qm.getConnectConfig().getQMusername();
		String response = getResponse(request);
		      String channelStats[] = response.split("~");
		      
		      for(String x:channelStats){
		    	  ChannelStatus ch = new ChannelStatus();
		    	  String fields[] = x.split("\\^");
		    	  ch.setChName(fields[0]);
		    	  ch.setChStatus(fields[1]);
		    	  ch.setHost(fields[2]);
		    	  statuses.add(ch);
		    	  //System.out.println(ch.getChName()+"||"+ch.getChStatus()+"||"+ch.getHost());
		      }
		return statuses;
	}
	
	
	public static QueueProperties ParseOutput(String qmName,String qName){
		QueueProperties qp = new QueueProperties();
		QueueManager qm = QueueBrowser.setQueueManagerParams(qmName);
		String request = "a^Q^"+qm.getConnectConfig().getQMname()+"^"+qm.getConnectConfig().getQMhost()+"^"+qm.getConnectConfig().getQMport()+"^"+qm.getConnectConfig().getQMchannel()+"^"+qm.getConnectConfig().getQMusername()+"^"+qName;
		String response = getResponse(request);
		String [] properties = response.split("\\^");
		qp.setQueueName(properties[0]);
		qp.setQueueType(properties[1]);
		qp.setInhibitPutMessage(properties[2]);
		qp.setInhibitGetMessage(properties[3]);
		qp.setMaxDepth(Integer.parseInt(properties[4]));
		qp.setTargetQ(properties[5]);
		qp.setRemoteQM(properties[6]);
		qp.setRemoteQ(properties[7]);
		if(qp.getQueueType().equals("LOCAL")){
			qp.setCurDepth(Integer.parseInt(properties[8]));
			qp.setOpenInputCount(Integer.parseInt(properties[9]));
			qp.setOpenOutputCount(Integer.parseInt(properties[10]));
			qp.setLastGetDt(properties[11]);
			qp.setLastGetTm(properties[12]);
			qp.setLastPutDt(properties[13]);
			qp.setLastPutTm(properties[14]);
		}
		return qp;
	}
	
	public static String getResponse(String request){
		// connection details to connect to QM where application "ChannelStatusMQ" has been deployed
				String hostname = "158.151.157.129";
				String channel  = "SYSTEM.ADMIN.SVRCONN";     
				String qManager = "CL01";
				MQEnvironment.hostname = hostname;          
			    MQEnvironment.port  = 1414;
			    MQEnvironment.channel = channel;
			    MQEnvironment.password="satya@1986";
			    MQEnvironment.userID="muddadat";
			    //end of connection details
			    MQEnvironment.properties.put(MQC.TRANSPORT_PROPERTY, MQC.TRANSPORT_MQSERIES_CLIENT);
			    MQQueueManager qMgr=null;
			    MQQueue queue=null;
			    MQQueue queue1=null;
			    String response = "";
			    String InQName = FilePaths.getCH_INPUT();
			    String OutQName = FilePaths.getCH_OUTPUT();
			    try {
					qMgr = new MQQueueManager(qManager);			
					int openOptions = MQC.MQOO_OUTPUT | MQC.MQOO_INQUIRE ;
					queue =
				              qMgr.accessQueue(InQName,
				                               openOptions,
				                               null,           // default q manager
				                               null,           // no dynamic q name
				                               null);
					openOptions = MQC.MQOO_OUTPUT | MQC.MQOO_INQUIRE | MQC.MQOO_INPUT_AS_Q_DEF;
					queue1 = qMgr.accessQueue(OutQName,
		                    openOptions,
		                    null,           // default q manager
		                    null,           // no dynamic q name
		                    null);
					//String prepareMsg = "a^C^"+qm.getConnectConfig().getQMname()+"^"+qm.getConnectConfig().getQMhost()+"^"+qm.getConnectConfig().getQMport()+"^"+qm.getConnectConfig().getQMchannel()+"^"+qm.getConnectConfig().getQMusername();
					MQMessage inputTriggerMsg = new MQMessage();
					inputTriggerMsg.writeUTF(request);
				      MQPutMessageOptions pmo = new MQPutMessageOptions();
				      queue.put(inputTriggerMsg,pmo);
				      
				      Thread.sleep(5000);
				      
				      
				      
				      MQMessage theOutMessage    = new MQMessage();
				      MQGetMessageOptions gmo = new MQGetMessageOptions();
				      queue1.get(theOutMessage,gmo);
				      int strLen = theOutMessage.getMessageLength();
				      
				      byte[] strData = new byte[strLen];
				      theOutMessage.readFully(strData,0,strLen);
				      response = new String(strData);
			    	}catch(Exception e){
			    	 
			    	}
			 return response;
	}
	
}
