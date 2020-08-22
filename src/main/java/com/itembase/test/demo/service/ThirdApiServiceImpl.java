package com.itembase.test.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Random;

@Service
public class ThirdApiServiceImpl implements ThirdApiService {
    @Value("${ioApi}")
    private String ioUrl;

    @Value("${comApi}")
    private String comUrl;

    @Override
    public String getRandomApiUrl() {
        int i = new Random().nextInt(2);
        if (i == 1) {
            return ioUrl;
        } else {
            return comUrl;
        }
    }

    @Override
    public String getFallbackApiUrl(String url) {
        return Objects.equals(url, ioUrl) ? comUrl : ioUrl;
    }


}
