package com.misolab.booksuwon.domain.service;

import org.springframework.stereotype.Service;

import com.misolab.booksuwon.domain.entity.User;
import com.misolab.booksuwon.domain.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class InDataService {

    final UserRepository userRepository;

    public Long saveUserInfo(String userId, String userToken, String userNo, String userName) {
        User user = User.builder()
                .userId(userId).userToken(userToken).userNo(userNo).userName(userName)
                .build();
        userRepository.save(user);
        return user.getId();
    }

    public User getUser(String userId) {
        return userRepository.findByUserId(userId).orElseThrow(() -> new NullPointerException(userId));
    }
}
