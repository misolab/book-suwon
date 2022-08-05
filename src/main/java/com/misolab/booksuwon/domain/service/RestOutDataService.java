package com.misolab.booksuwon.domain.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.misolab.booksuwon.domain.vo.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
public class RestOutDataService implements OutDataService {

    final RestTemplate restTemplate;

    final String Host = "https://www.suwonlib.go.kr:8443";
    final private String LoginUrl = Host + "/api/user/login";

    final private String RentalListUrl = Host + "/api/kolas/loan/state?page=%d&display=%d&sortType=%d";

    final private String HistoryUrl = Host + "/api/kolas/loan/history?page=%d&display=%d&sortType=%d&manageCode=%s&searchType=%d&searchKeyword=%s";

    ObjectMapper mapper = new ObjectMapper();

    @Override
    public LoginResult login(LoginParam param) throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String payload = mapper.writeValueAsString(param);
        HttpEntity<String> request = new HttpEntity<>(payload, headers);

        ResponseEntity<String> response = restTemplate.exchange(LoginUrl, HttpMethod.POST, request, String.class);
        String body = response.getBody();
        LoginResult result = mapper.readValue(body, LoginResult.class);
        return result;
    }

    @Override
    public ApplyListResult rental(String token, RentalParam param) throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("x-access-token", token);

        HttpEntity<String> request = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(param.toUrl(RentalListUrl), HttpMethod.GET, request, String.class);
        String body = response.getBody();
        ApplyListResult result = mapper.readValue(body, ApplyListResult.class);
        return result;

    }

    @Override
    public ApplyListResult hitory(String token, HistoryParam param) throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("x-access-token", token);

        HttpEntity<String> request = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(param.toUrl(HistoryUrl), HttpMethod.GET, request, String.class);
        String body = response.getBody();
        ApplyListResult result = mapper.readValue(body, ApplyListResult.class);
        return result;
    }
}
