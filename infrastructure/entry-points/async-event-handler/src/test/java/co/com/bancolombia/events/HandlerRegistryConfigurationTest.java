package co.com.bancolombia.events;

import co.com.bancolombia.events.handlers.EventsHandler;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class HandlerRegistryConfigurationTest {

    EventsHandler eventsHandler;
    CommandsHandler commandsHandler;
    QueriesHandler queriesHandler;

    @BeforeEach
    void setUp() {
        eventsHandler = new EventsHandler();
        commandsHandler = new CommandsHandler();
        queriesHandler = new QueriesHandler();

    }

//    @Test
//    void testHandlerRegistry() {
//        HandlerRegistryConfiguration handlerRegistryConfiguration = new HandlerRegistryConfiguration();
//        HandlerRegistry handlerRegistry = handlerRegistryConfiguration.handlerRegistry(commandsHandler, eventsHandler, queriesHandler);
//
//        assertNotNull(handlerRegistry);
//
//    }
}
