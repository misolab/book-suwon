package com.misolab.booksuwon.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TBL_COMMENET", indexes = { 
    @Index(name = "idx_comment_review_id", columnList = "reviewId"), 
    @Index(name = "idx_comment_writer_id", columnList = "writerId"), 
})
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    Long reviewId;

    // writer(user) info
    @Column(length = 80)
    String writerId; // User.userId

    @Column(length = 80)
    String writerName; // User.userName

    @Column(length = 1024)
    String comment;

}
