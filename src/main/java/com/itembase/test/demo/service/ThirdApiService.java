package com.itembase.test.demo.service;

public interface ThirdApiService {
    String getRandomApiUrl();

    String getFallbackApiUrl(String url);
}
