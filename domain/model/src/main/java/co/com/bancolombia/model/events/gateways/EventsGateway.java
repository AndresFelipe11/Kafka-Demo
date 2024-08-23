package co.com.bancolombia.model.events.gateways;

import co.com.bancolombia.model.operation.Operation;
import reactor.core.publisher.Mono;


public interface EventsGateway {
//    Mono<Void> emit(Object event);

    Mono<Void> event(Operation operation);

    public Mono<Operation> cloudEvent(Operation operation);
}
