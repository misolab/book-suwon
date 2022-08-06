package com.misolab.booksuwon.web.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SessionUser implements Serializable {

    private static final long serialVersionUID = 1L;

    Long id;
    String userId;
    String userToken;
    String userName;
}
