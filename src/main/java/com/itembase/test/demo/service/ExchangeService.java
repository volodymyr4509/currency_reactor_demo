package com.itembase.test.demo.service;

import com.itembase.test.demo.model.ConversionRequest;
import com.itembase.test.demo.model.ConversionResponse;
import reactor.core.publisher.Mono;

public interface ExchangeService {
    Mono<ConversionResponse> exchange(ConversionRequest request);
}
