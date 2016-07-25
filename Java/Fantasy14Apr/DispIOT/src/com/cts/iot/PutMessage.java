package com.cts.iot;
import java.io.IOException;

import com.ibm.mq.MQEnvironment;
import com.ibm.mq.MQException;
import com.ibm.mq.MQMessage;
import com.ibm.mq.MQPutMessageOptions;
import com.ibm.mq.MQQueue;
import com.ibm.mq.MQQueueManager;
import com.ibm.mq.constants.MQConstants;


public class PutMessage {
	public static void PutMessageToQueue(QMConnectionParmsVO vo,String msg){
		MQEnvironment.hostname = vo.getHostname();
		MQEnvironment.port = vo.getPort();
		MQEnvironment.channel = vo.getChannel();
		MQQueueManager qmgr = null;
		MQQueue queue = null;
		try {
			qmgr = new MQQueueManager(vo.getQueueManager());
			int openOptions = MQConstants.MQOO_OUTPUT;
			queue = qmgr.accessQueue(vo.getQueue(), openOptions, null, null, null);
			MQMessage message = new MQMessage();
			MQPutMessageOptions putOpt = new MQPutMessageOptions();
			message.writeString(msg);
			queue.put(message, putOpt);
			System.out.println("MESSAGE SENT!");
		} catch (MQException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			try {
				queue.close();
				qmgr.close();
			} catch (MQException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
