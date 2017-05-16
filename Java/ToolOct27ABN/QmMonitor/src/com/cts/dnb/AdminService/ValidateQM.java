package com.cts.dnb.AdminService;

import com.cts.dnb.Application2.QueueBrowser;
import com.cts.dnb.model3.ConnectConfig;
import com.cts.dnb.model3.QueueManager;
import com.ibm.mq.MQC;
import com.ibm.mq.MQEnvironment;
import com.ibm.mq.MQException;
import com.ibm.mq.MQQueueManager;

public class ValidateQM {
	public static boolean CompareQM(ConnectConfig conf1,ConnectConfig config2){
		if(conf1.getQMname().equals(config2.getQMname())&&conf1.getQMhost().equals(config2.getQMhost())&& conf1.getQMport().equals(config2.getQMport())){
			return true;
		}
		else{
			return false;
		}
	}
	public static boolean IsQMExisting(ConnectConfig conf){
		boolean existing = false;
		for(QueueManager qm : QueueBrowser.getQMRoot().getQueueManager()){
			if(CompareQM(qm.getConnectConfig(), conf)){
				existing = true;
				break;
			}else{
				continue;
			}
		}
		return existing;
	}
	public static boolean CheckAvailability(ConnectConfig conf){
		boolean ret = false;
		MQEnvironment.hostname = conf.getQMhost();          
	    MQEnvironment.port  = Integer.parseInt(conf.getQMport());
	    MQEnvironment.channel = conf.getQMchannel();
	    //MQEnvironment.password="satya@1986";
	    MQEnvironment.userID=conf.getQMusername();
	    String qmName = conf.getQMname();
	    //end of connection details
	    MQEnvironment.properties.put(MQC.TRANSPORT_PROPERTY, MQC.TRANSPORT_MQSERIES_CLIENT);
	    MQQueueManager qMgr=null;
	    try{
	    	qMgr = new MQQueueManager(qmName);
	    	if(qMgr!=null){
	    		ret=true;
	    		try {
	    			qMgr.disconnect();
	    		} catch (MQException e) {
	    			// TODO Auto-generated catch block
	    			e.printStackTrace();
	    		}
	    	}
	    }catch(Exception e){
	    	
	    }
	    
		return ret;
	}
}
