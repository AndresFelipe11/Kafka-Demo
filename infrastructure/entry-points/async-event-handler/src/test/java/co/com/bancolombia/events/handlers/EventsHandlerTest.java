package co.com.bancolombia.events.handlers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.reactivecommons.api.domain.DomainEvent;
import reactor.test.StepVerifier;

import java.util.UUID;

public class EventsHandlerTest {

    EventsHandler eventsHandler;

    @BeforeEach
    void setUp() {
        eventsHandler = new EventsHandler();
    }



}
