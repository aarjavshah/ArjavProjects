package com.cts.dnb.Application2;

import java.util.ArrayList;

import com.cts.dnb.Application1.FilePaths;
import com.cts.dnb.model3.QueueManager;
import com.ibm.mq.MQC;
import com.ibm.mq.MQEnvironment;
import com.ibm.mq.MQGetMessageOptions;
import com.ibm.mq.MQMessage;
import com.ibm.mq.MQPutMessageOptions;
import com.ibm.mq.MQQueue;
import com.ibm.mq.MQQueueManager;

public class QMMonitor {
	
	/*public static ChannelStatus getChannelStatus(String chName){
	ChannelStatus chstatus = null;
	File file = new File(FilePaths.getCH_INPUT());
	File fileOut = new File(FilePaths.getCH_OUTPUT());
	fileOut.delete();
	boolean flag = false;
	try{
		if(file.createNewFile()){
			Thread.sleep(5000);
			while(!fileOut.exists()){}
			if(fileOut.exists()){
				for(ChannelStatus tmp:ParseOutput(fileOut)){
					if(tmp.getChName().equals(chName)){
						chstatus=tmp;
						flag= true;
						break;
					}
				}
				if(!flag){
					chstatus.setChName(chName);
					chstatus.setChStatus("Inactive");
					chstatus.setHost("Not Available");
				}
			}
		}
		else{
			file.delete();
		}
	}catch(Exception e){
		e.printStackTrace();
	}
	fileOut.delete();
	return chstatus;
}

public static ArrayList<ChannelStatus> ParseOutput(File output){
	ArrayList <ChannelStatus> returnStatus = new ArrayList<ChannelStatus>();
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
		document = builder.parse(output);
	} catch (SAXException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	
	document.getDocumentElement().normalize();
	NodeList nList = document.getElementsByTagName("Channel");
	for (int i = 0; i < nList.getLength(); i++)
	{
		org.w3c.dom.Node node = nList.item(i);
	 if (node.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE){
	    Element eElement = (Element) node;
	    ChannelStatus tmp = new ChannelStatus();
	    tmp.setChName(eElement.getElementsByTagName("ChName").item(0).getTextContent());
	    tmp.setChStatus(eElement.getElementsByTagName("Status").item(0).getTextContent());
	    tmp.setHost(eElement.getElementsByTagName("IP").item(0).getTextContent());
	 	returnStatus.add(tmp);
	 	}
	 
	}
	return returnStatus;
}*/
	public static ArrayList<ChannelStatus> getChannelStatus(String chName,String qmName){
		ArrayList<ChannelStatus> chstatus = new ArrayList<ChannelStatus>();
		boolean flag =false;
		for(ChannelStatus tmp:ParseOutput(qmName)){
			if(tmp.getChName().equals(chName)){
				chstatus.add(tmp);
				flag= true;
			}
		}
		if(!flag){
			ChannelStatus ch = new ChannelStatus();
			ch.setChName(chName);
			ch.setChStatus("Inactive");
			ch.setHost("Not Available");
			ch.setSubState("Unknown");
			ch.setChType("Unknown");
			chstatus.add(ch);
		}
		return chstatus;
	}
	
