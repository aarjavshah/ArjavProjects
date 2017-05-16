import java.util.ArrayList;
import java.util.Date;

import com.ibm.broker.javacompute.MbJavaComputeNode;
import com.ibm.broker.plugin.MbElement;
import com.ibm.broker.plugin.MbException;
import com.ibm.broker.plugin.MbMessage;
import com.ibm.broker.plugin.MbMessageAssembly;
import com.ibm.broker.plugin.MbOutputTerminal;
import com.ibm.broker.plugin.MbUserException;
import com.ibm.broker.plugin.MbXMLNSC;
import com.ibm.mq.MQC;
import com.ibm.mq.MQEnvironment;
import com.ibm.mq.MQException;
import com.ibm.mq.MQQueue;
import com.ibm.mq.MQQueueManager;
import com.ibm.mq.constants.MQConstants;
import com.ibm.mq.pcf.PCFMessage;
import com.ibm.mq.pcf.PCFMessageAgent;


public class QMMonitor_HTTP_MF_JavaCompute extends MbJavaComputeNode {

	public void evaluate(MbMessageAssembly inAssembly) throws MbException {
		MbOutputTerminal out = getOutputTerminal("out");
		MbOutputTerminal alt = getOutputTerminal("alternate");

		MbMessage inMessage = inAssembly.getMessage();
		
		MbMessageAssembly outAssembly = null;
		MbMessage outMessage = new MbMessage(inMessage);
		MQQueueManager qMgr=null;
	     //MQQueue queue=null;
	     PCFMessageAgent agent =null;
		//String chName ="BLINKAGE.SVRCONN";
		try {
			// create new message as a copy of the input
			
			outAssembly = new MbMessageAssembly(inAssembly, outMessage);
			// ----------------------------------------------------------
			// Add user code below

			byte [] inBytes = (byte[])inMessage.getRootElement().getLastChild().getLastChild().getValue();
			String inputParams = new String(inBytes);
			String paramVals[] = inputParams.split("\\^");
			String reqType = paramVals[1];
			String qManager = paramVals[2];
			String hostname = paramVals[3];
			int port = Integer.parseInt(paramVals[4]);
			String channel  = paramVals[5];
			String userName = paramVals[6];
			String qName = null;
			String tpName = null;
			boolean flag = false;
			if(reqType.equals("Q")){
				qName = paramVals[7];
			}
			else if(reqType.equals("T")){
				tpName = paramVals[7];
			}
			
			
			 
			
			
		     MQEnvironment.hostname = hostname;           // Could have put the
	         // hostname & channel
		     MQEnvironment.port  = port;            // string directly here!
		     MQEnvironment.channel = channel;
		     //MQEnvironment.password="satya@1986";
		     MQEnvironment.userID = userName;
		     //MQEnvironment.properties.put(MQC.TRANSPORT_PROPERTY,MQC.TRANSPORT_MQSERIES);
		     MQEnvironment.properties.put(MQC.TRANSPORT_PROPERTY, MQC.TRANSPORT_MQSERIES_CLIENT);
		     //MQEnvironment.properties.put(MQC.TRANSPORT_PROPERTY, MQC.TRANSPORT_MQSERIES_BINDINGS);
		    
		     
		     
		     PCFMessage mes=null;
		     PCFMessage res[]=null;
		     PCFMessage res1[]=null;
		     PCFMessage res2[]=null;
		     PCFMessage inquireQueueStatus = null;
		     PCFMessage inquireQueueStatus1 = null;
		     PCFMessage inquireQueueStatus2= null;
		     PCFMessage inquireQueueNames= null;
		     PCFMessage res3[]=null;
		     PCFMessage inquireChNames= null;
		     PCFMessage res4[]=null;
		     PCFMessage inquireTpNames= null;
		     PCFMessage res5[]= null;
		     PCFMessage inquireTpStatus= null;
		     PCFMessage inquireTpStatus1= null;
		     PCFMessage inquireTpStatus2= null;
		     PCFMessage res6[]= null;
		     PCFMessage res7[]= null;
		     PCFMessage res8[]= null;
		     qMgr = new MQQueueManager(qManager);
				//agent = new PCFMessageAgent(hostname, port, channel);
				//PCFAgent a =new PCFAgent(hostname, port, channel);
				//System.out.println(a.getJmqiEnv());
		    	 agent = new PCFMessageAgent (qMgr);
		    	 
		    	 
		    	 
		    	 
		    	 
		    	 
		    	 if(reqType.equals("Q")){
				    		 inquireQueueStatus = new PCFMessage(MQConstants.MQCMD_INQUIRE_Q);
				    		 //inquireQueueStatus = new PCFMessage(MQConstants.MQCMD_INQUIRE_Q_STATUS);
				    		 inquireQueueStatus.addParameter(MQConstants.MQCA_Q_NAME, qName);
				    		 //inquireQueueStatus.addParameter(MQConstants.MQIACF_Q_STATUS_TYPE, MQConstants.MQIACF_Q_STATUS);
				    		 
				    		 int[] attrs = new int[] {
				    				 MQConstants.MQCA_Q_NAME, MQConstants.MQIA_CURRENT_Q_DEPTH,
				    				 MQConstants.MQIA_OPEN_INPUT_COUNT,MQConstants.MQIA_OPEN_OUTPUT_COUNT,
				    				 MQConstants.MQIA_INHIBIT_GET,MQConstants.MQIA_INHIBIT_PUT,
				    				 MQConstants.MQIA_MAX_Q_DEPTH,MQConstants.MQCA_BASE_Q_NAME,
				    				 MQConstants.MQCA_REMOTE_Q_MGR_NAME,MQConstants.MQCA_REMOTE_Q_NAME
				    				 };
		//		    		 int[] attrs = new int[] {
		//		    				 MQConstants.MQCA_Q_NAME, MQConstants.MQIA_CURRENT_Q_DEPTH,
		//		    				 MQConstants.MQCACF_LAST_GET_DATE, MQConstants.MQCACF_LAST_GET_TIME,
		//		    				 MQConstants.MQCACF_LAST_PUT_DATE, MQConstants.MQCACF_LAST_PUT_TIME,
		//		    				 MQConstants.MQIA_OPEN_INPUT_COUNT,MQConstants.MQIA_OPEN_OUTPUT_COUNT};
				    		 
				    		 
				    		 inquireQueueStatus.addParameter(MQConstants.MQIACF_Q_ATTRS, attrs);
				    		 //inquireQueueStatus.addParameter(MQConstants.MQIACF_Q_STATUS_ATTRS, attrs);
				    		 
				    		 res = agent.send(inquireQueueStatus);
				    		 
				    		 if ( (res.length <= 2)  && (res[0].getCompCode() != MQException.MQCC_OK) ){
					        	 System.out.println("Error in response");
					         }
				    		 
				    		 StringBuffer QDetailsContents = new StringBuffer();
				    		 int qtype = 1;
				    		 int maxDepth = 0;
				    		 for(PCFMessage tmp : res){
				    			 qtype= tmp.getIntParameterValue(MQConstants.MQIA_Q_TYPE);
				    			 String isputAllowed = "NA";
				    			 String isgetAllowed = "NA";
				    			 String targetQ = "NA";
				    			 String qType = "";
				    			 String remoteQM = "NA";
				    			 String remoteQName = "NA";
				    			 //queue type classification
				    			 if(qtype==1){
				    				  qType = "LOCAL";
				    				  maxDepth = tmp.getIntParameterValue(MQConstants.MQIA_MAX_Q_DEPTH);
				    			 }else if(qtype == 3){
				    				  qType = "ALIAS";
				    				  targetQ = tmp.getStringParameterValue(MQConstants.MQCA_BASE_Q_NAME);
				    			 }else if(qtype == 6){
				    				  qType = "REMOTE";
				    				  remoteQM = (String)tmp.getParameterValue(MQConstants.MQCA_REMOTE_Q_MGR_NAME);
				    				  remoteQName = (String)tmp.getParameterValue(MQConstants.MQCA_REMOTE_Q_NAME);
				    			 }
				    			 
				    			 //put and get enabled?
				    			 if(tmp.getIntParameterValue(MQConstants.MQIA_INHIBIT_PUT) == MQConstants.MQQA_GET_ALLOWED){
				    				 isputAllowed = "Allowed";
				    			 }else{
				    				 isputAllowed = "Not Allowed";
				    			 }
				    			 if(qtype!=6){
				    				 if(tmp.getIntParameterValue(MQConstants.MQIA_INHIBIT_GET)==MQConstants.MQQA_GET_ALLOWED){
				    					 isgetAllowed = "Allowed";}
				    				 else{
				    					 isgetAllowed = "NotAllowed";
				    				 	}
				    			 }else{
				    				isgetAllowed = "NA"; 
				    			 }
				    			 
				    		 QDetailsContents.append(qName+"^"+
				    				 qType+"^"+isputAllowed+"^"+isgetAllowed+"^"+maxDepth+"^"+targetQ.trim()+"^"+remoteQM.trim()+"^"+remoteQName.trim()
				    				 //tmp.getParameterValue(MQConstants.MQCA_CREATION_DATE)+"^"+
		//		    				 (String)tmp.getParameterValue(MQConstants.MQCACF_LAST_GET_DATE)+"^"+(String)tmp.getParameterValue(MQConstants.MQCACF_LAST_GET_TIME)+"^"+
		//		    				 (String)tmp.getParameterValue(MQConstants.MQCACF_LAST_PUT_DATE)+"^"+(String)tmp.getParameterValue(MQConstants.MQCACF_LAST_PUT_TIME)
									);
				    		 }
				    		 
				    		 
				    		 if(qtype == 1){
				    		 inquireQueueStatus1 = new PCFMessage(MQConstants.MQCMD_INQUIRE_Q_STATUS);
				    		 inquireQueueStatus1.addParameter(MQConstants.MQCA_Q_NAME, qName);
				    		 inquireQueueStatus1.addParameter(MQConstants.MQIACF_Q_STATUS_TYPE, MQConstants.MQIACF_Q_STATUS);
			    		
				    		 int[] attrs1 = new int[] {
				    				 MQConstants.MQCA_Q_NAME, MQConstants.MQIA_CURRENT_Q_DEPTH,
				    				 MQConstants.MQCACF_LAST_GET_DATE, MQConstants.MQCACF_LAST_GET_TIME,
				    				 MQConstants.MQCACF_LAST_PUT_DATE, MQConstants.MQCACF_LAST_PUT_TIME,
				    				 MQConstants.MQIA_OPEN_INPUT_COUNT,MQConstants.MQIA_OPEN_OUTPUT_COUNT
				    				 };
				    		 
				    		 
				    		 //inquireQueueStatus.addParameter(MQConstants.MQIACF_Q_ATTRS, attrs);
				    		 inquireQueueStatus1.addParameter(MQConstants.MQIACF_Q_STATUS_ATTRS, attrs1);
				    		 res1 = agent.send(inquireQueueStatus1);
				    		 
				    		 if ( (res1.length <= 2)  && (res1[0].getCompCode() != MQException.MQCC_OK) ){
					        	 System.out.println("Error in response");
					         }
				    		for(PCFMessage tmp : res1){
				    			String lastGetDate = tmp.getStringParameterValue(MQConstants.MQCACF_LAST_GET_DATE);
				    			String lastGetTime = tmp.getStringParameterValue(MQConstants.MQCACF_LAST_GET_TIME);
				    			String lastPutDate = tmp.getStringParameterValue(MQConstants.MQCACF_LAST_PUT_DATE);
				    			String lastPutTime = tmp.getStringParameterValue(MQConstants.MQCACF_LAST_PUT_TIME);
				    			int openIP = tmp.getIntParameterValue(MQConstants.MQIA_OPEN_INPUT_COUNT);
				    			int openOP = tmp.getIntParameterValue(MQConstants.MQIA_OPEN_OUTPUT_COUNT);
				    			int curDepth = tmp.getIntParameterValue(MQConstants.MQIA_CURRENT_Q_DEPTH);
				    			if(openIP>0 ||openOP>0){
				    				flag = true;
				    			}
				    			
				    			QDetailsContents.append("^"+curDepth+"^"+openIP+"^"+openOP+"^"+lastGetDate+"^"+lastGetTime+"^"+lastPutDate+"^"+lastPutTime+"^");
				    		}
			
				    		if(flag){
				    			inquireQueueStatus2 = new PCFMessage(MQConstants.MQCMD_INQUIRE_Q_STATUS);
				    			inquireQueueStatus2.addParameter(MQConstants.MQCA_Q_NAME, qName);
					    		 inquireQueueStatus2.addParameter(MQConstants.MQIACF_Q_STATUS_TYPE, MQConstants.MQIACF_Q_HANDLE);
				    		
					    		 int[] attrs2 = new int[] {
					    				 MQConstants.MQCA_Q_NAME,MQConstants.MQCACH_CONNECTION_NAME,
					    				 MQConstants.MQCACH_CHANNEL_NAME,MQConstants.MQIACF_OPEN_BROWSE,
					    				 MQConstants.MQIACF_OPEN_INPUT_TYPE,MQConstants.MQIACF_OPEN_OUTPUT};
					    		 
					    		 inquireQueueStatus2.addParameter(MQConstants.MQIACF_Q_STATUS_ATTRS, attrs2);
					    		 res2 = agent.send(inquireQueueStatus2);
					    		 if ( (res2.length <= 2)  && (res2[0].getCompCode() != MQException.MQCC_OK) ){
						        	 System.out.println("Error in response");
						         }
					    		 int  i = 0;
					    		 //QDetailsContents.append("^");
					    		for(PCFMessage tmp : res2){
					    			String conName = tmp.getStringParameterValue(MQConstants.MQCACH_CONNECTION_NAME);
					    			String chName = tmp.getStringParameterValue(MQConstants.MQCACH_CHANNEL_NAME);
					    			if(conName.trim().isEmpty()){
					    				conName = "localhost";
					    			}
					    			if(chName.trim().isEmpty()){
					    				chName = "NA";
					    			}
					    			String type = "";
					    			int inputType = tmp.getIntParameterValue(MQConstants.MQIACF_OPEN_INPUT_TYPE);
					    			if(inputType == MQConstants.MQQSO_SHARED||inputType == MQConstants.MQQSO_EXCLUSIVE){
					    				type ="I";
					    			}
					    			int outputType = tmp.getIntParameterValue(MQConstants.MQIACF_OPEN_OUTPUT);
					    			if(outputType == MQConstants.MQQSO_YES){
					    				type ="O";
					    			}
					    			int brType = tmp.getIntParameterValue(MQConstants.MQIACF_OPEN_BROWSE);
					    			if(brType == MQConstants.MQQSO_YES){
					    				type="B";
					    			}
					    			QDetailsContents.append(conName.trim()+"#"+chName.trim()+"#"+type+"|@");
					    		}
				    		}
				    		 }
				    		 
				    		 
				    		 
				    		 
				    		 outMessage.getRootElement().getLastChild().getLastChild().setValue(QDetailsContents.toString().getBytes());
				    	 
				    	 }
		    		 
		    		 
		    	 else if(reqType.equals("C")){
				    	 mes=new PCFMessage(MQConstants.MQCMD_INQUIRE_CHANNEL_STATUS);
						 mes.addParameter(MQConstants.MQCACH_CHANNEL_NAME, "*");
						 int[] attrs = new int []
		                         {
		                         //MQConstants.MQCACH_CHANNEL_NAME,
		                         //MQConstants.MQCACH_CONNECTION_NAME
		//						 ,
								 MQConstants.MQIACH_CHANNEL_STATUS
		                         ,MQConstants.MQIACH_CHANNEL_SUBSTATE
		                         ,MQConstants.MQCACH_LAST_MSG_DATE
		                         ,MQConstants.MQCACH_LAST_MSG_TIME
		                      } ;
							 //{MQConstants.MQCACH_DESC,MQConstants.MQCACH_MCA_USER_ID}; 
		
						// mes.addParameter(MQConstants.MQIACH_CHANNEL_TYPE, MQConstants.MQOT_CURRENT_CHANNEL); 
						 //mes.addParameter(MQConstants.MQIACH_CHANNEL_INSTANCE_TYPE, MQConstants.MQOT_CURRENT_CHANNEL); 
						 mes.addParameter(MQConstants.MQIACH_CHANNEL_INSTANCE_ATTRS, attrs); 
						 
						 /*
						 mes.addParameter(CMQCFC.MQIACH_CHANNEL_TYPE, CMQXC.MQCHT_ALL);
				         mes.addParameter(CMQCFC.MQIACH_CHANNEL_INSTANCE_ATTRS,
				                              new int []
				                              {
				                                 CMQCFC.MQCACH_CHANNEL_NAME,
				                                 CMQCFC.MQCACH_CONNECTION_NAME,
				                                 CMQCFC.MQIACH_CHANNEL_STATUS,
				                                 CMQCFC.MQIACH_CHANNEL_SUBSTATE,
				                                 CMQCFC.MQIACH_MSGS,
				                                 CMQCFC.MQCACH_LAST_MSG_DATE,
				                                 CMQCFC.MQCACH_LAST_MSG_TIME,
				                                 CMQCFC.MQCACH_CHANNEL_START_DATE,
				                                 CMQCFC.MQCACH_CHANNEL_START_TIME,
				                                 CMQCFC.MQIACH_BYTES_SENT,
				                                 CMQCFC.MQIACH_BYTES_RECEIVED,
				                                 CMQCFC.MQIACH_BUFFERS_SENT,
				                                 CMQCFC.MQIACH_BUFFERS_RECEIVED,
				                                 CMQCFC.MQIACH_MCA_STATUS,
				                                 CMQCFC.MQCACH_MCA_JOB_NAME,
				                                 CMQCFC.MQCACH_MCA_USER_ID
				                              } );*/
				         res = agent.send(mes);
				         
				         if ( (res.length <= 2)  && (res[0].getCompCode() != MQException.MQCC_OK) ){
				        	 System.out.println("Error in response");
				         }
				             
				         int chlStatus=0,chltype,chlsubstat;
				         String status,type,substate,msgDt,msgTm;
				         ArrayList<String> name = new ArrayList<String>();
				         ArrayList<String> statusList = new ArrayList<String>();
				         ArrayList<String> ip = new ArrayList<String>();
				         ArrayList<String> typeList = new ArrayList<String>();
				         ArrayList<String> substatList = new ArrayList<String>();
				         ArrayList<String> lstMsgTmList = new ArrayList<String>();
				         ArrayList<String> lstMsgDtList = new ArrayList<String>();
				         /*LinkedHashSet<ChannelStatus> resUnique = new LinkedHashSet<ChannelStatus>();
				         for(int i = 0; i<res.length; i++){
				        	 chlStatus = res[i].getIntParameterValue(MQConstants.MQIACH_CHANNEL_STATUS);
				        	 cName = (String)res[i].getParameterValue(MQConstants.MQCACH_CHANNEL_NAME);
				        	 
				        	 if (chlStatus == MQConstants.MQCHS_STOPPED)
					              status = "Stopped";
					           else if (chlStatus == MQConstants.MQCHS_RUNNING)
					              status = "Running";
					           else if (chlStatus == MQConstants.MQCHS_STOPPING)
					              status = "Stopping";
					           else if (chlStatus == MQConstants.MQCHS_INACTIVE)
					              status = "Inactive";
					           else if (chlStatus == MQConstants.MQCHS_INITIALIZING)
					              status = "Initializing";
					           else if (chlStatus == MQConstants.MQCHS_BINDING)
					              status = "Binding";
					           else if (chlStatus == MQConstants.MQCHS_STARTING)
					              status = "Starting";
					           else if (chlStatus == MQConstants.MQCHS_PAUSED)
					              status = "Paused";
					           else if (chlStatus == MQConstants.MQCHS_RETRYING)
					              status = "Retrying";
					           else
					        	   status = "unknown";
				        	 
				        	 ChannelStatus tmp = new ChannelStatus();
				        	 tmp.setChName(cName);
				        	 tmp.setChStatus(status);
				        	 resUnique.add(tmp);
				         }
				          */
				         for (PCFMessage tmp:res){
				        	 
				        	  chlStatus = tmp.getIntParameterValue(MQConstants.MQIACH_CHANNEL_STATUS);
				        	  chltype = tmp.getIntParameterValue(MQConstants.MQIACH_CHANNEL_TYPE);
				        	  chlsubstat = tmp.getIntParameterValue(MQConstants.MQIACH_CHANNEL_SUBSTATE);
				        	  name.add((String)tmp.getParameterValue(MQConstants.MQCACH_CHANNEL_NAME));
				        	  ip.add((String)tmp.getParameterValue(MQConstants.MQCACH_CONNECTION_NAME));
				        	  msgDt = (String)tmp.getStringParameterValue(MQConstants.MQCACH_LAST_MSG_DATE);
				        	  if(msgDt.trim().isEmpty()){
				        		  msgDt = "NA";
				        	  }
				        	  lstMsgDtList.add(msgDt.trim());
				        	  msgTm = (String)tmp.getStringParameterValue(MQConstants.MQCACH_LAST_MSG_TIME);
				        	  if(msgTm.trim().isEmpty()){
				        		  msgTm = "NA";
				        	  }
				        	  lstMsgTmList.add(msgTm.trim());
				        	  
				           if(chlStatus == MQConstants.MQCHS_STOPPED)
				              status = "STOPPED";
				           else if (chlStatus == MQConstants.MQCHS_RUNNING)
				              status = "RUNNING";
				           else if (chlStatus == MQConstants.MQCHS_STOPPING)
				              status = "STOPPING";
				           else if (chlStatus == MQConstants.MQCHS_INACTIVE)
				              status = "INACTIVE";
				           else if (chlStatus == MQConstants.MQCHS_INITIALIZING)
				              status = "INITIALIZING";
				           else if (chlStatus == MQConstants.MQCHS_BINDING)
				              status = "BINDING";
				           else if (chlStatus == MQConstants.MQCHS_STARTING)
				              status = "STARTING";
				           else if (chlStatus == MQConstants.MQCHS_PAUSED)
				              status = "PAUSED";
				           else if (chlStatus == MQConstants.MQCHS_RETRYING)
				              status = "RETRYING";
				           else
				        	   status = "UNKNOWN";
				          
				          statusList.add(status);
				          
				          
				          if(chltype == MQConstants.MQCHT_SENDER){
				        	  type = "SENDER";
				          }else if(chltype == MQConstants.MQCHT_SERVER){
				        	  type = "SERVER";
				          }else if(chltype == MQConstants.MQCHT_RECEIVER){
				        	  type = "RECEIVER";
				          }else if(chltype == MQConstants.MQCHT_REQUESTER){
				        	  type = "REQUESTER";
				          }else if(chltype == MQConstants.MQCHT_SVRCONN){
				        	  type = "SERVER-CONNECTION";
				          }else if(chltype == MQConstants.MQCHT_CLNTCONN){
				        	  type = "CLIENT-CONNECTION";
				          }else if(chltype == MQConstants.MQCHT_CLUSRCVR){
				        	  type = "CLUSTER_RECEIVER";
				          }else if(chltype == MQConstants.MQCHT_CLUSSDR){
				        	  type = "CLUSTER_SENDER";
				          }else{
				        	  type = "UNKNOWN";
				          }
				          typeList.add(type);
				          
				          if(chlsubstat == MQConstants.MQCHSSTATE_IN_CHADEXIT){
				        	  substate = "CHADEXIT";
				          }else if(chlsubstat == MQConstants.MQCHSSTATE_COMPRESSING){
				        	  substate = "COMPRESS";
				          }else if(chlsubstat == MQConstants.MQCHSSTATE_END_OF_BATCH){
				        	  substate = "ENDBATCH";
				          }else if(chlsubstat == MQConstants.MQCHSSTATE_HEARTBEATING){
				        	  substate = "HEARTBEAT";
				          }else if(chlsubstat == MQConstants.MQCHSSTATE_IN_MQGET){
				        	  substate = "MQGET";
				          }else if(chlsubstat == MQConstants.MQCHSSTATE_IN_MQI_CALL){
				        	  substate = "MQICALL";
				          }else if(chlsubstat == MQConstants.MQCHSSTATE_IN_MQPUT){
				        	  substate = "MQPUT";
				          }else if(chlsubstat == MQConstants.MQCHSSTATE_NAME_SERVER){
				        	  substate = "NAMESERVER";
				          }else if(chlsubstat == MQConstants.MQCHSSTATE_NET_CONNECTING){
				        	  substate = "NETCONNECT";
				          }else if(chlsubstat == MQConstants.MQCHSSTATE_OTHER){
				        	  substate = "UNKNOWN";
				          }else if(chlsubstat == MQConstants.MQCHSSTATE_RECEIVING){
				        	  substate = "RECEIVE";		        	  
				          }else if(chlsubstat == MQConstants.MQCHSSTATE_RESYNCHING){
				        	  substate = "RESYNCH";
				          }else if(chlsubstat == MQConstants.MQCHSSTATE_SENDING){
				        	  substate = "SEND";
				          }else if(chlsubstat == MQConstants.MQCHSSTATE_SERIALIZING){
				        	  substate = "SERIALIZE";
				          }else {
				        	  substate = "UNKNOWN";
				          }
				          substatList.add(substate);
				          
				        	/*
				        	 MQCHSSTATE_CHADEXIT
		Running channel auto-definition exit.
		
		MQCHSSTATE_COMPRESSING
		Compressing or decompressing data.
		
		MQCHSSTATE_END_OF_BATCH
		End of batch processing.
		
		
		
		
		
		
				        	 */
				        	  
				        	  
				          }
				         // System.out.println("Channel :: "+name+"\nStatus:: "+status);
				     
				          
		//		          	MbElement outroot = outMessage.getRootElement();
		//					MbElement xmlNsc = outroot.createElementAsLastChild(MbXMLNSC.PARSER_NAME);
		//					MbElement channels = xmlNsc.createElementAsLastChild(MbElement.TYPE_NAME,"Channels",null);
							StringBuffer kwdContents = new StringBuffer();
							for(int i=0;i<name.size();i++){	
		//					MbElement channelEle = channels.createElementAsLastChild(MbElement.TYPE_NAME,"Channel",null);
		//					MbElement ChName = channelEle.createElementAsLastChild(MbElement.TYPE_NAME_VALUE, "ChName", name.get(i));
		//					MbElement ChStatus = channelEle.createElementAsLastChild(MbElement.TYPE_NAME_VALUE, "Status", statusList.get(i));
		//					MbElement ipHost = channelEle.createElementAsLastChild(MbElement.TYPE_NAME_VALUE, "IP", ip.get(i));
								kwdContents.append(name.get(i).trim()+"^"+statusList.get(i).trim()+"^"+ip.get(i).trim()+"^"+substatList.get(i)+"^"+typeList.get(i)+"^"+lstMsgDtList.get(i)+"^"+lstMsgTmList.get(i));
								kwdContents.append("~");
						}
				    	
						outMessage.getRootElement().getLastChild().getLastChild().setValue(kwdContents.toString().getBytes());
				 }
		    	 //-------------------------------------------------------------------------------------------------
		    	 
		    	 
		    	 
		    	 else if(reqType.equals("QN")){
		    		 StringBuffer QNameContents = new StringBuffer();
		    		 inquireQueueNames =new PCFMessage(MQConstants.MQCMD_INQUIRE_Q_NAMES);
		    		 inquireQueueNames.addParameter(MQConstants.MQCA_Q_NAME, "*");
		    		 res3 = agent.send(inquireQueueNames);
		    		 for(PCFMessage tmp:res3){
		    			 for(String q :tmp.getStringListParameterValue(MQConstants.MQCACF_Q_NAMES)){
		    				 QNameContents.append(q.trim()+"^");
		    			 }
		    		 }
		    		 outMessage.getRootElement().getLastChild().getLastChild().setValue(QNameContents.toString().getBytes());
		    	 }
		    	 else if(reqType.equals("CN")){
		    		 StringBuffer ChNameContents = new StringBuffer();
		    		 inquireChNames =new PCFMessage(MQConstants.MQCMD_INQUIRE_CHANNEL_NAMES);
		    		 inquireChNames.addParameter(MQConstants.MQCACH_CHANNEL_NAME, "*");
		    		 res4 = agent.send(inquireChNames);
		    		 for(PCFMessage tmp:res4){
		    			 for(String ch :tmp.getStringListParameterValue(MQConstants.MQCACH_CHANNEL_NAMES)){
		    				 ChNameContents.append(ch.trim()+"^");
		    			 }
		    		 }
		    		 outMessage.getRootElement().getLastChild().getLastChild().setValue(ChNameContents.toString().getBytes());
		    	 }
		    	 else if(reqType.equals("TN")){
		    		 //MQCMD_INQUIRE_TOPIC_NAMES
		    		 StringBuffer TpNameContents = new StringBuffer();
		    		 inquireTpNames =new PCFMessage(MQConstants.MQCMD_INQUIRE_TOPIC_NAMES);
		    		 inquireTpNames.addParameter(MQConstants.MQCA_TOPIC_NAME, "*");
//		    		 int attrs[]={
//		    			MQConstants.MQIA_INHIBIT_PUB,
//		    			MQConstants.MQIA_INHIBIT_SUB,
//		    			MQConstants.MQIA_PUB_COUNT,
//		    			MQConstants.MQIA_SUB_COUNT,
//		    		 };
//		    		 inquireTpStatus.addParameter(MQConstants.MQIACF_TOPIC_STATUS_ATTRS, attrs);
		    		 res7 = agent.send(inquireTpNames);
			         for (PCFMessage tmp:res7){
			        	 for(String topic:tmp.getStringListParameterValue(MQConstants.MQCACF_TOPIC_NAMES)){
			        		 TpNameContents.append(topic.trim()+"^");
			        	 }
			         }
			         outMessage.getRootElement().getLastChild().getLastChild().setValue(TpNameContents.toString().getBytes());
		    	 }
		    	 else if(reqType.equals("T")){
		    		 StringBuffer tpStatusContents = new StringBuffer();
		    		 inquireTpStatus =new PCFMessage(MQConstants.MQCMD_INQUIRE_TOPIC);
		    		 inquireTpStatus.addParameter(MQConstants.MQCA_TOPIC_NAME, tpName);
		    		 
		    		 
		    		 int attrs[]={
				    			MQConstants.MQCA_TOPIC_DESC,
				    			MQConstants.MQCA_TOPIC_STRING,
				    			MQConstants.MQIA_INHIBIT_PUB,
				    			MQConstants.MQIA_INHIBIT_SUB,
				    		 };
		    		 inquireTpStatus.addParameter(MQConstants.MQIACF_TOPIC_ATTRS, attrs);
		    		 res5 = agent.send(inquireTpStatus);
		    		 
		    		 if ( (res5.length <= 2)  && (res5[0].getCompCode() != MQException.MQCC_OK) ){
			        	 System.out.println("Error in response");
			         }else{
			        	 int inhibitPub,inhibitSub,pubCnt=0,subCnt=0;
			        	 String tpString="NA",tpDesc="NA",pubStr="NA",subStr="NA";
			        	 for (PCFMessage tmp:res5){
			        		 tpString = tmp.getStringParameterValue(MQConstants.MQCA_TOPIC_STRING);
			        		 tpDesc = tmp.getStringParameterValue(MQConstants.MQCA_TOPIC_DESC);
			        		 inhibitPub = tmp.getIntParameterValue(MQConstants.MQIA_INHIBIT_PUB);
			        		 inhibitSub = tmp.getIntParameterValue(MQConstants.MQIA_INHIBIT_SUB);
//			        		 pubCnt = tmp.getIntParameterValue(MQConstants.MQIA_PUB_COUNT);
//			        		 subCnt = tmp.getIntParameterValue(MQConstants.MQIA_SUB_COUNT);
			        		 if(inhibitPub == MQConstants.MQTA_PUB_ALLOWED){
			        			 pubStr="Allowed";
			        		 }else if(inhibitPub == MQConstants.MQTA_PUB_AS_PARENT){
			        			 pubStr="As Parent";
			        		 }else{
			        			 pubStr="Not Allowed";
			        		 }
			        		 
			        		 if(inhibitSub == MQConstants.MQTA_SUB_ALLOWED){
			        			 subStr="Allowed";
			        		 }else if(inhibitSub == MQConstants.MQTA_SUB_AS_PARENT){
			        			 subStr="As Parent";
			        		 }else{
			        			 subStr="Not Alowed";
			        		 }
			        		 
			        		 tpStatusContents.append(tpName.trim()+"^"+tpString.trim()+"^"+tpDesc.trim()+"^"+pubStr+"^"+subStr);
			        	 }
			         }
		    		 
//		    		 int attrs1[]={
//		    			MQConstants.MQIA_INHIBIT_PUB,
//		    			MQConstants.MQIA_INHIBIT_SUB,
//		    			MQConstants.MQIA_PUB_COUNT,
//		    			MQConstants.MQIA_SUB_COUNT,
//		    		 };
		    		 
		    		 
		    		 
		    		 
		    		 
	/*	    		 
		    		 //--------------------------------------------------------------------------------------------------------------------
		    		 //For Further Enhancement
		    		 inquireTpStatus1 =new PCFMessage(MQConstants.MQCMD_INQUIRE_TOPIC_STATUS);
		    		 inquireTpStatus1.addParameter(MQConstants.MQCA_TOPIC_STRING, tpName);
		    		 inquireTpStatus1.addParameter(MQConstants.MQIACF_TOPIC_STATUS_TYPE, MQConstants.MQIACF_TOPIC_SUB);
//		    		 int attrs1[]={
//		    			MQConstants.MQCACF_LAST_MSG_DATE,
//		    			MQConstants.MQCACF_LAST_MSG_TIME,
//		    			MQConstants.MQIA_PUB_COUNT,
//		    			MQConstants.MQIA_SUB_COUNT,
//		    		 };
		    		 inquireTpStatus1.addParameter(MQConstants.MQIACF_TOPIC_STATUS_ATTRS, attrs1);
		    		 res6 = agent.send(inquireTpStatus1);
		    		 
		    		 
		    		 
		    		 inquireTpStatus2 =new PCFMessage(MQConstants.MQCMD_INQUIRE_TOPIC_STATUS);
		    		 inquireTpStatus2.addParameter(MQConstants.MQCA_TOPIC_STRING, tpName);
		    		 inquireTpStatus2.addParameter(MQConstants.MQIACF_TOPIC_STATUS_TYPE, MQConstants.MQIACF_TOPIC_PUB);
		    		 int attrs2[]={
		    			MQConstants.MQCACF_LAST_PUB_DATE,
		    			MQConstants.MQCACF_LAST_PUB_TIME,
//		    			MQConstants.MQIA_PUB_COUNT,
//		    			MQConstants.MQIA_SUB_COUNT,
		    		 };
		    		 inquireTpStatus2.addParameter(MQConstants.MQIACF_TOPIC_STATUS_ATTRS, attrs2);
		    		 res7 = agent.send(inquireTpStatus2);
		    		 //---------------------------------------------------------------------------------------------------------------------
	*/	    		 
		    		 outMessage.getRootElement().getLastChild().getLastChild().setValue(tpStatusContents.toString().getBytes());
		    	 }
		    	 
		    	 
		    	 
		    	 
		    	 
		    	 
		    	 
		    	 
		    	 
		    	 
		    	 //--------------------------------------------------------------------------------------------------
				agent.disconnect();
				qMgr.disconnect();
		     
			// End of user code
			// ----------------------------------------------------------
		} catch (Exception e) {
			// Consider replacing Exception with type(s) thrown by user code
			// Example handling ensures all exceptions are re-thrown to be handled in the flow
			String x = e.getMessage();
			try {
				//agent.disconnect();
				//qMgr.disconnect();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			if(e.getMessage().equals("MQJE001: Completion Code '2', Reason '3065'.")){
				
//				MbElement outroot = outMessage.getRootElement();
//				MbElement xmlNsc = outroot.createElementAsLastChild(MbXMLNSC.PARSER_NAME);
//				MbElement channels = xmlNsc.createElementAsLastChild(MbElement.TYPE_NAME,"Channels",null);
//				MbElement channelEle = channels.createElementAsLastChild(MbElement.TYPE_NAME,"Channel",null);
//				MbElement ChName = channelEle.createElementAsLastChild(MbElement.TYPE_NAME_VALUE, "ChName", chName);
//				MbElement ChStatus = channelEle.createElementAsLastChild(MbElement.TYPE_NAME_VALUE, "Status", "Inactive");
				
			}else{
			MbUserException mbue = new MbUserException(this, "evaluate()", "",
					"", e.toString(), null);
			throw mbue;}
		}
		// The following should only be changed
		// if not propagating message to the 'out' terminal
		out.propagate(outAssembly);

	}

}