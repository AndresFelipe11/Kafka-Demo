package co.com.bancolombia.events.handlers;

import co.com.bancolombia.model.operation.Operation;
import co.com.bancolombia.usecase.operation.OperationUseCase;
import io.cloudevents.CloudEvent;
import lombok.AllArgsConstructor;
import org.reactivecommons.api.domain.DomainEvent;
import org.reactivecommons.async.kafka.annotations.EnableEventListeners;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@EnableEventListeners
public class EventsHandler {
//    private final SampleUseCase sampleUseCase;
    private final OperationUseCase operationUseCase;

    public Mono<Void> handleEventA(DomainEvent<Operation> event) {
        System.out.println("event received: " + event + " ->" + event.getData().getAmount());
        System.out.println(operationUseCase.saveSaldoNube(event.getData()));
        return Mono.empty();
    }
}
