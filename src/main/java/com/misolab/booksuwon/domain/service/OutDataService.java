package com.misolab.booksuwon.domain.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.misolab.booksuwon.domain.vo.LoginParam;
import com.misolab.booksuwon.domain.vo.LoginResult;
import com.misolab.booksuwon.domain.vo.RentalListParam;
import com.misolab.booksuwon.domain.vo.RentalListResult;
import org.springframework.stereotype.Service;

@Service
public interface OutDataService {

    LoginResult login(LoginParam loginParam) throws JsonProcessingException;
    RentalListResult rentalList(String token, RentalListParam param) throws JsonProcessingException;
    void readedList();
}
