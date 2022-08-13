package com.misolab.booksuwon.domain.vo;

import lombok.Data;

@Data
public class Apply {

    public String libCode;
    public String regNo;
    public String loanType;
    public String callNo;
    public String isbn;
    public String title;
    public String appendixFlag;
    public String coverYn;
    public String returnPlanDate;
    public String manageCode;
    public String price;
    public String loanKey;
    public String workingStatus;
    public String appendixLoanIncludeYn;
    public Integer overdueDate;
    public String author;
    public String libName;
    public String returnDelayUseYn;
    public String userName;
    public String bookKey;
    public String haveBookLibName;
    public String coverUrl;
    public String pubFormCode;
    public String pubYear;
    public String placeRemark;
    public String publisher;
    public String loanDate;
    public String page;
    public String speciesKey;
    public String status;

    //  for history
    public String returnDate;
    public String reqRejectCause;
    public String remainDate;
    public String sendRejectCause;
    public String volTitle;
}