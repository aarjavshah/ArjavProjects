package com.cts.dnb.Application1;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;



import org.apache.commons.io.FileUtils;

import com.ibm.broker.config.proxy.ApplicationProxy;
import com.ibm.broker.config.proxy.BrokerProxy;
import com.ibm.broker.config.proxy.ConfigManagerProxyPropertyNotInitializedException;
import com.ibm.broker.config.proxy.ExecutionGroupProxy;
import com.ibm.broker.config.proxy.MessageFlowProxy;
//import com.ibm.broker.config.proxy.MessageFlowProxy;

public class XMLUpdaterUtility {

	
	public static void main(String[] args) {
		while(true){
			System.out.println("Starting the update cycle at " + new Date());
		
			StringBuffer xmlContents = new StringBuffer();
			xmlContents.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?><Brokers xmlns=\"http://www.example.org/Brokers\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.example.org/Brokers Brokers.xsd\">");
			
			File xmlFile = new File(FilePaths.getBrokerStatus());
			
			//for loop
			int i=0;
			for(String x: BrokerXML.RetrievebrokerList())
			{	
				//SkipBroker:
				//------------
				System.out.println("Broker"+(++i));
				//------------
				BrokerDetailsVO testObj = new BrokerDetailsVO();
				testObj.setBrokerName(x);
				BrokerProxy bproxy = null;
				try {
					testObj = BrokerXML.RetrievebrokerDetails(testObj);
					bproxy = BrokerConnection.getBrokerProxy(testObj);
					if(bproxy == null){
						continue;
					}
				} catch(Exception e){
					continue;
				}
				//BrokerProxy bproxy = BrokerInfo.getBrokerProxy(testObj);
				
			
					try {
						xmlContents.append("<Broker><BrokerName>"+bproxy.getName()+"</BrokerName><isBrokerRunning>"+bproxy.isRunning()+"</isBrokerRunning>"+"<EnvironmentAlias>"+testObj.getAlias()+"</EnvironmentAlias>");
						Enumeration<ExecutionGroupProxy> eglist = bproxy.getExecutionGroups(null);
						xmlContents.append("<ExecutionGroups>");
						int j = 0;
						while(eglist.hasMoreElements()){
							ExecutionGroupProxy egProxy = eglist.nextElement();
							//------------
							System.out.println("\tEg"+(++j));
							//------------
							xmlContents.append("<ExecutionGroup><ExecutionGroupName>"+egProxy.getName()+"</ExecutionGroupName><isExecutionGroupRunning>"+egProxy.isRunning()+"</isExecutionGroupRunning>");
							Enumeration<ApplicationProxy> applist = egProxy.getApplications(null);
							int k=0;
							xmlContents.append("<Applications>");
							while(applist.hasMoreElements()){
								ApplicationProxy app = applist.nextElement();
								//------------
								System.out.println("\t\tApp"+(++k));
								//------------
								xmlContents.append("<Application><ApplicationName>"+app.getName()+"</ApplicationName><isApplicationRunning>"+app.isRunning()+"</isApplicationRunning>");
								//xmlContents.append("<ApplicationVersion>"+app.getVersion()+"</ApplicationVersion><ApplicationDeployedOn>"+app.getDeployTime()+"</ApplicationDeployedOn>");
								xmlContents.append("<ApplicationDeployedOn>"+app.getDeployTime()+"</ApplicationDeployedOn>");
								Enumeration<MessageFlowProxy> msgFlowList = app.getMessageFlows(null);
								xmlContents.append("<MessageFlows>");
								int l=0;
								while(msgFlowList.hasMoreElements()){
									//------------
									System.out.println("\t\t\tFlow"+(++l));
									//------------
									MessageFlowProxy msgFlow = msgFlowList.nextElement();
									xmlContents.append("<MessageFlow><MessageFlowName>"+msgFlow.getName()+"</MessageFlowName><MessageFlowVersion>"+msgFlow.getVersion()+"</MessageFlowVersion></MessageFlow>");
									
								}
								xmlContents.append("</MessageFlows>");
								xmlContents.append("</Application>");
							}
							xmlContents.append("</Applications></ExecutionGroup>");
						}
						xmlContents.append("</ExecutionGroups></Broker>");
						
					} catch (ConfigManagerProxyPropertyNotInitializedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally{
						bproxy.disconnect();
					}
				}
				xmlContents.append("</Brokers>");
				try {
					FileUtils.writeStringToFile(xmlFile, xmlContents.toString());
					System.out.println("File Updated at "+new Date());
					Thread.sleep(FilePaths.getWAIT_TIME_MIN()*60*1000);
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}

	}

}
