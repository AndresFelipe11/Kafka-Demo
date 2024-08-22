package co.com.bancolombia.model.gateways;

import co.com.bancolombia.model.Cuenta;
import reactor.core.publisher.Mono;

public interface CuentaRepository {

//    Mono<String> getSaldoNube(Cuenta cuenta);

    Mono<Cuenta> saveSaldoNube(Cuenta cuenta);

}
