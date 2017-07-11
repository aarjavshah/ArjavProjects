package com.barclays.bem.alertMonitor.test;

import org.bson.BSON;
import org.bson.Document;

import com.barclays.bem.alertMonitor.util.ConnectionUtil;
import com.mongodb.MongoClient;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MongoClient mongo = ConnectionUtil.getConnection();
		Document criteria = new Document("name", "person1");
		for(Document a :mongo.getDatabase("test").getCollection("people").find(criteria)){
			System.out.println(a.toJson());
		}
		mongo.close();
	}

}
