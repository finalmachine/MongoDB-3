package com.gbi.mongodb3.insert;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class InsertTest {
	
	private static void insertTest1(Document obj) {
		MongoClient client = new MongoClient("127.0.0.1", 27017);
		MongoDatabase db = client.getDatabase("test");
		MongoCollection<Document> collection =  db.getCollection("Test_table1");
		
		collection.insertOne(obj);
		client.close();
	}
	
	public static void main(String[] args) {
		Document demo1 = new Document();
		
		demo1.put("_id", 6);
		demo1.put("age", 21);
		demo1.put("gender", "female");
		demo1.put("name", "周芷若");
		
		insertTest1(demo1);
	}
}
