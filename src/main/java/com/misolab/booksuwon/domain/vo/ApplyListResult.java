package com.misolab.booksuwon.domain.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ApplyListResult {

    private Result result;

    @JsonProperty("contents")
    private ApplyListContents contents;
}
