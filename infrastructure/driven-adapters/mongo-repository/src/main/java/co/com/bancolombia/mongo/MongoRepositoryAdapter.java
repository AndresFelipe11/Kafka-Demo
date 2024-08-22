package co.com.bancolombia.mongo;



import co.com.bancolombia.model.account.Account;
import co.com.bancolombia.model.account.gateways.AccountRepository;
import co.com.bancolombia.model.operation.Operation;

import com.google.gson.Gson;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import lombok.RequiredArgsConstructor;
import org.bson.Document;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class MongoRepositoryAdapter implements AccountRepository {

    private final MongoDBRepository repository;
    @Override
    public String save(Operation operation) {
        MongoClient client = MongoClients.create("mongodb+srv://SaldosNube:saldosnube123@saldosnube.0ikki7x.mongodb.net/?retryWrites=true&w=majority&appName=SaldosNube");
        MongoDatabase db = client.getDatabase("SaldosNube");

        Document findUser = db.getCollection("cuenta").find(new Document("accountNumber", operation.getAccountSource())).first();

        Document findUserDestination = db.getCollection("cuenta").find(new Document("accountNumber", operation.getAccountDestination())).first();

        try{

            if(findUser != null && operation.getTransactionType().equalsIgnoreCase("deposit")){
                Account modifiedAccount = new Account();
                modifiedAccount.setAmount(operation.getAmount() + findUser.getDouble("amount"));
                db.getCollection("cuenta").updateOne(findUser, new Document("$set", new Document("amount", modifiedAccount.getAmount())));
                return "The account has been updated";
            }
            else if (findUser != null && operation.getTransactionType().equalsIgnoreCase("withdraw")){
                Account modifiedAccount = new Account();
                modifiedAccount.setAmount(findUser.getDouble("amount") - operation.getAmount());
                db.getCollection("cuenta").updateOne(findUser, new Document("$set", new Document("amount", modifiedAccount.getAmount())));
                return "The account has been updated";
            }
            else if (findUser != null && findUserDestination != null && operation.getTransactionType().equalsIgnoreCase("transfer")){
                Account modifiedAccountSource = new Account();
                Account modifiedAccountDestination = new Account();
                modifiedAccountSource.setAmount(findUser.getDouble("amount") - operation.getAmount());
                modifiedAccountDestination.setAmount(findUser.getDouble("amount") + operation.getAmount());
                db.getCollection("cuenta").updateOne(findUser, new Document("$set", new Document("amount", modifiedAccountSource.getAmount())));
                db.getCollection("cuenta").updateOne(findUserDestination, new Document("$set", new Document("amount", modifiedAccountDestination.getAmount())));
                return "The account has been updated";
            }
            else{
                Account account = new Account();
                account.setAccountNumber(operation.getAccountSource());
                account.setAmount(operation.getAmount());
                account.setAccountType("saves");
                Gson gson = new Gson();
                String json = gson.toJson(account);
                Document document = Document.parse(json);
                db.getCollection("cuenta").insertOne(document);
                return "The account has been created";
            }
        }
        catch(Exception e){
            System.out.println("Exception: " + e);
        }
        return "Error in the transaction";
    }
}
