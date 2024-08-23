package co.com.bancolombia.api;

import co.com.bancolombia.model.operation.Operation;
import co.com.bancolombia.usecase.productor.ProductorUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class Handler {
private  final ProductorUseCase productorUseCase;
//private  final UseCase2 useCase2;

//    public Mono<ServerResponse> listenGETEventUseCase(ServerRequest serverRequest) {
//        return serverRequest.bodyToMono(Operation.class)
//                .switchIfEmpty(Mono.error(() -> new RuntimeException("Invalid Request")))
//                .flatMap(productorUseCase::sendEvent)
//                .doOnNext(body -> System.out.println(" cuenta " + body))
//                .then(ServerResponse.ok().bodyValue("{ \"estado\": \"Exito\" } { \"mensaje\": \"El evento se emitio con exito\" }"));
//
//    }

    public Mono<ServerResponse> listenGETCloudEventUseCase(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(Operation.class)
                .switchIfEmpty(Mono.error(() -> new RuntimeException("Invalid Request")))
                .flatMap(productorUseCase::sendCloudEvent)
                .doOnNext(body -> System.out.println(" cuenta " + body))
                .then(ServerResponse.ok().bodyValue("{ \"estado\": \"Exito\" } { \"mensaje\": \"El evento se emitio con exito\" }"));

    }

    public Mono<ServerResponse> listenPOSTUseCase(ServerRequest serverRequest) {
        // usecase.logic();
        return ServerResponse.ok().bodyValue("");
    }
}
