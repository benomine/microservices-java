package org.benomine.rest.config;


import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

import java.util.Collection;
import java.util.Collections;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Value("${spring.data.mongodb.uri}")
    public String uri;

    @Value("${spring.data.mongodb.database}")
    public String database;

    @Override
    protected String getDatabaseName() {
        return database;
    }

    @Override
    public MongoClient mongoClient() {
        ConnectionString connectionString = new ConnectionString(uri+"/"+database);
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();

        return MongoClients.create(mongoClientSettings);
    }

    @Override
    public Collection<String> getMappingBasePackages() {
        return Collections.singleton("org.benomine");
    }
}
