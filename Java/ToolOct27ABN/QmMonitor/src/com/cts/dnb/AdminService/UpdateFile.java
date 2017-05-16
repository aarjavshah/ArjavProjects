package com.cts.dnb.AdminService;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;

import com.cts.dnb.Application1.BrokerDetailsVO;
import com.cts.dnb.Application1.BrokerXML;
import com.cts.dnb.Application1.FilePaths;

public class UpdateFile {

	public static int AddtoFile(BrokerDetailsVO brokerdetails){
		int operationSuccess = 0;
		if(ValidateBroker.IsBrokerAlreadyExisting(brokerdetails)){
			operationSuccess=1;
			return operationSuccess;
		}else{
			String oldFileName = FilePaths.getBrokerDetails();
			String tmpFileName = FilePaths.getAddedTo();
			BufferedReader br = null;
			BufferedWriter bw = null;
			int i=0;
			try {
		         br = new BufferedReader(new FileReader(oldFileName));
		         bw = new BufferedWriter(new FileWriter(tmpFileName));
		         String line;
		         while ((line = br.readLine()) != null) {
		            if (line.contains("</broker-details>"))
		               line = line.replace("</broker-details>","<broker>\r\n<broker-name>"+brokerdetails.getBrokerName()+"</broker-name>\r\n<alias>"+brokerdetails.getAlias()+"</alias>\r\n<Queue-manager>"+brokerdetails.getQueueManagerName()+"</Queue-manager>\r\n<host>"+brokerdetails.getHost()+"</host>\r\n<port>"+brokerdetails.getPort()+"</port>\r\n</broker>\r\n</broker-details>");
		            bw.write(line+"\r\n");
		         }
		      } catch (Exception e) {
		    	  operationSuccess =2;
		      } finally {
		         try {
		            if(br != null)
		               br.close();
		         } catch (IOException e) {
		        	 operationSuccess = 2;
		         }
		         try {
		            if(bw != null)
		               bw.close();
		         } catch (IOException e) {
		        	 operationSuccess = 2;
		         }
		      }
		      // Once everything is complete, delete old file..
		      File oldFile = new File(oldFileName);
		      oldFile.delete();
		      // And rename tmp file's name to old file name
		      File newFile = new File(tmpFileName);
		      boolean check = newFile.renameTo(oldFile);
		      
			
			return operationSuccess;
		}
	}
	
	
	
	public static boolean RemoveFromFile(BrokerDetailsVO brokerdetails){
		boolean operationSuccess = false;
		File xmlFile = new File(FilePaths.getBrokerDetails());
		ArrayList<BrokerDetailsVO> brokers = BrokerXML.RetrieveDetailedbrokerList();
		StringBuffer xmlContents = new StringBuffer();
		xmlContents.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n<broker-details>\r\n");
		for(BrokerDetailsVO broker : brokers){
			if(broker.getBrokerName().equals(brokerdetails.getBrokerName())){
				continue;
			}
			else{
				xmlContents.append("<broker>\r\n<broker-name>"+broker.getBrokerName()+"</broker-name>\r\n<alias>"+broker.getAlias()+"</alias>\r\n<Queue-manager>"+broker.getQueueManagerName()+"</Queue-manager>\r\n<host>"+broker.getHost()+"</host>\r\n<port>"+broker.getPort()+"</port>\r\n</broker>\r\n");
			}
		}
		xmlContents.append("</broker-details>");
		//System.out.println(xmlContents);
		try {
			FileUtils.writeStringToFile(xmlFile, xmlContents.toString());
		} catch (IOException e) {
			operationSuccess = true;
		}
		
		
//		String oldFileName = "D:\\BrokerDetails.xml";
//	      String tmpFileName = "D:\\tmp.xml";
//
//	      BufferedReader br = null;
//	      BufferedWriter bw = null;
//	      try {
//	         br = new BufferedReader(new FileReader(oldFileName));
//	         bw = new BufferedWriter(new FileWriter(tmpFileName));
//	         String line;
//	         String broker = "<broker><broker-name>"+brokerdetails.getBrokerName()+"</broker-name><alias>"+brokerdetails.getAlias()+"</alias><Queue-manager>"+brokerdetails.getQueueManagerName()+"</Queue-manager><host>"+brokerdetails.getHost()+"</host><port>"+brokerdetails.getPort()+"</port></broker>";
//	         while ((line = br.readLine()) != null) {
//	            if (line.contains(broker))
//	               line = line.replace(broker,"");
//	            bw.write(line);
//	         }
//	      } catch (Exception e) {
//	    	  operationSuccess =true;
//	      } finally {
//	         try {
//	            if(br != null)
//	               br.close();
//	         } catch (IOException e) {
//	        	 operationSuccess = true;
//	         }
//	         try {
//	            if(bw != null)
//	               bw.close();
//	         } catch (IOException e) {
//	        	 operationSuccess = true;
//	         }
//	      }
//	      // Once everything is complete, delete old file..
//	      File oldFile = new File(oldFileName);
//	      oldFile.delete();
//
//	      // And rename tmp file's name to old file name
//	      File newFile = new File(tmpFileName);
//	      newFile.renameTo(oldFile);

		
		
		return !operationSuccess;
	}
	
