package com.misolab.booksuwon.domain.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.misolab.booksuwon.domain.vo.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
public class RestOutDataService implements OutDataService {

    final RestTemplate restTemplate;

    private String getResponseBody(String url, HttpMethod method, HttpEntity<String> request) {
        ResponseEntity<String> response = restTemplate.exchange(url, method, request, String.class);
        return response.getBody();
    }

    @Override
    public LoginResult login(LoginParam param) throws JsonProcessingException {
        HttpEntity<String> request = getRequest(null, param);

        String body = getResponseBody(LoginUrl, HttpMethod.POST, request);
        LoginResult result = mapper.readValue(body, LoginResult.class);
        return result;
    }

    @Override
    public ApplyListResult rental(String token, RentalParam param) throws JsonProcessingException {
        HttpEntity<String> request = getRequest(token, param);

        String body = getResponseBody(param.toUrl(RentalListUrl), HttpMethod.GET, request);
        ApplyListResult result = mapper.readValue(body, ApplyListResult.class);
        return result;
    }

    @Override
    public ApplyListResult hitory(String token, HistoryParam param) throws JsonProcessingException {
        HttpEntity<String> request = getRequest(token, param);

        String body = getResponseBody(param.toUrl(HistoryUrl), HttpMethod.GET, request);
        ApplyListResult result = mapper.readValue(body, ApplyListResult.class);
        return result;
    }
}
