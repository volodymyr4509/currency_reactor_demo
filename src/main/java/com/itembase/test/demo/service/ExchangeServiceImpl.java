package com.itembase.test.demo.service;

import com.itembase.test.demo.repo.ExchangeRepository;
import com.itembase.test.demo.model.ConversionRequest;
import com.itembase.test.demo.model.ConversionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ExchangeServiceImpl implements ExchangeService {

    @Autowired
    private ExchangeRepository exchangeRepository;

    @Override
    public Mono<ConversionResponse> exchange(ConversionRequest request) {
        return exchangeRepository.getRates(request.getFrom())
                .map(currencyRates -> currencyRates.getRates().get(request.getTo()))
                .map(rate -> {
                    double converted = request.getAmount() * rate;
                    return new ConversionResponse(request.getFrom(), request.getTo(), request.getAmount(), converted);
                });
    }

}
