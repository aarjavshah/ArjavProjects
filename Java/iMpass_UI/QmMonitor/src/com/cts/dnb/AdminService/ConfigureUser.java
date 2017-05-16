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
import com.cts.dnb.Application1.UserAuth;
import com.cts.dnb.Application1.UserJaxB;
import com.cts.dnb.model4.UserTYP;

public class ConfigureUser {
	public static int addUser(UserTYP user){
		/*
		 * 0 = success
		 * 1 = User Already Exists
		 * 2 = unknown error
		 * 3 = invalid request
		 * */
		int ret =0;
		if(UserAuth.AuthenticatePermit(user.getUserName())){
			ret = 1;
			return ret;
		}
		else{
			String oldFileName = FilePaths.getUSER_LIST();
			String tmpFileName = FilePaths.getAddedTo();
			BufferedReader br = null;
			BufferedWriter bw = null;
			int i=0;
			String update = "</Users>";
			if(user.getUserType().equals("permit")){
				update = "<User>\r\n<UserName>"+user.getUserName()+"</UserName>\r\n<UserType>"+user.getUserType()+"</UserType>\r\n</User>\r\n</Users>";
			}else if(user.getUserType().equals("admin")){
				update = "<User>\r\n<UserName>"+user.getUserName()+"</UserName>\r\n<UserType>"+user.getUserType()+"</UserType>\r\n<Password>"+user.getPassword()+"</Password>\r\n</User>\r\n</Users>";
			}else{
				ret =3;
				return ret;
			}
			//System.out.println(update);
			try {
		         br = new BufferedReader(new FileReader(oldFileName));
		         bw = new BufferedWriter(new FileWriter(tmpFileName));
		         String line;
		         while ((line = br.readLine()) != null) {
		        	// System.out.println(line);
		        	 if (line.contains("</Users>"))
		        		 line = line.replace("</Users>", update);
		         bw.write(line+"\r\n");}
	         }catch (Exception e) {
	    	  ret =2;
	      } finally {
	         try {
	            if(br != null)
	               br.close();
	         } catch (IOException e) {
	        	 ret = 2;
	         }
	         try {
	            if(bw != null)
	               bw.close();
	         } catch (IOException e) {
	        	 ret = 2;
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
	}
	
	public static boolean RemoveFromFile(UserTYP usr){
		boolean operationSuccess = false;
		File xmlFile = new File(FilePaths.getUSER_LIST());
		StringBuffer xmlContents = new StringBuffer();
		xmlContents.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n<Users xmlns=\"http://www.example.org/Users\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.example.org/Users Users.xsd \">\r\n");
		for(UserTYP temp : UserJaxB.GetUsers().getUser()){
			if(temp.getUserName().equals(usr.getUserName())){
				continue;
			}
			else{
				if(temp.getUserType().equals("permit")){
					xmlContents.append("<User>\r\n<UserName>"+temp.getUserName()+"</UserName>\r\n<UserType>"+temp.getUserType()+"</UserType>\r\n</User>\r\n");
				}else if(temp.getUserType().equals("admin")){
					xmlContents.append("<User>\r\n<UserName>"+temp.getUserName()+"</UserName>\r\n<UserType>"+temp.getUserType()+"</UserType>\r\n<Password>"+temp.getPassword()+"</Password>\r\n</User>\r\n");
				}
			}
		}
		xmlContents.append("</Users>");
		//System.out.println(xmlContents);
		try {
			FileUtils.writeStringToFile(xmlFile, xmlContents.toString());
			} catch (IOException e) {
			operationSuccess = true;
			}
		return !operationSuccess;
	}
	
	public static boolean updateUser(UserTYP usr,String username){
		boolean operationSuccess = false;
		File xmlFile = new File(FilePaths.getUSER_LIST());
		StringBuffer xmlContents = new StringBuffer();
		xmlContents.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n<Users xmlns=\"http://www.example.org/Users\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.example.org/Users Users.xsd \">\r\n");
		for(UserTYP temp : UserJaxB.GetUsers().getUser()){
			if(temp.getUserName().equals(username)){
				if(usr.getUserType().equals("permit")){
					xmlContents.append("<User>\r\n<UserName>"+usr.getUserName()+"</UserName>\r\n<UserType>"+usr.getUserType()+"</UserType>\r\n</User>\r\n");
				}else if(usr.getUserType().equals("admin")){
					xmlContents.append("<User>\r\n<UserName>"+usr.getUserName()+"</UserName>\r\n<UserType>"+usr.getUserType()+"</UserType>\r\n<Password>"+usr.getPassword()+"</Password>\r\n</User>\r\n");
				}
			}
			else{
				if(temp.getUserType().equals("permit")){
					xmlContents.append("<User>\r\n<UserName>"+temp.getUserName()+"</UserName>\r\n<UserType>"+temp.getUserType()+"</UserType>\r\n</User>\r\n");
				}else if(temp.getUserType().equals("admin")){
					xmlContents.append("<User>\r\n<UserName>"+temp.getUserName()+"</UserName>\r\n<UserType>"+temp.getUserType()+"</UserType>\r\n<Password>"+temp.getPassword()+"</Password>\r\n</User>\r\n");
				}
			}
		}
		xmlContents.append("</Users>");
		//System.out.println(xmlContents);
		try {
			FileUtils.writeStringToFile(xmlFile, xmlContents.toString());
			} catch (IOException e) {
			operationSuccess = true;
			}
		return !operationSuccess;
	}
}
