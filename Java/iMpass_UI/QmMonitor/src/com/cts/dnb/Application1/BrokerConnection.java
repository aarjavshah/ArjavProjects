package com.cts.dnb.Application1;

import java.util.ArrayList;
import java.util.Enumeration;




import com.ibm.broker.config.proxy.*;

public class BrokerConnection {

	public static BrokerProxy getBrokerProxy(BrokerDetailsVO broker) {
		BrokerConnectionParameters bcp =
            new MQBrokerConnectionParameters(broker.getHost(),broker.getPort(),broker.getQueueManagerName());
	BrokerProxy bProxy = null;
        try {
        	//bProxy = BrokerProxy.getInstance(bcp);
        	bProxy = BrokerProxy.getLocalInstance(broker.getBrokerName());
		} catch (ConfigManagerProxyLoggedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			return bProxy;
	}
}
