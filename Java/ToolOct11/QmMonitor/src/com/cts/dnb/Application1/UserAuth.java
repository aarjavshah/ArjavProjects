package com.cts.dnb.Application1;

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
	
}
