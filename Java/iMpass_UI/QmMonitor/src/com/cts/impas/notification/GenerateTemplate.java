package com.cts.impas.notification;

import com.cts.dnb.model4.UserTYP;

public class GenerateTemplate {
	public static String GetMsgBody(int identifier,String requestNo,UserTYP usr){
		String msg="";
		msg = msg+"Hi "+usr.getUserName()+",\n";
		if(identifier==1){
			msg = msg +"The queue manager object updation cycle "+requestNo+" was completed successfully.\n";
		}
		else if(identifier==2) {
			msg = msg +"The broker object updation cycle "+requestNo+" was completed successfully.\n";
		}
		msg = msg+"\n\n(This mailbox will not be monitored. Please do not reply to this email.)\nRegards,\niMPAS team.";
		return msg;
	}
}
