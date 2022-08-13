package com.misolab.booksuwon.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "TBL_REVIEW")
public class Review extends BaseTimeEntity {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    // writer(user) info
    @Column(length = 80)
    String writerId; // User.userId

    @Column(length = 80)
    String writerName; // User.userName

    @Lob
    @Column(columnDefinition = "TEXT")
    String content;

    // book info
    @Column(length = 80, nullable = false)
    String author;

    @Column(length = 100, nullable = false)
    String title;

    @Column(length = 80, nullable = false)
    String publisher;

    @Column(length = 80)
    String coverUrl;

    @Column(length = 20)
    String callNo;

    @Column(length = 40)
    String libName;

    @Column(length = 20)
    String libCode;

    public Review setWriteInfo(String userId, String userName, String content) {
        this.writerId = userId;
        this.writerName = userName;
        this.content = content;
        return this;
    }

    public Review setBookInfo(String author, String title, String publisher, String coverUrl) {
        this.author = author;
        this.title = title;
        this.publisher = publisher;
        this.coverUrl = coverUrl;
        return this;
    }

    public Review setLibraryInfo(String callNo, String libName, String libCode) {
        this.callNo = callNo;
        this.libName = libName;
        this.libCode = libCode;
        return this;
    }
}
