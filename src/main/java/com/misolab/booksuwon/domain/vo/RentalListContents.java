package com.misolab.booksuwon.domain.vo;

import lombok.Data;

import java.util.List;

@Data
public class RentalListContents {

    public Integer totalPage;
    public List<Apply> applyList = null;
    public Integer totalCount;
}
