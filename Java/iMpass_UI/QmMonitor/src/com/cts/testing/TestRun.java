package com.cts.testing;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.cts.dnb.Application1.UserAuth;
import com.cts.dnb.Application2.QMMonitor;
import com.cts.dnb.Application2.QueueBrowser;
import com.cts.dnb.model4.UserTYP;
import com.cts.impas.notification.EmailTemplateBO;
import com.cts.impas.notification.GenerateTemplate;
import com.cts.impas.notification.SendNotification;
import com.ibm.mq.MQC;
import com.ibm.mq.MQEnvironment;
import com.ibm.mq.MQGetMessageOptions;
import com.ibm.mq.MQMessage;
import com.ibm.mq.MQPutMessageOptions;
import com.ibm.mq.MQQueue;
import com.ibm.mq.MQQueueManager;
import com.ibm.mq.constants.MQConstants;

public class TestRun {

	public static void main(String args[]) throws AddressException, UnsupportedEncodingException, MessagingException{
		//System.out.println(QMMonitor.getResponse("a^QN^QM1^localhost^1414^SYSTEM.DEF.SVRCONN^454582"));
//		try {
//			System.out.println(GetMessage("QM1", "QIN",2));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println(samp());
//		System.out.println("ALL DONE");
		EmailTemplateBO bo =new EmailTemplateBO();
		UserTYP usr = UserAuth.GetUserTYP("admin");
		bo.setToEmail(usr.getEmail());
		bo.setMsgBody(GenerateTemplate.GetMsgBody(1, "QMC20161011194407", usr));
		bo.setSubject("iMPAS update : QMC20161011194407");
		SendNotification.SendEmail(bo);
	}
	public static int samp() {
		try{
			System.out.println("1");
			return 0;
			//System.out.println("2");
		}catch(Exception e){
			return  1;
		}finally{
			System.out.println("3");
			return 2;
		}
		
	}
	
	public static ArrayList<String> BrowseMessage(String qmName,String qName) throws Exception{
		ArrayList<String> msgs = new ArrayList<String>();
		String msg = "";
		MQQueueManager qmgr = QueueBrowser.getQueueManagerCon(QueueBrowser.setQueueManagerParams(qmName));
		MQQueue queue = null;			
		int openOptions = MQConstants.MQOO_FAIL_IF_QUIESCING | MQConstants.MQOO_INPUT_SHARED | MQConstants.MQOO_BROWSE |MQConstants.MQOO_INQUIRE;
		queue =qmgr.accessQueue(qName,
		                        openOptions,
		                        null,           // default q manager
		                        null,           // no dynamic q name
		                        null);
		if(queue.getCurrentDepth()>0){
		MQMessage theOutMessage    = new MQMessage();
		MQGetMessageOptions gmo = new MQGetMessageOptions();
		int cnt =1;
		while(cnt<=queue.getCurrentDepth()){
		if(cnt==1){
			gmo.options=MQConstants.MQGMO_WAIT | MQConstants.MQGMO_BROWSE_FIRST;
		}else{
	    	gmo.options=MQConstants.MQGMO_WAIT | MQConstants.MQGMO_BROWSE_NEXT;
	    }cnt++;
	    gmo.matchOptions=MQConstants.MQMO_NONE;
	      queue.get(theOutMessage,gmo);
	      int strLen = theOutMessage.getMessageLength();
	      
	      byte[] strData = new byte[strLen];
	      theOutMessage.readFully(strData,0,strLen);
	      msg = new String(strData);
	   // System.out.println(msg); 
	      msgs.add(msg.trim());
		}
	    queue.close();
	    qmgr.disconnect();
		
		return msgs;}else{
			return null;
		}
	}
	
	
	
	public static ArrayList<String> GetMessage(String qmName,String qName,int count) throws Exception{
		ArrayList<String> msgs = new ArrayList<String>();
		String msg = "";
		MQQueueManager qmgr = QueueBrowser.getQueueManagerCon(QueueBrowser.setQueueManagerParams(qmName));
		MQQueue queue = null;			
		int openOptions = MQConstants.MQOO_FAIL_IF_QUIESCING | MQConstants.MQOO_INPUT_SHARED | MQConstants.MQOO_INQUIRE;
		queue =qmgr.accessQueue(qName,
		                        openOptions,
		                        null,           // default q manager
		                        null,           // no dynamic q name
		                        null);
		if(queue.getCurrentDepth()>0){
			MQMessage theOutMessage    = new MQMessage();
			MQGetMessageOptions gmo = new MQGetMessageOptions();
			int cnt =queue.getCurrentDepth();
			if(count==-1){
				count = queue.getCurrentDepth();
			}
			while(queue.getCurrentDepth()>cnt-count){
				gmo.options = MQConstants.MQGMO_NO_WAIT | MQConstants.MQGMO_ALL_MSGS_AVAILABLE;
				gmo.matchOptions=MQConstants.MQMO_NONE;
				queue.get(theOutMessage,gmo);
				int strLen = theOutMessage.getMessageLength();
				byte[] strData = new byte[strLen];
				theOutMessage.readFully(strData,0,strLen);
				msg = new String(strData);
		   // System.out.println(msg); 
				msgs.add(msg.trim());
			}
		    queue.close();
		    qmgr.disconnect();
			
			return msgs;
		}else{
			return null;
		}
	}
}