import java.io.IOException;

import com.ibm.mq.MQC;
import com.ibm.mq.MQEnvironment;
import com.ibm.mq.MQException;
import com.ibm.mq.MQMessage;
import com.ibm.mq.MQPutMessageOptions;
import com.ibm.mq.MQQueue;
import com.ibm.mq.MQQueueManager;
import com.ibm.mq.constants.MQConstants;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MQEnvironment.hostname = "192.168.1.19";
		MQEnvironment.port = 1414;
		MQEnvironment.channel = "SYSTEM.DEF.SVRCONN";
		MQQueueManager qmgr = null;
		MQQueue queue = null;
		try {
			qmgr = new MQQueueManager("QM1");
			int openOptions = MQConstants.MQOO_OUTPUT;
			queue = qmgr.accessQueue("QIN", openOptions, null, null, null);
			MQMessage message = new MQMessage();
			MQPutMessageOptions putOpt = new MQPutMessageOptions();
			message.writeString("Raval chodiyo");
			queue.put(message, putOpt);
			System.out.println("MESSAGE SENT!");
		} catch (MQException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
