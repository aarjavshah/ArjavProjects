package com.cts.testing;

import com.cts.dnb.Application2.QMMonitor;
import com.cts.dnb.Application2.QueueBrowser;
import com.ibm.mq.MQGetMessageOptions;
import com.ibm.mq.MQMessage;
import com.ibm.mq.MQQueue;
import com.ibm.mq.MQQueueManager;
import com.ibm.mq.constants.MQConstants;

public class TestRun {

	public static void main(String args[]){
		//System.out.println(QMMonitor.getResponse("a^QN^QM1^localhost^1414^SYSTEM.DEF.SVRCONN^454582"));
		
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
}
