//package co.com.bancolombia.events;
//
//import lombok.AllArgsConstructor;
//import lombok.extern.java.Log;
//import org.reactivecommons.api.domain.Command;
//import org.reactivecommons.async.api.AsyncQuery;
//import org.reactivecommons.async.api.DirectAsyncGateway;
//import org.reactivecommons.async.impl.config.annotations.EnableDirectAsyncGateway;
//import reactor.core.publisher.Mono;
//
//import java.util.UUID;
//import java.util.logging.Level;
//
//@Log
//@AllArgsConstructor
//@EnableDirectAsyncGateway
//public class ReactiveDirectAsyncGateway /* implements Gateway from domain */ {
//    public static final String TARGET_NAME = "cleanArchitecture";// refers to remote spring.application.name property
//    public static final String SOME_COMMAND_NAME = "some.command.name";
//    public static final String SOME_QUERY_NAME = "some.query.name";
//    private final DirectAsyncGateway gateway;
//
//
//    public Mono<Void> runRemoteJob(Object command/*change for proper model*/)  {
//        log.log(Level.INFO, "Sending command: {0}: {1}", new String[]{SOME_COMMAND_NAME, command.toString()});
//        return gateway.sendCommand(new Command<>(SOME_COMMAND_NAME, UUID.randomUUID().toString(), command),
//                        TARGET_NAME);
//    }
//
//    public Mono<Object> requestForRemoteData(Object query/*change for proper model*/)  {
//        log.log(Level.INFO, "Sending query request: {0}: {1}", new String[]{SOME_QUERY_NAME, query.toString()});
//        return gateway.requestReply(new AsyncQuery<>(SOME_QUERY_NAME, query), TARGET_NAME, Object.class/*change for proper model*/);
//    }
//}
