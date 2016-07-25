import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashSet;

import org.example.brokers.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

public class jaxB {

	public static BrokersTYP getjaxbObject() {
		// TODO Auto-generated method stub
		File file = new File("D:\\BrokerStatusXML.xml");
		JAXBContext jaxbContext;
		BrokersTYP brokers =new BrokersTYP();
		try {
			jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Source source = new StreamSource(file);
			JAXBElement<BrokersTYP> root = jaxbUnmarshaller. unmarshal(source, BrokersTYP.class);
			brokers = root.getValue();
			
			//Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			//final Object object = jaxbUnmarshaller.unmarshal(file);
			//BrokersTYP brokers = (BrokersTYP) jaxbUnmarshaller.unmarshal(file);
			//final BrokersTYP brokers = (BrokersTYP)jaxbUnmarshaller.unmarshal(file); 
			
		}catch(JAXBException e){
			e.printStackTrace();
		}
		return brokers;
	}
	
	public static ArrayList<String> getBrokerList(){
		 ArrayList<String> brokerList = new ArrayList<String>();
		 BrokersTYP brokers = jaxB.getjaxbObject();
		 for(BrokerTYP broker: brokers.getBroker()){
				brokerList.add(broker.getBrokerName());
				}
	return brokerList;
	}
	
	 public static ArrayList<String> getExecutionGroupList(String brokerName){
		 ArrayList<String> egList = new ArrayList<String>();
		 BrokersTYP brokers = jaxB.getjaxbObject();
		 for(BrokerTYP broker: brokers.getBroker()){
				if(broker.getBrokerName().equals(brokerName)){
					ExecutionGroupsTYP executionGroups =  broker.getExecutionGroups();
					//ArrayList<String> egList = new ArrayList<String>();
					for(ExecutionGroupTYP executionGroup : executionGroups.getExecutionGroup()){
						egList.add(executionGroup.getExecutionGroupName());
					}
				}
		 }
	return egList;
	}
	 
	public static LinkedHashSet<String> getAliasList(){
		LinkedHashSet<String> aliasList = new LinkedHashSet<String>();
		BrokersTYP brokers = jaxB.getjaxbObject();
		for(BrokerTYP broker : brokers.getBroker()){
			aliasList.add(broker.getEnvironmentAlias());
		}
		return aliasList; 
	}
	
	 public static ArrayList<String> getBrokerList(String alias){
		 ArrayList<String> brokerList = new ArrayList<String>();
		 BrokersTYP brokers = jaxB.getjaxbObject();
		 for(BrokerTYP broker: brokers.getBroker()){
				if(broker.getEnvironmentAlias().equals(alias)){
					brokerList.add(broker.getBrokerName());
				}
		 }
		 return brokerList;
	 }
}

