package co.com.bancolombia.mongo;

import com.mongodb.client.MongoDatabase;


public interface MongoDBRepository {
    MongoDatabase connectionFactory(String databaseName);

}
