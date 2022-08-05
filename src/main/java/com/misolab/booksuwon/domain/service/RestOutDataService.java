package com.misolab.booksuwon.domain.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.misolab.booksuwon.domain.vo.LoginParam;
import com.misolab.booksuwon.domain.vo.LoginResult;
import com.misolab.booksuwon.domain.vo.RentalListParam;
import com.misolab.booksuwon.domain.vo.RentalListResult;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
public class RestOutDataService implements OutDataService {

    final RestTemplate restTemplate;

    final String Host = "https://www.suwonlib.go.kr:8443";
    final private String LoginUrl = Host + "/api/user/login";

    final private String RentalListUrl = Host + "/api/kolas/loan/state?page=%d&display=%d&sortType=%d";

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
    public RentalListResult rentalList(String token, RentalListParam param) throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("x-access-token", token);

        HttpEntity<String> request = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(param.toUrl(RentalListUrl), HttpMethod.GET, request, String.class);
        String body = response.getBody();
        RentalListResult result = mapper.readValue(body, RentalListResult.class);
        return result;

    }

    @Override
    public void readedList() {

    }
}
