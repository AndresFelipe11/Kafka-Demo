package co.com.bancolombia.mongo.cuenta;

import co.com.bancolombia.model.Cuenta;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuentaCollection extends ReactiveMongoRepository<Cuenta, String>{


}
