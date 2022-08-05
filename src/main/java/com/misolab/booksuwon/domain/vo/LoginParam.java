package com.misolab.booksuwon.domain.vo;

import lombok.Data;

@Data
public class LoginParam {

    String userId;
    String userPw;
    String encYn = "N";

    public LoginParam(String userId, String userPw) {
        this.userId = userId;
        this.userPw = userPw;
    }
}
