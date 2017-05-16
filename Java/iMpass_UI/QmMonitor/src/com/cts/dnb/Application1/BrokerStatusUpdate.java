package com.cts.dnb.Application1;


import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.apache.commons.io.FileUtils;

import com.cts.dnb.AdminService.ManageRequests;
import com.cts.dnb.model4.UserTYP;
import com.cts.dnb.model5.RequestTYP;
import com.cts.impas.notification.EmailTemplateBO;
import com.cts.impas.notification.GenerateTemplate;
import com.cts.impas.notification.SendNotification;
import com.ibm.broker.config.proxy.ApplicationProxy;
import com.ibm.broker.config.proxy.BrokerProxy;
import com.ibm.broker.config.proxy.ExecutionGroupProxy;
import com.ibm.broker.config.proxy.MessageFlowProxy;

public class BrokerStatusUpdate {
	public static void startBrokerStatusUpadate(String reqID,String username){
		
		RequestTYP req = new RequestTYP();
		req.setRequestID(reqID);
		req.setRequestType("BKR");
		req.setRequestStatus("Initiated");
		ManageRequests.EnrollRequest(req);
		
		System.out.println("Starting the update cycle at " + new Date());

		StringBuffer xmlContents = new StringBuffer();
		xmlContents.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?><Brokers xmlns=\"http://www.example.org/Brokers\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.example.org/Brokers Brokers.xsd\">");

		File xmlFile = new File(FilePaths.getBrokerStatus());
		String [] list;
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
				xmlContents.append("<Broker><BrokerName>");
				try{
					xmlContents.append(bproxy.getName());
				}catch(Exception e){

				}finally{
					xmlContents.append("</BrokerName><isBrokerRunning>");
				}
				try{
					xmlContents.append(bproxy.isRunning());
				}catch(Exception e){

				}finally{
					xmlContents.append("</isBrokerRunning>"+"<EnvironmentAlias>");
				}
				try{
					xmlContents.append(testObj.getAlias());
				}catch(Exception e){

				}finally{
					xmlContents.append("</EnvironmentAlias>");
				}

				try{
					Enumeration<ExecutionGroupProxy> eglist = bproxy.getExecutionGroups(null);

					xmlContents.append("<ExecutionGroups>");

					try{
						int j = 0;
						while(eglist.hasMoreElements()){
							ExecutionGroupProxy egProxy = eglist.nextElement();
							//------------
							System.out.println("\tEg"+(++j));
							//------------
							xmlContents.append("<ExecutionGroup><ExecutionGroupName>");

							try{
								xmlContents.append(egProxy.getName());
							}catch(Exception e){
							}finally{
								xmlContents.append("</ExecutionGroupName><isExecutionGroupRunning>");
							}

							try{
								xmlContents.append(egProxy.isRunning());
							}catch(Exception e){

							}finally{
								xmlContents.append("</isExecutionGroupRunning>");
							}

							try{
								Enumeration<ApplicationProxy> applist = egProxy.getApplications(null);
								int k=0;									
								xmlContents.append("<Applications>");
								try{
									while(applist.hasMoreElements()){
										ApplicationProxy app = applist.nextElement();
										//------------
										System.out.println("\t\tApp"+(++k));
										//------------

										xmlContents.append("<Application><ApplicationName>");
										try{
											xmlContents.append(app.getName());
										}catch(Exception e){

										}finally{
											xmlContents.append("</ApplicationName><isApplicationRunning>");}
										try{
											xmlContents.append(app.isRunning());}catch(Exception e){}
										finally{
											xmlContents.append("</isApplicationRunning>");
											xmlContents.append("<ApplicationDeployedOn>");}
										try{
											xmlContents.append(app.getDeployTime());}
										catch(Exception e){

										}finally{
											xmlContents.append("</ApplicationDeployedOn>");}
										try{
											Enumeration<MessageFlowProxy> msgFlowList = app.getMessageFlows(null);

											xmlContents.append("<MessageFlows>");
											try{
												int l=0;
												while(msgFlowList.hasMoreElements()){
													//------------
													System.out.println("\t\t\tFlow"+(++l));
													//------------
													MessageFlowProxy msgFlow = msgFlowList.nextElement();

													xmlContents.append("<MessageFlow><MessageFlowName>");
													try{
														xmlContents.append(msgFlow.getName());}
													catch(Exception e){

													}finally{
														xmlContents.append("</MessageFlowName><MessageFlowVersion>");}
													try{
														xmlContents.append(msgFlow.getVersion());}
													catch(Exception e){

													}finally{
														xmlContents.append("</MessageFlowVersion><isMessageFlowRunning>");}
													try{
														xmlContents.append(msgFlow.isRunning());}
													catch(Exception e){

													}finally{
														xmlContents.append("</isMessageFlowRunning><MessageFlowInstances>");}
													try{
														xmlContents.append(msgFlow.getAdditionalInstances()+1);}
													catch(Exception e){

													}finally{
														xmlContents.append("</MessageFlowInstances><Queues>");}
													try{
														list = msgFlow.getQueues();
														for(String q:list){
															xmlContents.append("<Queue>"+q+"</Queue>");
														}
													}catch(Exception e){
														
													}finally{
														xmlContents.append("</Queues></MessageFlow>");
													}
												}
												
											}catch(Exception e){

											}finally{
												xmlContents.append("</MessageFlows>");}
										}catch(Exception e){

										}finally{
											xmlContents.append("</Application>");
										}
									}
								}
								catch(Exception e){

								}finally{
									xmlContents.append("</Applications>");

								}

							}catch(Exception e){
							}finally{
								xmlContents.append("</ExecutionGroup>");
							}
						}
					}catch (Exception e) {
						// TODO: handle exception
					}finally{
						xmlContents.append("</ExecutionGroups>");}
				}catch(Exception e){
					xmlContents.append("<ExecutionGroups></ExecutionGroups>");
				}
				finally{
					xmlContents.append("</Broker>");
				}
			}catch (Exception e) {

			}finally{
				bproxy.disconnect();
			}
		}
		xmlContents.append("</Brokers>");
		try {
			FileUtils.writeStringToFile(xmlFile, xmlContents.toString());
			System.out.println("File Updated at "+new Date());
			req.setRequestStatus("Success");
			ManageRequests.UpdateRequest(req);
			UserTYP usr = UserAuth.GetUserTYP(username);
			EmailTemplateBO bo = new EmailTemplateBO();
			bo.setToEmail(usr.getEmail());
			bo.setMsgBody(GenerateTemplate.GetMsgBody(2, reqID, usr));
			bo.setSubject("iMPAS update : "+reqID);
			SendNotification.SendEmail(bo);
			} catch (IOException | MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
