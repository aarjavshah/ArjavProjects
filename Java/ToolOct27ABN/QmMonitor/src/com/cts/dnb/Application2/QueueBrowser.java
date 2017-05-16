package com.cts.dnb.Application2;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import com.cts.dnb.Application1.FilePaths;
import com.cts.dnb.model3.ObjectFactory;
import com.cts.dnb.model3.QueueManagers;
import com.cts.dnb.model3.QueueManager;
import com.ibm.mq.MQC;
import com.ibm.mq.MQEnvironment;
import com.ibm.mq.MQException;
import com.ibm.mq.MQQueue;
import com.ibm.mq.MQQueueManager;

public class QueueBrowser {

	public static final int ALPHABATE_START= 65;
	
	public static QueueManagers getQMRoot(){
		File file = new File(FilePaths.getQM_CONFIG());
		JAXBContext jaxbContext;
		QueueManagers qms =new QueueManagers();
		try {
			jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Source source = new StreamSource(file);
			JAXBElement<QueueManagers> root = jaxbUnmarshaller. unmarshal(source, QueueManagers.class);
			qms = root.getValue();}
		catch(Exception e){
			e.printStackTrace();
		}
		return qms;
	}
	
	
	public static ArrayList<String> getAllQueues(String qmName) {
		ArrayList<String> queueList = new ArrayList<String>();
		QueueManagers qms = QueueBrowser.getQMRoot();
		for(QueueManager tmp : qms.getQueueManager()){
			if(tmp.getConnectConfig().getQMname().equals(qmName)){
				queueList = (ArrayList<String>)tmp.getQueues().getQueue();
			}
		}
		//queueList = (ArrayList<String>) qms.getQueueManager().get(0).getQueues().getQueue();
		
		return queueList;
	}
	
	public static ArrayList<String> getAllChannels(String qmName) {
		ArrayList<String> channelList = new ArrayList<String>();
		QueueManagers qms = QueueBrowser.getQMRoot();
		for(QueueManager tmp : qms.getQueueManager()){
			if(tmp.getConnectConfig().getQMname().equals(qmName)){
				channelList = (ArrayList<String>)tmp.getChannels().getChannel();
			}
		}
		//channelList = (ArrayList<String>) qms.getQueueManager().get(0).getChannels().getChannel();
		
		return channelList;
	}
	
	public static ArrayList<String> getAlphabateList(){
		ArrayList<String> alphaList = new ArrayList<String>();
		String cap,sml;
		for(int i=ALPHABATE_START;i<ALPHABATE_START+26;i++){
			cap = Character.toString((char)i);
			sml = Character.toString((char)(i+32));
			alphaList.add(cap+"/"+sml);
		}
			
		return alphaList;
	}
	
	public static ArrayList<String> getFilteredQueues(String startsWith,String qmName) {
		ArrayList<String> queueList = new ArrayList<String>();
		String prefix = startsWith.substring(0, 1);
		String prefix1 = startsWith.substring(2, 3);
		for(String q : QueueBrowser.getAllQueues(qmName)){
			if(q.startsWith(prefix)||q.startsWith(prefix1)){
				queueList.add(q);
			}
		}
		
		return queueList;
	}
	
	public static QueueManager setQueueManagerParams(String qmName){
		QueueManagers qms = QueueBrowser.getQMRoot();
		for(QueueManager qm : qms.getQueueManager()){
			if(qm.getConnectConfig().getQMname().equals(qmName)){
				return qm;
			}
		}
		return null;
	}
	
