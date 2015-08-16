package com.gbi.mongodb3.find;

import org.bson.Document;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class FindTest {
	
	public static void findTest1() {
		// 连接数据库
		MongoClient client = new MongoClient("127.0.0.1", 27017);
		MongoDatabase db = client.getDatabase("TEST");
		
		MongoCollection<Document> collection =  db.getCollection("source");
		FindIterable<Document> resultSet = collection.find();
		resultSet.projection(new Document("_id", 1).append("name", 1));
		resultSet.forEach(new Block<Document>() {
			@Override
			public void apply(Document t) {
				System.out.println(t.toJson());
			}
		});
		client.close();
	}
	
	public static void findTest2() {
		MongoClient client = new MongoClient("127.0.0.1", 27017);
		MongoDatabase db = client.getDatabase("test");
		
		MongoCollection<Document> collection =  db.getCollection("Test_table1");
		
		Document filter = new Document();
		filter.put("_id", 1);
		
		FindIterable<Document> resultSet = collection.find(filter);
		MongoCursor<Document> iterator = resultSet.iterator();
		while (iterator.hasNext()) {
			Document obj = iterator.next();
			System.out.println(obj.get("_id"));
			System.out.println(obj.get("name"));
			System.out.println(obj.get("gender"));
			System.out.println(obj.get("age"));
		}
		
		client.close();
	}
	
	public static void main(String[] args) {
		findTest1();
	//	findTest2();
	}
}
