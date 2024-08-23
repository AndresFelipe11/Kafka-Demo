package co.com.bancolombia.events;

import co.com.bancolombia.model.events.gateways.EventsGateway;
import co.com.bancolombia.model.operation.Operation;
import io.cloudevents.CloudEvent;
import io.cloudevents.core.builder.CloudEventBuilder;
import io.cloudevents.jackson.JsonCloudEventData;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.reactivecommons.api.domain.DomainEvent;
import org.reactivecommons.api.domain.DomainEventBus;
import org.reactivecommons.async.commons.converters.json.ObjectMapperSupplier;
import org.reactivecommons.async.kafka.annotations.EnableDomainEventBus;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.time.OffsetDateTime;
import java.util.UUID;

@Log
@RequiredArgsConstructor
@EnableDomainEventBus
public class ReactiveEventsGateway implements EventsGateway {
    public static final String SOME_EVENT_NAME = "some.event.name";
    private final DomainEventBus domainEventBus;
    private final ObjectMapperSupplier supplier;

//    @Override
//    public Mono<Void> emit(Object event) {
//        log.log(Level.INFO, "Sending domain event: {0}: {1}", new String[]{SOME_EVENT_NAME, event.toString()});
//         return from(domainEventBus.emit(new DomainEvent<>(SOME_EVENT_NAME, UUID.randomUUID().toString(), event)));
//    }

//    @Override
//    public Mono<DomainEvent<String>> event(Operation operation) {
//        DomainEvent<String> event = new DomainEvent<>("topic_test", UUID.randomUUID().toString(), "");
//        return Mono.from(domainEventBus.emit(event)).thenReturn(event);
//    }
    @Override
    public Mono<Operation> cloudEvent(Operation operation) {
        CloudEvent event = CloudEventBuilder.v1()
                .withId(UUID.randomUUID().toString())
                .withSource(URI.create("https://reactive-commons.org/foos"))
                .withType("ttest")
                .withTime(OffsetDateTime.now())
                .withData("application/json", JsonCloudEventData.wrap(supplier.get().valueToTree(operation)))
                .build();
//        return Mono.just(operation);
        return Mono.from(domainEventBus.emit(event)).thenReturn(operation);
    }

}
