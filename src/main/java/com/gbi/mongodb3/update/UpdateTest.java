package com.gbi.mongodb3.update;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class UpdateTest {

	private static void updateTest1 () {
		MongoClient client = new MongoClient("127.0.0.1", 27017);
		MongoDatabase db = client.getDatabase("test");
		MongoCollection<Document> collection =  db.getCollection("Test_table1");
		
		Document query = new Document();
		query.put("_id", 1);
		Document change = new Document();
		change.put("name", "赵敏");
		change.put("age", 16);
		Document update = new Document();
		update.put("$set", change);
		
		collection.updateOne(query, update);
		client.close();
	}
	
	public static void main(String[] args) {
		updateTest1();
	}
}
