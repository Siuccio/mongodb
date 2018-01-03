package it;




import com.mongodb.Block;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;

import javax.annotation.PostConstruct;
import javax.annotation.Priority;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

@Named("modelTest")
public class SongsService {


    @Inject
    private Connection connection;
    @PostConstruct
    public void init() {

    }

    public  List<Document> getSongs(){

        MongoCollection<Document> songs = connection.getDB().getCollection("songs");
        Document documents = songs.find().first();
        List<Document> docs = new ArrayList<>();
        songs.find().into(docs);
//        songs.find().forEach((Block<Document>) document -> {
//            System.out.println(document);
//        });.get("artist").toString();
        //documents

        return docs;

    }



}
