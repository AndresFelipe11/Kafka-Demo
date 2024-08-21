package co.com.bancolombia.events;
import co.com.bancolombia.events.handlers.EventsHandler;
import co.com.bancolombia.model.operation.Operation;
import io.cloudevents.CloudEvent;
import org.reactivecommons.async.api.HandlerRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class HandlerRegistryConfiguration {




    @Bean
    public HandlerRegistry handlerRegistry(EventsHandler events) {
        return HandlerRegistry.register()
                .listenEvent("topic_test", events::handleEventA, Operation.class);

    }


}
