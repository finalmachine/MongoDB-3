package com.gbi.mongodb3.connect;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class ConnectTest {
	
	private static void connectDatabaseTest(String addr, int port, String databaseName) {
		// 创建MongoDB(DBMS)客户端对象 此时并没有连接DBMS 
		MongoClient mongoClient = new MongoClient(addr, port);
		// 使用另一个线程连接了database 该方法不是同步的，如果连接超时另一个线程会抛出异常
		MongoDatabase db = mongoClient.getDatabase(databaseName);
		// 构造需要执行的命令
		Document command = new Document();
		command.put("ping", 1);
		// 执行该命令 需要增加一条连接
		Document result = db.runCommand(command);
		// 如果不报错 证明连接成功了 但是如果不存在database 也不会被创建
		System.out.println(result);
		System.out.println("connect");
		mongoClient.close();
	}
	
	public static void main(String[] args) {
		connectDatabaseTest("127.0.0.1", 27017, "test");
	}
}
