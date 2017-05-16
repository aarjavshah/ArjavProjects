package com.cts.dnb.AdminService;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.cts.dnb.Application1.FilePaths;
import com.cts.dnb.Application1.QMUtilityVO;
import com.cts.dnb.Application1.UserJaxB;
import com.cts.dnb.Application2.QMMonitor;
import com.cts.dnb.model3.ConnectConfig;
import com.cts.dnb.model4.UserTYP;

public class ConfigureQM {
	
	
	public static int AddNewQueueManager(ConnectConfig conf,String env){
		int ret = 5;
		/*
		 * 0=success
		 * 1=QNamesFail
		 * 2=ChNamesFail
		 * 3=fileChangefail
		 * 4=QMExistsFail
		 * 5=UnknownFail
		 * */
		boolean flag1=false,flag2=false,flag3=false,flag4=false;
		flag3 = ValidateQM.IsQMExisting(conf);
		if(!flag3){
			QMUtilityVO vo =new QMUtilityVO();
			//conf.setQMchannel("SYSTEM.ADMIN.SVRCONN");
			conf.setQMusername("mqm");
			vo.setCon(conf);
			vo.setEnv(env);
			AddToConnectionFile(vo);
			StringBuffer newQMDetails = new StringBuffer();
			newQMDetails.append("<QueueManager>\r\n<environment>"+env+"</environment>\r\n<ConnectConfig>\r\n");
			newQMDetails.append("<QMname>"+conf.getQMname()+"</QMname>\r\n");
			newQMDetails.append("<QMhost>"+conf.getQMhost()+"</QMhost>\r\n");
			newQMDetails.append("<QMport>"+conf.getQMport()+"</QMport>\r\n");
			newQMDetails.append("<QMchannel>"+conf.getQMchannel()+"</QMchannel>\r\n");
			newQMDetails.append("<QMusername>mqm</QMusername>\r\n");
			newQMDetails.append("<QMpassword>NA</QMpassword>\r\n");
			newQMDetails.append("</ConnectConfig>\r\n");
			
			String reqQName = "a^QN^"+conf.getQMname()+"^"+conf.getQMhost()+"^"+conf.getQMport()+"^"+conf.getQMchannel()+"^mqm^";
			String resQName = QMMonitor.getResponse(reqQName);
			if(resQName==null || resQName.isEmpty()){
				ret=1;
				return ret;
			}else{
				newQMDetails.append("<queues>\r\n");
				String [] qList =resQName.split("\\^");
				for(String q : qList){
					newQMDetails.append("<queue>"+q+"</queue>\r\n");	
				}
				newQMDetails.append("</queues>\r\n");
				flag1=true;
			}
			String reqChName = "a^CN^"+conf.getQMname()+"^"+conf.getQMhost()+"^"+conf.getQMport()+"^"+conf.getQMchannel()+"^mqm^";
			String resChName = QMMonitor.getResponse(reqChName);
			if(resChName==null||resQName.isEmpty()){
				ret = 2;
				return ret;
			}else{
				newQMDetails.append("<Channels>\r\n");
				String chList[] = resChName.split("\\^");
				for(String ch:chList){
					newQMDetails.append("<Channel>"+ch+"</Channel>\r\n");
				}
				newQMDetails.append("</Channels>\r\n");
				flag2=true;
			}
			newQMDetails.append("</QueueManager>\r\n");
			//System.out.println(newQMDetails.toString());
			if(flag1&&flag2){
				StringBuffer oldContent = new StringBuffer();
				String oldFileName = FilePaths.getQM_CONFIG();
				String tmpFileName = FilePaths.getAddedTo();
				
				File tmpFile = new File(tmpFileName);
				BufferedReader br = null;
				try {
			         br = new BufferedReader(new FileReader(oldFileName));
			         String line;
			         while ((line = br.readLine()) != null) {
			            if (!line.contains("</QueueManagers>")){
			            	oldContent.append(line+"\r\n");
			            }			              
			         }
			         FileUtils.writeStringToFile(tmpFile, oldContent.toString()+newQMDetails.toString()+"</QueueManagers>");
			         flag4=true;
			      } catch (Exception e) {
			    	  ret=5;
			      }finally{
			    	  try {
						br.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			      }
				
		         File oldFile = new File(oldFileName);
		         oldFile.delete();
		         tmpFile.renameTo(oldFile);
			}
			if(flag4){
				ret = 0;
				return ret;
			}
			else{
				return ret;
			}
		}else{
			ret = 4;
			return ret;
		}
		
	}
	
	public static boolean AddToConnectionFile(QMUtilityVO vo){
		boolean ret =false;
		String oldFileName = FilePaths.getCON_LIST();
		String tmpFileName = FilePaths.getAddedTo();
		BufferedReader br = null;
		BufferedWriter bw = null;
		int i=0;
		String update = "</QMS>";
		update ="<QM>\r\n<QMEnv>"+vo.getEnv()+"</QMEnv>\r\n<QMname>"+vo.getCon().getQMname()+"</QMname>\r\n<QMhost>"+vo.getCon().getQMhost()+"</QMhost>\r\n<QMport>"+vo.getCon().getQMport()+"</QMport>\r\n<QMchannel>"+vo.getCon().getQMchannel()+"</QMchannel>\r\n<QMusername>"+vo.getCon().getQMusername()+"</QMusername>\r\n</QM>\r\n</QMS>";
		//System.out.println(update);
		try {
	         br = new BufferedReader(new FileReader(oldFileName));
	         bw = new BufferedWriter(new FileWriter(tmpFileName));
	         String line;
	         while ((line = br.readLine()) != null) {
	        	 //System.out.println(line);
	        	 if (line.contains("</QMS>"))
	        		 line = line.replace("</QMS>", update);
	         bw.write(line+"\r\n");}
         }catch (Exception e) {
    	  ret = true;
      } finally {
         try {
            if(br != null)
               br.close();
         } catch (IOException e) {
        	 ret = true;
         }
         try {
            if(bw != null)
               bw.close();
         } catch (IOException e) {
        	 ret=true;
         }
      }
      // Once everything is complete, delete old file..
      File oldFile = new File(oldFileName);
      oldFile.delete();
      // And rename tmp file's name to old file name
      File newFile = new File(tmpFileName);
      boolean check = newFile.renameTo(oldFile);
	return ret;
	}
	
	public static boolean RemoveQMCon(QMUtilityVO vo){
		boolean operationSuccess = false;
		File xmlFile = new File(FilePaths.getCON_LIST());
		StringBuffer xmlContents = new StringBuffer();
		xmlContents.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n<QMS>\r\n");
		for(QMUtilityVO temp :GetConnectionConfigList.RetrieveQmConnectList()){
			if(temp.getCon().getQMname().equals(vo.getCon().getQMname())){
				continue;
			}
			else{				
				xmlContents.append("<QM>\r\n<QMEnv>"+temp.getEnv()+"</QMEnv>\r\n<QMname>"+temp.getCon().getQMname()+"</QMname>\r\n<QMhost>"+temp.getCon().getQMhost()+"</QMhost>\r\n<QMport>"+temp.getCon().getQMport()+"</QMport>\r\n<QMchannel>"+temp.getCon().getQMchannel()+"</QMchannel>\r\n<QMusername>"+temp.getCon().getQMusername()+"</QMusername>\r\n</QM>\r\n");
			}
		}
		xmlContents.append("</QMS>");
		//System.out.println(xmlContents);
		try {
			FileUtils.writeStringToFile(xmlFile, xmlContents.toString());
			} catch (IOException e) {
			operationSuccess = true;
			}
		return !operationSuccess;
	}
	
	public static boolean UpdateQMCon(QMUtilityVO vo, String oldQMName){
		boolean operationSuccess = false;
		File xmlFile = new File(FilePaths.getCON_LIST());
		StringBuffer xmlContents = new StringBuffer();
		xmlContents.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n<QMS>\r\n");
		for(QMUtilityVO temp :GetConnectionConfigList.RetrieveQmConnectList()){
			if(temp.getCon().getQMname().equals(oldQMName)){
				xmlContents.append("<QM>\r\n<QMEnv>"+vo.getEnv()+"</QMEnv>\r\n<QMname>"+vo.getCon().getQMname()+"</QMname>\r\n<QMhost>"+vo.getCon().getQMhost()+"</QMhost>\r\n<QMport>"+vo.getCon().getQMport()+"</QMport>\r\n<QMchannel>"+vo.getCon().getQMchannel()+"</QMchannel>\r\n<QMusername>"+vo.getCon().getQMusername()+"</QMusername>\r\n</QM>\r\n");
			}
			else{				
				xmlContents.append("<QM>\r\n<QMEnv>"+temp.getEnv()+"</QMEnv>\r\n<QMname>"+temp.getCon().getQMname()+"</QMname>\r\n<QMhost>"+temp.getCon().getQMhost()+"</QMhost>\r\n<QMport>"+temp.getCon().getQMport()+"</QMport>\r\n<QMchannel>"+temp.getCon().getQMchannel()+"</QMchannel>\r\n<QMusername>"+temp.getCon().getQMusername()+"</QMusername>\r\n</QM>\r\n");
			}
		}
		xmlContents.append("</QMS>");
		//System.out.println(xmlContents);
		try {
			FileUtils.writeStringToFile(xmlFile, xmlContents.toString());
			} catch (IOException e) {
			operationSuccess = true;
			}
		return !operationSuccess;
	}
	
}