	public static ArrayList<ChannelStatus> ParseOutput(String qmName){
		ArrayList<ChannelStatus> statuses = new ArrayList<ChannelStatus>();
		QueueManager qm = QueueBrowser.setQueueManagerParams(qmName);		
		String request = "a^C^"+qm.getConnectConfig().getQMname()+"^"+qm.getConnectConfig().getQMhost()+"^"+qm.getConnectConfig().getQMport()+"^"+qm.getConnectConfig().getQMchannel()+"^"+qm.getConnectConfig().getQMusername();
		String response = getResponse(request);
		//System.out.println(request);
		//System.out.println(response);
		      String channelStats[] = response.split("~");
		      
		      for(String x:channelStats){
		    	  ChannelStatus ch = new ChannelStatus();
		    	  String fields[] = x.split("\\^");
		    	  ch.setChName(fields[0]);
		    	  ch.setChStatus(fields[1]);
		    	  ch.setHost(fields[2]);
		    	  ch.setSubState(fields[3]);
		    	  ch.setChType(fields[4]);
		    	  ch.setLstMsgDt(fields[5]);
		    	  ch.setLstMsgTm(fields[6]);
		    	  statuses.add(ch);
		    	  //System.out.println(ch.getChName()+"||"+ch.getChStatus()+"||"+ch.getHost());
		      }
		return statuses;
	}
	
	
	public static QueueProperties ParseOutput(String qmName,String qName){
		QueueProperties qp = new QueueProperties();
		QueueManager qm = QueueBrowser.setQueueManagerParams(qmName);
		String request = "a^Q^"+qm.getConnectConfig().getQMname()+"^"+qm.getConnectConfig().getQMhost()+"^"+qm.getConnectConfig().getQMport()+"^"+qm.getConnectConfig().getQMchannel()+"^"+qm.getConnectConfig().getQMusername()+"^"+qName;
		//System.out.println(request);
		String response = getResponse(request);
		//System.out.println(response);
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
			ArrayList<QueueListener> listenerList = new ArrayList<QueueListener>();
			if(Integer.parseInt(properties[9])>0||Integer.parseInt(properties[10])>0){
				String lsnrList = properties[15];	
				String [] listeners = lsnrList.split("\\|@");
				for(String tmp:listeners){
					QueueListener ql = new QueueListener();
					String [] values = tmp.split("#");
					ql.setConName(values[0]);
					ql.setChName(values[1]);
					ql.setType(values[2]);
					listenerList.add(ql);
				}
			}
		qp.setListenerList(listenerList);					
		}
		return qp;
	}
	
	public static TopicProperties ParseOutput(String qmName, String tpName, String type){
		TopicProperties tpProperties = new TopicProperties();
		QueueManager qm = QueueBrowser.setQueueManagerParams(qmName);
		String request = "a^T^"+qm.getConnectConfig().getQMname()+"^"+qm.getConnectConfig().getQMhost()+"^"+qm.getConnectConfig().getQMport()+"^"+qm.getConnectConfig().getQMchannel()+"^"+qm.getConnectConfig().getQMusername()+"^"+tpName;
		String response = getResponse(request);
		System.out.println(response);
		String [] properties = response.split("\\^");
		tpProperties.setTopicName(properties[0]);
		tpProperties.setTopicString(properties[1]);
		tpProperties.setTopicDesc(properties[2]);
		tpProperties.setPubAllowed(properties[3]);
		tpProperties.setSubAllowed(properties[4]);
		return tpProperties;
	}
	
	public static String getResponse(String request){
		// connection details to connect to QM where application "ChannelStatusMQ" has been deployed
				String hostname = FilePaths.getQM_IP();
				String channel  = FilePaths.getQM_CHL();     
				String qManager = FilePaths.getQM_NAME();
				MQEnvironment.hostname = hostname;          
			    MQEnvironment.port  = FilePaths.getQM_PORT();
			    MQEnvironment.channel = channel;
			    MQEnvironment.userID="aarjav.shah";
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
					inputTriggerMsg.writeString(request);
				      MQPutMessageOptions pmo = new MQPutMessageOptions();
				      queue.put(inputTriggerMsg,pmo);
				      
				      Thread.sleep(1000);
				      
				      
				      
				      MQMessage theOutMessage    = new MQMessage();
				      MQGetMessageOptions gmo = new MQGetMessageOptions();
				      queue1.get(theOutMessage,gmo);
				      int strLen = theOutMessage.getMessageLength();
				      
				      byte[] strData = new byte[strLen];
				      theOutMessage.readFully(strData,0,strLen);
				      response = new String(strData);
				      queue.close();
				      queue1.close();
				      qMgr.close();
			    	}catch(Exception e){
			    	 
			    	}
			 return response;
	}
}
