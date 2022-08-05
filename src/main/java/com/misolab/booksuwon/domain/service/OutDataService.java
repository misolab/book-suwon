package com.misolab.booksuwon.domain.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.misolab.booksuwon.common.util.StringUtils;
import com.misolab.booksuwon.domain.vo.*;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

@Service
public interface OutDataService {

    final String Host = "https://www.suwonlib.go.kr:8443";
    final String LoginUrl = Host + "/api/user/login";
    final String RentalListUrl = Host + "/api/kolas/loan/state?page=%d&display=%d&sortType=%d";
    final String HistoryUrl = Host + "/api/kolas/loan/history?page=%d&display=%d&sortType=%d&manageCode=%s&searchType=%d&searchKeyword=%s";


    LoginResult login(LoginParam loginParam) throws JsonProcessingException;

    ApplyListResult rental(String token, RentalParam param) throws JsonProcessingException;

    ApplyListResult hitory(String token, HistoryParam param) throws JsonProcessingException;

    ObjectMapper mapper = new ObjectMapper();

    default HttpEntity<String> getRequest(String token, Object param) throws JsonProcessingException {
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
}
