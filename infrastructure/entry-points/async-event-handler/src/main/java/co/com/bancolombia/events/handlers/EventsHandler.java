package co.com.bancolombia.events.handlers;

import co.com.bancolombia.model.operation.Operation;
import io.cloudevents.CloudEvent;
import lombok.AllArgsConstructor;
import org.reactivecommons.api.domain.DomainEvent;
import org.reactivecommons.async.kafka.annotations.EnableEventListeners;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@EnableEventListeners
public class EventsHandler {
//    private final SampleUseCase sampleUseCase;

    public Mono<Void> handleEventA(DomainEvent<Operation> event) {
        System.out.println("event received: " + event + " ->" + event.getData());
//        return sampleUseCase.doSomething(event.getData());
        return Mono.empty();
    }
}
