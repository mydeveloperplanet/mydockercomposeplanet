package com.mydeveloperplanet.mydockercomposeplanet.handlers;

import com.mydeveloperplanet.mydockercomposeplanet.domain.Show;
import com.mydeveloperplanet.mydockercomposeplanet.repositories.ReactiveShowRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * The handler for Show objects
 */
@Component
public class ShowHandler {

    private final ReactiveShowRepository showRepository;

    public ShowHandler(ReactiveShowRepository showRepository) {
        this.showRepository = showRepository;
    }

    public Mono<ServerResponse> byId(ServerRequest serverRequest) {
        String id = serverRequest.pathVariable("id");
        Mono<Show> show = this.showRepository.findById(id);
        return ServerResponse.ok().body(show, Show.class);
    }

    public Mono<ServerResponse> all(ServerRequest serverRequest) {
        Flux<Show> shows = this.showRepository.findAll();
        return ServerResponse.ok().body(shows, Show.class);
    }
}
