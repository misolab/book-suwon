package com.misolab.booksuwon.domain.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.misolab.booksuwon.domain.vo.*;
import org.springframework.stereotype.Service;

@Service
public interface OutDataService {

    LoginResult login(LoginParam loginParam) throws JsonProcessingException;

    ApplyListResult rental(String token, RentalParam param) throws JsonProcessingException;

    ApplyListResult hitory(String token, HistoryParam param) throws JsonProcessingException;
}
