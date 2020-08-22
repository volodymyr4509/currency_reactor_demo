package com.itembase.test.demo.repo;

import com.itembase.test.demo.api.CurrencyRates;
import com.itembase.test.demo.service.ThirdApiServiceImpl;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Repository
public class ExchangeRepositoryImpl implements ExchangeRepository {

    private WebClient webClient;
    private ThirdApiServiceImpl thirdApiService;

    public ExchangeRepositoryImpl(WebClient webClient, ThirdApiServiceImpl thirdApiService) {
        this.webClient = webClient;
        this.thirdApiService = thirdApiService;
    }

    @Override
    public Mono<CurrencyRates> getRates(String currency) {
        String randomApiUrl = thirdApiService.getRandomApiUrl();

        return webClient.get()
                .uri(randomApiUrl + currency)
                .retrieve()
                .bodyToMono(CurrencyRates.class)
                .onErrorResume(e ->
                        webClient.get()
                                .uri(thirdApiService.getFallbackApiUrl(randomApiUrl) + currency)
                                .retrieve()
                                .bodyToMono(CurrencyRates.class)
                                .onErrorResume(error -> Mono.error(new RuntimeException("Can't get currency rates" + error.getMessage()))));
    }

}
