package com.cts.dnb.AdminService;

import com.cts.dnb.Application1.BrokerDetailsVO;
import com.cts.dnb.Application1.BrokerXML;

public class ValidateBroker {
	
	public static boolean IsBrokerAlreadyExisting(BrokerDetailsVO brokerdetails){
		boolean existing = false;
		
		for(BrokerDetailsVO broker:BrokerXML.RetrieveDetailedbrokerList()){
			if(CompareBroker(brokerdetails, broker)){
				existing=true;
				break;
			}
			else{
				continue;
			}
		}
		
		return existing;
	}
	
	
	public static boolean CompareBroker(BrokerDetailsVO broker1,BrokerDetailsVO broker2){
		boolean isSame=false;
		if(broker1.getBrokerName().equals(broker2.getBrokerName()) 
				&& broker1.getAlias().equals(broker2.getAlias()) 
				&& broker1.getQueueManagerName().equals(broker2.getQueueManagerName()) 
				&& broker1.getHost().equals(broker2.getHost()) 
				&& broker1.getPort()==broker2.getPort()){
			isSame=true;
		}
		return isSame;
	}
	
	
	public static boolean DoesBrokerEvenExist(String brokerName){
		boolean returnBoolean = false;
		for(String broker : BrokerXML.RetrievebrokerList()){
			if(broker.equals(brokerName)){
				returnBoolean = true;
				break;
			}
		}
		return returnBoolean;
	}
}
