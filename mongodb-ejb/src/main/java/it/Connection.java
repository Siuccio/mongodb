package it;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;


import javax.annotation.PostConstruct;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Singleton;

@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
public class Connection {


    private MongoClient client;
    private MongoDatabase mongoDatabase;

    @PostConstruct
    public void initialize() {
        MongoClientURI uri = new MongoClientURI("mongodb://localhost/testdb");
        client = new MongoClient(uri);
        mongoDatabase = client.getDatabase(uri.getDatabase());

    }

    public MongoDatabase getDB() {
        return mongoDatabase;
    }

}
