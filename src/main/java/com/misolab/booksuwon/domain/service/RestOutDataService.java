package com.misolab.booksuwon.domain.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.misolab.booksuwon.common.util.StringUtils;
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

    private HttpEntity<String> getRequest(String token, Object param) throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        if (StringUtils.isNotEmpty(token)) {
            headers.add("x-access-token", token);
        }

        HttpEntity<String> request;
        if (param != null) {
            String payload = mapper.writeValueAsString(param);
            request = new HttpEntity<>(payload, headers);
        } else {
            request = new HttpEntity<>(headers);
        }
        return request;
    }

    @Override
    public LoginResult login(LoginParam param) throws JsonProcessingException {
        HttpEntity<String> request = getRequest(null, param);

        String body = getResponseBody(LoginUrl, HttpMethod.POST, request);
        LoginResult result = mapper.readValue(body, LoginResult.class);
        return result;
    }

    private String getResponseBody(String url, HttpMethod method, HttpEntity<String> request) {
        ResponseEntity<String> response = restTemplate.exchange(url, method, request, String.class);
        return response.getBody();
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
