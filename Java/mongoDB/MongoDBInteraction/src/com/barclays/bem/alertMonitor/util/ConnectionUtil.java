package com.barclays.bem.alertMonitor.util;

import java.util.ArrayList;

import com.mongodb.MongoClient;

public class ConnectionUtil {
	public static MongoClient getConnection(){
		MongoClient mongo =new MongoClient("127.0.0.1", 27017);
		return mongo;
	}
	public static ArrayList<String> getDbList(MongoClient mongo){
		ArrayList<String> dbList = (ArrayList<String>) mongo.getDatabaseNames();
		return dbList;
	}
}
