package com.example.demo.Config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Configuration
public class MongoDbConfig {
   public MongoTemplate createMongoTemplate (String uriString) throws URISyntaxException {
       MongoClient client = MongoClients.create(uriString);
       URI uri = new URI(uriString);
       String dbName = getDatabaseNameFromUri(uri);
       return new MongoTemplate(client, dbName);
   }
    private String getDatabaseNameFromUri(URI uri) {
        String path = uri.getPath();
        if (path.startsWith("/")) {
            return path.substring(1);
        }
        return path;
    }

}
