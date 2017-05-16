package com.cts.dnb.Application1;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.cts.dnb.model4.UserTYP;

public class UserAuth {
	public static boolean AuthenticateAdmin(String userName,String password){
		boolean auth = false;
		//System.out.println("False@UserAuth");
		for(UserTYP usr:UserJaxB.GetUsers().getUser()){
			//System.out.println("User:"+usr.getUserName());
			if(usr.getUserName().equals(userName)){
				if(usr.getUserType().equalsIgnoreCase("admin") && usr.getPassword().equals(password)){
					//System.out.println("Match!");
					auth=true;
					break;
				}
			}
		}
		return auth;
	}
	public static boolean AuthenticatePermit(String userName){
		boolean auth = false;
		for(UserTYP usr:UserJaxB.GetUsers().getUser()){
			if(usr.getUserName().equals(userName)&&usr.getUserType().equalsIgnoreCase("permit")){
				auth = true;
			}
			else if(usr.getUserName().equals(userName)&&usr.getUserType().equalsIgnoreCase("admin")){ //Admin is a permitted user too.
				auth = true;
			}
		}
		return auth;
	}
	
	public static UserTYP GetUserTYP(String username){
		UserTYP usr = new UserTYP();
		boolean flag=false;
		for(UserTYP tmp:UserJaxB.GetUsers().getUser()){
			if(tmp.getUserName().equals(username)){
				usr = tmp;
				flag = true;
			}
		}
		if(!flag){
			return null; 
		}
		return usr;
	}
	
	public static String ChangeEncoding(String password) {
		 MessageDigest md=null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	        md.update(password.getBytes());

	        byte byteData[] = md.digest();

	        //convert the byte to hex format method 1
	        StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < byteData.length; i++) {
	         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
	        }

	       // System.out.println("Digest(in hex format):: " + sb.toString());

	        //convert the byte to hex format method 2
	        StringBuffer hexString = new StringBuffer();
	    	for (int i=0;i<byteData.length;i++) {
	    		String hex=Integer.toHexString(0xff & byteData[i]);
	   	     	if(hex.length()==1) hexString.append('0');
	   	     	hexString.append(hex);
	    	}
	    	//System.out.println(hexString.toString());
		return hexString.toString();
	}
	
}
