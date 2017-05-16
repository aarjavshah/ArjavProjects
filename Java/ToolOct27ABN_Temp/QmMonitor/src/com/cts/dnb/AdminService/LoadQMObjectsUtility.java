package com.cts.dnb.AdminService;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;

import com.cts.dnb.Application1.FilePaths;
import com.cts.dnb.Application1.QMUtilityVO;
import com.cts.dnb.Application2.QMMonitor;
import com.cts.dnb.model3.ConnectConfig;
import com.cts.dnb.model5.RequestTYP;

public class LoadQMObjectsUtility {

	public static void startQMUpdate(String reqID){
//		while(true){
			
			/*
			 * Logging the request as initiated in request logs
			 */
			//SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");			 
			RequestTYP req = new RequestTYP();
			//String reqId = "QMC"+sdf.format(new Date());
			req.setRequestID(reqID);
			req.setRequestType("QM-Config");
			req.setRequestStatus("Initiated");
			ManageRequests.EnrollRequest(req);
			
			System.out.println("Starting the update cycle at " + new Date());
		
			StringBuffer newQMDetails = new StringBuffer();
			newQMDetails.append("<?xml version=\"1.0\"?><QueueManagers xmlns=\"http://www.example.org/QMs\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.example.org/QMs QMs.xsd \">");
			for(QMUtilityVO Con:GetConnectionConfigList.RetrieveQmConnectList()){
				ConnectConfig conf=Con.getCon();
				String env = Con.getEnv();
				System.out.println("Connecting to "+conf.getQMname()+" with "+conf.getQMchannel());
//				if(!ValidateQM.CheckAvailability(conf)){
//					System.out.println("\tError connecting to "+conf.getQMname()+"\n\tCheck connection details");
//				}else{
					newQMDetails.append("<QueueManager>\r\n<environment>"+env+"</environment>\r\n<ConnectConfig>\r\n");
					newQMDetails.append("<QMname>"+conf.getQMname()+"</QMname>\r\n");
					newQMDetails.append("<QMhost>"+conf.getQMhost()+"</QMhost>\r\n");
					newQMDetails.append("<QMport>"+conf.getQMport()+"</QMport>\r\n");
					newQMDetails.append("<QMchannel>"+conf.getQMchannel()+"</QMchannel>\r\n");
					newQMDetails.append("<QMusername>"+conf.getQMusername()+"</QMusername>\r\n");
					newQMDetails.append("<QMpassword>NA</QMpassword>\r\n");
					newQMDetails.append("</ConnectConfig>\r\n");
					//System.out.println(conf.getQMchannel());
					String reqQName = "a^QN^"+conf.getQMname()+"^"+conf.getQMhost()+"^"+conf.getQMport()+"^"+conf.getQMchannel()+"^"+conf.getQMusername()+"^";
					String resQName = QMMonitor.getResponse(reqQName);
					if(resQName==null || resQName.isEmpty()){
						System.out.println("Error Loading Queues");
					}else{
						newQMDetails.append("<queues>\r\n");
						String [] qList =resQName.split("\\^");
						System.out.println("\tLoaded "+qList.length+" Queues!");
						for(String q : qList){
							newQMDetails.append("<queue>"+q+"</queue>\r\n");	
						}
						newQMDetails.append("</queues>\r\n");
					}
					
					
					String reqChName = "a^CN^"+conf.getQMname()+"^"+conf.getQMhost()+"^"+conf.getQMport()+"^"+conf.getQMchannel()+"^"+conf.getQMusername()+"^";
					String resChName = QMMonitor.getResponse(reqChName);
					if(resChName==null||resChName.isEmpty()){
						
					}else{
						newQMDetails.append("<Channels>\r\n");
						String chList[] = resChName.split("\\^");
						System.out.println("\tLoaded "+chList.length+" Channels!");
						for(String ch:chList){
							newQMDetails.append("<Channel>"+ch+"</Channel>\r\n");
						}
						newQMDetails.append("</Channels>\r\n");
					}
					
					String reqTpName = "a^TN^"+conf.getQMname()+"^"+conf.getQMhost()+"^"+conf.getQMport()+"^"+conf.getQMchannel()+"^"+conf.getQMusername()+"^";
					System.out.println(reqTpName);
					String resTpName = QMMonitor.getResponse(reqTpName);
					if(resTpName==null||resTpName.isEmpty()){
						
					}else{
						newQMDetails.append("<topics>\r\n");
						String tpList[] = resTpName.split("\\^");
						System.out.println("\tLoaded "+tpList.length+" Topics!");
						for(String tp:tpList){
							newQMDetails.append("<topic>"+tp+"</topic>\r\n");
						}
						newQMDetails.append("</topics>\r\n");
					}
					
					
					newQMDetails.append("</QueueManager>\r\n");
				}
//			}
			newQMDetails.append("</QueueManagers>");
//		}
			File file = new File(FilePaths.getQM_CONFIG());
			try {
				FileUtils.writeStringToFile(file, newQMDetails.toString());
				System.out.println("File Updated on "+ new Date());
				req.setRequestStatus("Success");
				ManageRequests.UpdateRequest(req);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
