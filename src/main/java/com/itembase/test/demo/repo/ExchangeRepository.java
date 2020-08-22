package com.itembase.test.demo.repo;

import com.itembase.test.demo.api.CurrencyRates;
import reactor.core.publisher.Mono;

public interface ExchangeRepository {
    Mono<CurrencyRates> getRates(String currency);
}
