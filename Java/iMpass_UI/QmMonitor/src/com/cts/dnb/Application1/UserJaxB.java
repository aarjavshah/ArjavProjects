package com.cts.dnb.Application1;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import com.cts.dnb.model4.ObjectFactory;
import com.cts.dnb.model4.UserTYP;
import com.cts.dnb.model4.UsersTYP;

public class UserJaxB {
	public static UsersTYP GetUsers(){
		File file = new File(FilePaths.getUSER_LIST());
		//System.out.println(FilePaths.getUSER_LIST());
		
		JAXBContext jaxbContext;
		UsersTYP usrs = new UsersTYP();
		try {
			jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
		//	System.out.println(1);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		//	System.out.println(2);
			Source source = new StreamSource(file);
		//	System.out.println(3);
			JAXBElement <UsersTYP> root = jaxbUnmarshaller.unmarshal(source, UsersTYP.class);
		//	System.out.println(4);
			usrs = root.getValue();	
		//	System.out.println("usrs returned");
		}
		catch(JAXBException e){
			e.printStackTrace();
		//	System.out.println("Exception");
		}
		//System.out.println(usrs.getUser().size());
		return usrs;
	}
	public static ArrayList<String> GetUserList(){
		ArrayList<String> usrList = new ArrayList<String>();
		for(UserTYP user:GetUsers().getUser()){
			usrList.add(user.getUserName());
		}
		return usrList;
	}
}
