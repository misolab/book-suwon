package com.misolab.booksuwon.domain.vo;

import lombok.Data;

@Data
public class HistoryParam extends RentalParam {

    String manageCode = "ALL";
    int searchType = 0;
    String searchKeyword = "";

    @Override
    public String toUrl(String src) {
        return String.format(src, page, display, sortType, manageCode, searchType, searchKeyword);
    }
}
