package com.itembase.test.demo;

import com.itembase.test.demo.model.ConversionRequest;
import com.itembase.test.demo.model.ConversionResponse;
import com.itembase.test.demo.service.ExchangeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
public class ConversionController {

    @Autowired
    private ExchangeServiceImpl exchangeService;

    @PostMapping("/currency/convert")
    public Mono<ConversionResponse> exchange(@RequestBody @Valid ConversionRequest request) {
        return exchangeService.exchange(request);
    }
}
