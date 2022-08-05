package com.misolab.booksuwon.domain.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.misolab.booksuwon.domain.vo.LoginParam;
import com.misolab.booksuwon.domain.vo.LoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
public class RestOutDataService implements OutDataService {

    final RestTemplate restTemplate;
    final private String LoginUrl = "https://www.suwonlib.go.kr:8443/api/user/login";

    ObjectMapper mapper = new ObjectMapper();

    @Override
    public LoginResponse login(LoginParam loginParam) throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String payload = mapper.writeValueAsString(loginParam);
        HttpEntity<String> request = new HttpEntity<>(payload, headers);

        ResponseEntity<String> response = restTemplate.exchange(LoginUrl, HttpMethod.POST, request, String.class);
        String body = response.getBody();
        LoginResponse result = mapper.readValue(body, LoginResponse.class);
        return result;
    }

    @Override
    public void loanList() {

    }

    @Override
    public void readedList() {

    }
}
