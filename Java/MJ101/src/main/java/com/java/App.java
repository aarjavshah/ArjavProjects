package com.java;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.BsonDateTime;
import org.bson.BsonDocument;
import org.bson.BsonInt32;
import org.bson.BsonString;
import org.bson.Document;
import org.bson.codecs.DocumentCodec;
import org.bson.codecs.EncoderContext;
import org.bson.conversions.Bson;
import org.bson.json.JsonMode;
import org.bson.json.JsonWriter;
import org.bson.json.JsonWriterSettings;

import com.mongodb.MongoClient;
import com.mongodb.ReadPreference;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        MongoClient client = new MongoClient("localhost",27017);
        MongoDatabase db = client.getDatabase("test").withReadPreference(ReadPreference.secondary());
        MongoCollection<BsonDocument> col = db.getCollection("things",BsonDocument.class);
        BsonDocument bson = new BsonDocument("a",new BsonInt32(1)).append("a", new BsonInt32(2));
        System.out.println(bson);
//       Bson filter = and(eq("str","Rje"),eq("a",1));
       Bson projection = new Document("str",0).append("_id",0);
       Bson sort = new Document("a",1);
//        col.insertOne(bson);
        List <BsonDocument> find = col.find(bson).projection(projection).sort(sort).into(new ArrayList<BsonDocument>());
        for(BsonDocument a : find)
        System.out.println(a);
        long i = col.count();
        System.out.println(i);
        
    }
    
    public static void printJSON(Document document){
    	JsonWriter writer = new JsonWriter(new StringWriter(), new JsonWriterSettings(JsonMode.SHELL,true));
    	new DocumentCodec().encode(writer, document, EncoderContext.builder().isEncodingCollectibleDocument(true).build());
    	System.out.println(writer.getWriter());
    	System.out.flush();
    }
}
