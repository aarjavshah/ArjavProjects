package com.cts.dnb.AdminService;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import org.apache.commons.io.FileUtils;

import com.cts.dnb.Application1.FilePaths;
import com.cts.dnb.model5.ObjectFactory;
import com.cts.dnb.model5.RequestTYP;
import com.cts.dnb.model5.RequestsTYP;

public class ManageRequests {
	public static RequestsTYP getReqRoot(){
		File file = new File(FilePaths.getREQ_LOG());
		JAXBContext jaxbContext;
		RequestsTYP reqs = new RequestsTYP();
		try {
			jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Source source = new StreamSource(file);
			JAXBElement<RequestsTYP> root = jaxbUnmarshaller. unmarshal(source, RequestsTYP.class);
			reqs = root.getValue();	
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return reqs;
	}
	
	public static boolean checkDuplicateRequest(RequestTYP req){
		boolean ret = false;
		for(RequestTYP tmp:getReqRoot().getRequest()){
			if(tmp.getRequestID().equals(req.getRequestID())){
				ret = true;
				break;
			}
		}
		return ret;
	}
	
	public static void EnrollRequest(RequestTYP req){
		if(!checkDuplicateRequest(req)){
			String oldFileName = FilePaths.getREQ_LOG();
			String tmpFileName = FilePaths.getAddedTo();
			BufferedReader br = null;
			BufferedWriter bw = null;
			int i=0;
			try {
		         br = new BufferedReader(new FileReader(oldFileName));
		         bw = new BufferedWriter(new FileWriter(tmpFileName));
		         String line;
		         while ((line = br.readLine()) != null) {
		            if (line.contains("</Requests>"))
		               line = line.replace("</Requests>","<Request>\r\n<RequestID>"+req.getRequestID()+"</RequestID>\r\n<RequestType>"+req.getRequestType()+"</RequestType>\r\n<RequestStatus>"+req.getRequestStatus()+"</RequestStatus>\r\n</Request>\r\n</Requests>");
		            bw.write(line+"\r\n");
		         }
		      } catch (Exception e) {
		    	  
		      } finally {
		         try {
		            if(br != null)
		               br.close();
		         } catch (IOException e) {
		        	 
		         }
		         try {
		            if(bw != null)
		               bw.close();
		         } catch (IOException e) {
		        	
		         }
		      }
		      // Once everything is complete, delete old file..
		      File oldFile = new File(oldFileName);
		      oldFile.delete();
		      // And rename tmp file's name to old file name
		      File newFile = new File(tmpFileName);
		      boolean check = newFile.renameTo(oldFile);
		}
	}
	
	public static void UpdateRequest(RequestTYP in){
		StringBuffer xmlContents = new StringBuffer();
		xmlContents.append("<Requests xmlns=\"http://www.example.org/Requests\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.example.org/Requests Requests.xsd \">\r\n");
		for(RequestTYP req: getReqRoot().getRequest()){
			if(req.getRequestID().equals(in.getRequestID())){
				xmlContents.append("<Request>\r\n<RequestID>"+in.getRequestID()+"</RequestID>\r\n<RequestType>"+in.getRequestType()+"</RequestType>\r\n<RequestStatus>"+in.getRequestStatus()+"</RequestStatus>\r\n</Request>\r\n");
			}else{
				xmlContents.append("<Request>\r\n<RequestID>"+req.getRequestID()+"</RequestID>\r\n<RequestType>"+req.getRequestType()+"</RequestType>\r\n<RequestStatus>"+req.getRequestStatus()+"</RequestStatus>\r\n</Request>\r\n");
			}
		}
		xmlContents.append("</Requests>");
		File file = new File(FilePaths.getREQ_LOG());
		try {
			FileUtils.writeStringToFile(file, xmlContents.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static RequestTYP getReqObj(String reqID){
		RequestTYP req = null;
		for(RequestTYP tmp:getReqRoot().getRequest()){
			if(tmp.getRequestID().equals(reqID)){
				req = tmp;
				break;
			}
		}
		return req;
	}
}
