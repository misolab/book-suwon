package com.misolab.booksuwon.domain.vo;

import lombok.Data;

@Data
public class LoginContents {

    private String userToken;
    private String userNo;
    private String userId;
    private String userName;
    private String loanHistoryYn;
    private String userStatus;
    private String loanStopEndDate;
    private Integer loanCount;
    private Integer reservationCount;
    private Integer overdueCount;
    private String comment;
    private String birthday;
    private String sex;
}