	public static MQQueueManager getQueueManagerCon(QueueManager params){
		String qManager = params.getConnectConfig().getQMname();		
		MQEnvironment.hostname = params.getConnectConfig().getQMhost();      
		MQEnvironment.channel   = params.getConnectConfig().getQMchannel();		
		MQEnvironment.port = Integer.parseInt(params.getConnectConfig().getQMport());
		MQEnvironment.userID=params.getConnectConfig().getQMusername();
	    MQEnvironment.password=params.getConnectConfig().getQMpassword();
	    
	    MQEnvironment.properties.put(MQC.TRANSPORT_PROPERTY, MQC.TRANSPORT_MQSERIES_CLIENT);
	    
	    MQQueueManager qMgr=null;
	    try {
			qMgr = new MQQueueManager(qManager);}
	    catch(Exception e){
	    	e.printStackTrace();
	    }
	    return qMgr;
	}
	
	
	public static MQQueue getQueueCon(String queueName, MQQueueManager qm){
		MQQueue queue = null;
		try{
			int openOptions = MQC.MQOO_OUTPUT | MQC.MQOO_INQUIRE ;
			queue =
		              qm.accessQueue(queueName,
		                               openOptions,
		                               null,           // default q manager
		                               null,           // no dynamic q name
		                               null);
		}catch(Exception e){
			e.printStackTrace();
		}
		return queue;
	}
	
	public static ArrayList<String> getQmList(){
		ArrayList<String> qmList = new ArrayList<String>();
		QueueManagers qms = QueueBrowser.getQMRoot();
		for(QueueManager qm : qms.getQueueManager()){
			qmList.add(qm.getConnectConfig().getQMname());
		}
		return qmList;
	}
	
	public static MQQueue getQueue(String qmName,String qName){
		
		MQQueue queue = null;
		QueueManager qm = QueueBrowser.setQueueManagerParams(qmName);
		MQQueueManager qmCon = QueueBrowser.getQueueManagerCon(qm);
		queue = QueueBrowser.getQueueCon(qName, qmCon);
		//queue.close();
		//qmCon.disconnect();
		return queue;
	}
	
	
	public static int getQueueType(String qmName,String qName){
		MQQueue queue = QueueBrowser.getQueue(qmName, qName);
		int qType = 0;
		try {
			qType = queue.getQueueType();
		} catch (MQException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return qType;
	}
	public static QueuePropertiesInternal getQueueProperties(MQQueue queue, int qType){
		QueuePropertiesInternal qProperties = new QueuePropertiesInternal();
		qProperties.setQueueType(qType);
		try{
			switch(qType){
			case QueuePropertiesInternal.LOCAL_QUEUE:
				qProperties.setQueueDepth(queue.getCurrentDepth());
				qProperties.setOpenInputCount(queue.getOpenInputCount());
				qProperties.setOpenOutputCount(queue.getOpenOutputCount());
				qProperties.setInhibitGetMessage(queue.getInhibitGet());
				qProperties.setInhibitPutMessage(queue.getInhibitPut());
				qProperties.setMaxDepth(queue.getMaximumDepth());
				break;
			case QueuePropertiesInternal.ALIAS_QUEUE:
				qProperties.setInhibitGetMessage(queue.getInhibitGet());
				qProperties.setInhibitPutMessage(queue.getInhibitPut());
				qProperties.setQueueDepth(-1);
				qProperties.setOpenInputCount(-1);
				qProperties.setOpenOutputCount(-1);
				qProperties.setMaxDepth(-1);
				break;
			case QueuePropertiesInternal.REMOTE_QUEUE:
				qProperties.setInhibitPutMessage(queue.getInhibitPut());
				qProperties.setQueueDepth(-1);
				qProperties.setOpenInputCount(-1);
				qProperties.setOpenOutputCount(-1);
				qProperties.setInhibitGetMessage(-1);
				qProperties.setMaxDepth(-1);
				break;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		if(queue.connectionReference!=null){
			try {
				queue.connectionReference.disconnect();
				//System.out.println("Success");
			} catch (MQException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return qProperties;
	}
	
	public static ArrayList<String> getAllTopics(String qmName) {
		ArrayList<String> topicList = new ArrayList<String>();
		QueueManagers qms = QueueBrowser.getQMRoot();
		for(QueueManager tmp : qms.getQueueManager()){
			if(tmp.getConnectConfig().getQMname().equals(qmName)){
				topicList = (ArrayList<String>)tmp.getTopics().getTopic();
			}
		}
		//channelList = (ArrayList<String>) qms.getQueueManager().get(0).getChannels().getChannel();
		
		return topicList;
	} 
	
}
