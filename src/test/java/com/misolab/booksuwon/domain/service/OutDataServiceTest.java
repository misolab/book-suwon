package com.misolab.booksuwon.domain.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.misolab.booksuwon.domain.vo.LoginParam;
import com.misolab.booksuwon.domain.vo.LoginResult;
import com.misolab.booksuwon.domain.vo.RentalListParam;
import com.misolab.booksuwon.domain.vo.RentalListResult;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class OutDataServiceTest {

    OutDataService outDataService = new RestOutDataService(new RestTemplate());

    @Test
    void test_login() throws JsonProcessingException {

        String userId = "";
        String userPw = "";

        LoginResult result = outDataService.login(new LoginParam(userId, userPw));

        //  commit 을 위해  userId, userPw 공백 처리
        if (userId.equals("")) {
            assertThat(result.getResult().getCode()).isEqualTo("N");
        } else {
            log.debug("{}", result.getContents().getUserToken());
            assertThat(result.getResult().getCode()).isEqualTo("Y");
        }
    }

    @Test
    void test_rentalList() throws JsonProcessingException {
        String token = "";

        RentalListResult result = outDataService.rentalList(token, new RentalListParam());

        if (token.equals("")) {
            assertThat(result.getResult().getCode()).isEqualTo("N");
        } else {
            log.debug("{}", result.getContents().totalCount);
            result.getContents().applyList.forEach(a -> log.debug("{}", a));
            assertThat(result.getResult().getCode()).isEqualTo("Y");
        }
    }
}