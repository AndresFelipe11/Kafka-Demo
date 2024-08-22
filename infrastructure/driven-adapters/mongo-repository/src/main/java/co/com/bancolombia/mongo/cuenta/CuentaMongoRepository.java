package co.com.bancolombia.mongo.cuenta;

import co.com.bancolombia.model.Cuenta;
import co.com.bancolombia.model.gateways.CuentaRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class CuentaMongoRepository implements CuentaRepository {

    private final CuentaCollection repository;


    @Override
    public Mono<Cuenta> saveSaldoNube(Cuenta cuenta) {
        return repository.save(cuenta);
    }
}