	public static int UpdateintoFile(BrokerDetailsVO brokerdetails,String oldBrokerName){
		int operationSuccess = 0;
		if(ValidateBroker.IsBrokerAlreadyExisting(brokerdetails)){
			operationSuccess=1;
			return operationSuccess;
		}else{
			File xmlFile = new File(FilePaths.getBrokerDetails());
			ArrayList<BrokerDetailsVO> brokers = BrokerXML.RetrieveDetailedbrokerList();
			StringBuffer xmlContents = new StringBuffer();
			xmlContents.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n<broker-details>\r\n");
			for(BrokerDetailsVO broker : brokers){
				if(broker.getBrokerName().equals(oldBrokerName)){
					xmlContents.append("<broker>\r\n<broker-name>"+brokerdetails.getBrokerName()+"</broker-name>\r\n<alias>"+brokerdetails.getAlias()+"</alias>\r\n<Queue-manager>"+brokerdetails.getQueueManagerName()+"</Queue-manager>\r\n<host>"+brokerdetails.getHost()+"</host>\r\n<port>"+brokerdetails.getPort()+"</port>\r\n</broker>\r\n");
				}
				else{
					xmlContents.append("<broker>\r\n<broker-name>"+broker.getBrokerName()+"</broker-name>\r\n<alias>"+broker.getAlias()+"</alias>\r\n<Queue-manager>"+broker.getQueueManagerName()+"</Queue-manager>\r\n<host>"+broker.getHost()+"</host>\r\n<port>"+broker.getPort()+"</port>\r\n</broker>\r\n");
				}
			}
			xmlContents.append("</broker-details>");
			//System.out.println(xmlContents);
			try {
				FileUtils.writeStringToFile(xmlFile, xmlContents.toString());
			} catch (IOException e) {
				operationSuccess = 2;
			}
			return operationSuccess;
			}
		}
/*	
	public static boolean UpdateFilePaths(String brokerDetails, String brokerStatus, int waitTime){
		boolean retIndicator = false;
		File xmlFile = new File("D:\\BrokerHealthCheck8\\Application1.0\\src\\com\\cts\\bsc\\Application1\\FilePaths.java");
		StringBuffer xmlContents = new StringBuffer();
		xmlContents.append("package com.cts.bsc.Application1;public class FilePaths {");
		xmlContents.append("public static final String BROKER_DETAILS=\"");
		xmlContents.append(FormatString(brokerDetails)+"\";");
		xmlContents.append("public static final String BROKER_STATUS=\"");
		xmlContents.append(FormatString(brokerStatus)+"\";");
		xmlContents.append("public static final String TEMP=\"D:\\\\temp.xml\";");
		xmlContents.append("public static final int WAIT_TIME_MIN = "+waitTime+";");
		xmlContents.append("public static int getWAIT_TIME_MIN() {return WAIT_TIME_MIN;}public static String getBrokerDetails() {return BROKER_DETAILS;}public static String getBrokerStatus() {	return BROKER_STATUS;}public static String getTemp() {return TEMP;}}");
		System.out.println(xmlContents);
		try {
			FileUtils.writeStringToFile(xmlFile, xmlContents.toString());
			System.out.println("done");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			retIndicator = true;
			e.printStackTrace();
		}
		return !retIndicator;
	}*/
	public static String FormatString(String x) {
		String[]a = x.split("\\\\");
		String new1="";
		for(String tmp:a){
			new1=new1.concat(tmp+"\\\\");
		}
		new1=new1.substring(0, new1.length()-2);
		return new1;
	}
	
	
	public static int AddtoNewFile(BrokerDetailsVO brokerdetails){
		int operationSuccess = 0;
		if(ValidateBroker.IsBrokerAlreadyExisting(brokerdetails)){
			operationSuccess=1;
			return operationSuccess;
		}else{
			File xmlFile = new File(FilePaths.getBrokerDetails());
			ArrayList<BrokerDetailsVO> brokers = BrokerXML.RetrieveDetailedbrokerList();
			StringBuffer xmlContents = new StringBuffer();
			xmlContents.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?><broker-details>");
			for(BrokerDetailsVO broker : brokers){
					xmlContents.append("<broker><broker-name>"+broker.getBrokerName()+"</broker-name><alias>"+broker.getAlias()+"</alias><Queue-manager>"+broker.getQueueManagerName()+"</Queue-manager><host>"+broker.getHost()+"</host><port>"+broker.getPort()+"</port></broker>");
			}
			xmlContents.append("<broker><broker-name>"+brokerdetails.getBrokerName()+"</broker-name><alias>"+brokerdetails.getAlias()+"</alias><Queue-manager>"+brokerdetails.getQueueManagerName()+"</Queue-manager><host>"+brokerdetails.getHost()+"</host><port>"+brokerdetails.getPort()+"</port></broker>");
			xmlContents.append("</broker-details>");
			//System.out.println(xmlContents);
			try {
				FileUtils.writeStringToFile(xmlFile, xmlContents.toString());
			} catch (IOException e) {
				operationSuccess = 2;
			}
			return operationSuccess;
			}
		}
}
