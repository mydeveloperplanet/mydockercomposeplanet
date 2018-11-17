package com.mydeveloperplanet.mydockercomposeplanet.handlers;

import com.mydeveloperplanet.mydockercomposeplanet.domain.ShowEvent;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Date;

/**
 * The handler for ShowEvent objects
 */
@Component
public class ShowEventHandler {

    public Mono<ServerResponse> events(ServerRequest serverRequest) {
        String showId = serverRequest.pathVariable("id");
        Flux<ShowEvent> events = Flux.<ShowEvent>generate(sink -> sink.next(new ShowEvent(showId, new Date()))).delayElements(Duration.ofSeconds(1));
        return ServerResponse.ok().contentType(MediaType.TEXT_EVENT_STREAM).body(events, ShowEvent.class);
    }
}
