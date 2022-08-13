package com.misolab.booksuwon.app.controller.dto;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class ReviewParam {
    String content;
    String author;
    String title;
    String publisher;
    String callNo;
    String libName;
    String libCode;
}