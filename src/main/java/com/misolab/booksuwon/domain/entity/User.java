package com.misolab.booksuwon.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "TBL_USER")
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(length = 1024)
    private String userToken;

    @Column(length = 16)
    private String userNo;

    @Column(length = 80, unique = true, nullable = false)
    private String userId;

    @Column(length = 80)
    private String userName;

    @Builder
    User(String userToken, String userNo, String userId, String userName) {
        this.userId = userId;
        setInfo(userToken, userNo, userName);
    }

    public User setInfo(String userToken, String userNo, String userName) {
        this.userToken = userToken;
        this.userNo = userNo;
        this.userName = userName;
        return this;
    }
}
