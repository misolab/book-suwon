package com.misolab.booksuwon.app.controller.dto;

import com.misolab.booksuwon.domain.entity.Review;
import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class ReviewPostParam {
    String content;

    String author;
    String title;
    String publisher;
    String coverUrl;

    String callNo;
    String libName;
    String libCode;

    public Review toEntity(String writerId, String writerName) {
        Review review = new Review();
        review.setWriteInfo(writerId, writerName, content)
                .setBookInfo(author, title, publisher, coverUrl)
                .setLibraryInfo(callNo, libName, libCode);
        return review;
    }
}