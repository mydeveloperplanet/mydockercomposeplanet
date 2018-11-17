package com.mydeveloperplanet.mydockercomposeplanet;

import com.mydeveloperplanet.mydockercomposeplanet.domain.ShowEvent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.FluxExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MyDockerComposeApplicationTests {

	@Autowired
	private WebTestClient webTestClient;

	@Test
	public void contextLoads() {
	}

	@Test
    public void testShowEvents() {
        FluxExchangeResult<ShowEvent> result = webTestClient
                .get().uri("/shows/2/events")
                .accept(MediaType.TEXT_EVENT_STREAM)
                .exchange()
                .expectStatus().isOk()
                .returnResult(ShowEvent.class);

        Flux<ShowEvent> eventFlux = result.getResponseBody();

        StepVerifier.create(eventFlux)
                .expectNextCount(10)
                .thenCancel()
                .verify();

    }

}
