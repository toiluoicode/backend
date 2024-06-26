package com.example.demo.Service;

import com.example.demo.Config.MongoDbConfig;
import com.example.demo.Models.Query;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.stereotype.Service;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

@Service
public class DatabaseService {
    @Autowired
    private MongoDbConfig mongoDbConfig;

    @Setter
    @Getter
    private MongoTemplate mongoTemplate;

    public void Connect (String uri){
        try {
            mongoTemplate = mongoDbConfig.createMongoTemplate(uri);
            System.out.println("Thành cong");
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Map> findAllDocuments(String collectionName) {
        return mongoTemplate.findAll(Map.class, collectionName);
    }

    public List<Map> excutequery(String query, String collectionName) {
        BasicQuery query1 = new BasicQuery(query);
        return mongoTemplate.find(query1,Map.class, collectionName);
    }
}
