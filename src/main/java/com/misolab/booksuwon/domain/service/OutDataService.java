package com.misolab.booksuwon.domain.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.misolab.booksuwon.domain.vo.LoginParam;
import com.misolab.booksuwon.domain.vo.LoginResponse;
import org.springframework.stereotype.Service;

@Service
public interface OutDataService {

    LoginResponse login(LoginParam loginParam) throws JsonProcessingException;
    void loanList();
    void readedList();
}
