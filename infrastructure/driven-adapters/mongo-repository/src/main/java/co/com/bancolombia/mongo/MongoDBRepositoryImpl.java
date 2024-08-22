package co.com.bancolombia.mongo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class MongoDBRepositoryImpl implements MongoDBRepository{
    @Override
    public MongoDatabase connectionFactory(String databaseName) {
        MongoClient client = new MongoClient("mongodb+srv://SaldosNube:saldosnube123@saldosnube.0ikki7x.mongodb.net/?retryWrites=true&w=majority&appName=SaldosNube");
        return client.getDatabase(databaseName);
    }
}
