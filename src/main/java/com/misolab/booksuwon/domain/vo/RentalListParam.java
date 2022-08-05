package com.misolab.booksuwon.domain.vo;

import lombok.Data;

@Data
public class RentalListParam {

    int page = 1;
    int display = 10;
    int sortType = 0;

    public String toUrl(String src) {
        return String.format(src, page, display, sortType);
    }
}
