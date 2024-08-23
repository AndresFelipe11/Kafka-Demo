package co.com.bancolombia.usecase.productor;

import co.com.bancolombia.model.events.gateways.EventsGateway;
import co.com.bancolombia.model.operation.Operation;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ProductorUseCase {

    private final EventsGateway eventsGateway;

//    public Mono<DomainEvent<String>> sendEvent(Operation operation){
//       return eventsGateway.event(operation);
//    }

    public Mono<Operation> sendCloudEvent(Operation operation){
        return eventsGateway.cloudEvent(operation);
    }

}
