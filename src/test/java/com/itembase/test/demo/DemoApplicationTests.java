package com.itembase.test.demo;

import com.itembase.test.demo.model.ConversionRequest;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
class DemoApplicationTests {

	@Test
	void responseCodeOkTest() {
		ConversionRequest conversionRequest = new ConversionRequest("USD","EUR", 10d);
		WebTestClient
				.bindToServer()
				.baseUrl("http://localhost:8080")
				.build()
				.post()
				.uri("/currency/convert")
				.body(Mono.just(conversionRequest), ConversionRequest.class)
				.exchange()
				.expectStatus().isOk()
				.expectHeader().valueEquals("Content-Type", "application/json");
	}

	@Test
	void responseCodeBadRequestTest() {
		ConversionRequest conversionRequest = new ConversionRequest("USD","test", 10d);
		WebTestClient
				.bindToServer()
				.baseUrl("http://localhost:8080")
				.build()
				.post()
				.uri("/currency/convert")
				.body(Mono.just(conversionRequest), ConversionRequest.class)
				.exchange()
				.expectStatus().isBadRequest()
				.expectHeader().valueEquals("Content-Type", "application/json");
	}

	@Test
	void responseCodeInternalErrorTest() {
		ConversionRequest conversionRequest = new ConversionRequest("USD","abc", 10d);
		WebTestClient
				.bindToServer()
				.baseUrl("http://localhost:8080")
				.build()
				.post()
				.uri("/currency/convert")
				.body(Mono.just(conversionRequest), ConversionRequest.class)
				.exchange()
				.expectStatus().is5xxServerError()
				.expectHeader().valueEquals("Content-Type", "application/json");
	}

}
