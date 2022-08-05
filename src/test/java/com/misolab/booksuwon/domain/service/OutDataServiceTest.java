package com.misolab.booksuwon.domain.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.misolab.booksuwon.domain.vo.*;
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
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiJkZGtrZmoiLCJ1c2VyTmFtZSI6IuuPhOyYpe2YhCIsInVzZXJObyI6IjAyNTAxMzk3MSIsImxpYkNvZGUiOiIxNDEwMjQiLCJsaWJOYW1lIjoi7KSR7JWZIiwibG9hbkhpc3RvcnlZbiI6IlkiLCJjaCI6IkZDQzQ0NEQxQkNDNzU2RkY2REE0Qjk5ODFFNzA2M0FCREU2Q0M5Qjg4MzFDOTIyNkE3MzM4NUJCQ0YxRTA1MEYiLCJ1c2VyU3RhdHVzIjoi7KCV7IOBIiwibG9hblN0b3BFbmREYXRlIjoiIiwibG9hbkNvdW50IjoiMSIsInJlc2VydmF0aW9uQ291bnQiOiIyIiwib3ZlcmR1ZUNvdW50IjoiMCIsImNvbW1lbnQiOiLrjIDstpzqsIDriqUg7ZqM7JuQIOyeheuLiOuLpC4iLCJjaSI6Imh1U01hazhMbzhlZTB0RGV3ZlJFNW92Tjh3dEt5R0JQRnhkbFdMaUxCUHpGVjJVWXRjMXJHVVRONnBwQnZrakxVV3hJRUJ3ZDdLQXJuL1gyTTg2TXdnPT0iLCJiaXJ0aGRheSI6IjE5NzguMDIuMDgiLCJzZXgiOiIwIiwiaWF0IjoxNjU5NzM1NTc3LCJleHAiOjE2NTk3NzE1NzcsImlzcyI6ImFscGFzcSIsInN1YiI6InVzZXJJbmZvIn0.hAheFQ2mE3z-TUlV4UB1VYFWWh9Y9PnITePPJ4G75tE";

        ApplyListResult result = outDataService.rental(token, new RentalParam());

        if (token.equals("")) {
            assertThat(result.getResult().getCode()).isEqualTo("N");
        } else {
            log.debug("{}", result.getContents().totalCount);
            result.getContents().applyList.forEach(a -> log.debug("{}", a));
            assertThat(result.getResult().getCode()).isEqualTo("Y");
        }
    }

    @Test
    void test_history() throws JsonProcessingException {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiJkZGtrZmoiLCJ1c2VyTmFtZSI6IuuPhOyYpe2YhCIsInVzZXJObyI6IjAyNTAxMzk3MSIsImxpYkNvZGUiOiIxNDEwMjQiLCJsaWJOYW1lIjoi7KSR7JWZIiwibG9hbkhpc3RvcnlZbiI6IlkiLCJjaCI6IkZDQzQ0NEQxQkNDNzU2RkY2REE0Qjk5ODFFNzA2M0FCREU2Q0M5Qjg4MzFDOTIyNkE3MzM4NUJCQ0YxRTA1MEYiLCJ1c2VyU3RhdHVzIjoi7KCV7IOBIiwibG9hblN0b3BFbmREYXRlIjoiIiwibG9hbkNvdW50IjoiMSIsInJlc2VydmF0aW9uQ291bnQiOiIyIiwib3ZlcmR1ZUNvdW50IjoiMCIsImNvbW1lbnQiOiLrjIDstpzqsIDriqUg7ZqM7JuQIOyeheuLiOuLpC4iLCJjaSI6Imh1U01hazhMbzhlZTB0RGV3ZlJFNW92Tjh3dEt5R0JQRnhkbFdMaUxCUHpGVjJVWXRjMXJHVVRONnBwQnZrakxVV3hJRUJ3ZDdLQXJuL1gyTTg2TXdnPT0iLCJiaXJ0aGRheSI6IjE5NzguMDIuMDgiLCJzZXgiOiIwIiwiaWF0IjoxNjU5NzM1NTc3LCJleHAiOjE2NTk3NzE1NzcsImlzcyI6ImFscGFzcSIsInN1YiI6InVzZXJJbmZvIn0.hAheFQ2mE3z-TUlV4UB1VYFWWh9Y9PnITePPJ4G75tE";

        ApplyListResult result = outDataService.hitory(token, new HistoryParam());

        if (token.equals("")) {
            assertThat(result.getResult().getCode()).isEqualTo("N");
        } else {
            log.debug("{}", result.getContents().totalCount);
            result.getContents().applyList.forEach(a -> log.debug("{}", a));
            assertThat(result.getResult().getCode()).isEqualTo("Y");
        }
    }
}