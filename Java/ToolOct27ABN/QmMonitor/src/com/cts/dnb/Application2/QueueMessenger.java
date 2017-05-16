package com.cts.dnb.Application2;

import java.io.IOException;
import java.util.ArrayList;

import com.ibm.mq.MQC;
import com.ibm.mq.MQException;
import com.ibm.mq.MQGetMessageOptions;
import com.ibm.mq.MQMessage;
import com.ibm.mq.MQPutMessageOptions;
import com.ibm.mq.MQQueue;
import com.ibm.mq.MQQueueManager;
import com.ibm.mq.constants.MQConstants;

public class QueueMessenger {
	public static boolean PutMessage(String qmName,String qName, String msg,String replyTo) throws Exception{
		boolean ret = false;
		MQQueueManager qmgr = QueueBrowser.getQueueManagerCon(QueueBrowser.setQueueManagerParams(qmName));
		MQQueue queue = null;			
		int openOptions = MQC.MQOO_OUTPUT ;
		queue =qmgr.accessQueue(qName,
		                        openOptions,
		                        null,           // default q manager
		                        null,           // no dynamic q name
		                        null);
		MQMessage inputTriggerMsg = new MQMessage();
		inputTriggerMsg.writeString(msg);
		inputTriggerMsg.replyToQueueName = replyTo;
	    MQPutMessageOptions pmo = new MQPutMessageOptions();
	    queue.put(inputTriggerMsg,pmo);
	    ret=true;
	    queue.close();
	    qmgr.disconnect();
	    return ret;
	}
	public static int PutMessages(String qmName,String qName, ArrayList<String> msgs,String replyTo) throws Exception{
		boolean and = true;
		boolean or = false;
		MQQueueManager qmgr = QueueBrowser.getQueueManagerCon(QueueBrowser.setQueueManagerParams(qmName));
		MQQueue queue = null;			
		int openOptions = MQC.MQOO_OUTPUT ;
		
			queue =qmgr.accessQueue(qName,
			                        openOptions,
			                        null,           // default q manager
			                        null,           // no dynamic q name
			                        null);
		
		
		for(String msg:msgs){
			MQMessage inputTriggerMsg = new MQMessage();
			inputTriggerMsg.writeString(msg);
			inputTriggerMsg.replyToQueueName = replyTo;
			MQPutMessageOptions pmo = new MQPutMessageOptions();
			queue.put(inputTriggerMsg,pmo);
			//ret=true;
		}
		
	   
			queue.close();
			qmgr.disconnect();
		
	    
	    //return ret;
	    return 0;
	}
	public static String BrowseMessage(String qmName,String qName) throws Exception{
		String msg = "";
		MQQueueManager qmgr = QueueBrowser.getQueueManagerCon(QueueBrowser.setQueueManagerParams(qmName));
		MQQueue queue = null;			
		int openOptions = MQConstants.MQOO_FAIL_IF_QUIESCING | MQConstants.MQOO_INPUT_SHARED | MQConstants.MQOO_BROWSE |MQConstants.MQOO_INQUIRE;
		queue =qmgr.accessQueue(qName,
		                        openOptions,
		                        null,           // default q manager
		                        null,           // no dynamic q name
		                        null);
		MQMessage theOutMessage    = new MQMessage();
		MQGetMessageOptions gmo = new MQGetMessageOptions();
		int count =1;
		//while(count<=queue.getCurrentDepth()){
		//if(count==1){
			gmo.options=MQConstants.MQGMO_WAIT | MQConstants.MQGMO_BROWSE_FIRST;
		//}else{
	   // 	gmo.options=MQC.MQGMO_WAIT | MQC.MQGMO_BROWSE_NEXT;
	   // }count++;
	    gmo.matchOptions=MQConstants.MQMO_NONE;
	      queue.get(theOutMessage,gmo);
	      int strLen = theOutMessage.getMessageLength();
	      
	      byte[] strData = new byte[strLen];
	      theOutMessage.readFully(strData,0,strLen);
	      msg = new String(strData);
	   // System.out.println(msg);  
		//}
	    queue.close();
	    qmgr.disconnect();
		return (msg.trim());
	}
	
	public static GetMessageVO SeparateHeader(String msg){
		GetMessageVO ret = new GetMessageVO();
		if(msg.startsWith("RFH")){
			ret.setHeader(msg.substring(0, msg.indexOf("</jms>")+6).trim());
			ret.setData(msg.substring(msg.indexOf("</jms>")+6).trim());
		}else{
			ret.setData(msg);
			ret.setHeader("");
		}
		return ret;
	}
	public static int GetQueueDepth(String qmName,String qName) {
		MQQueueManager qmgr = QueueBrowser.getQueueManagerCon(QueueBrowser.setQueueManagerParams(qmName));
		MQQueue queue = null;			
		int openOptions = MQConstants.MQOO_FAIL_IF_QUIESCING | MQConstants.MQOO_INPUT_SHARED | MQConstants.MQOO_BROWSE |MQConstants.MQOO_INQUIRE;
		try {
			queue =qmgr.accessQueue(qName,
			                        openOptions,
			                        null,           // default q manager
			                        null,           // no dynamic q name
			                        null);
			return queue.getCurrentDepth();
		} catch (MQException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
	}
}
