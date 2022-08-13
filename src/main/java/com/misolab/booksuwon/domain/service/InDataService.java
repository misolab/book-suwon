package com.misolab.booksuwon.domain.service;

import com.misolab.booksuwon.domain.entity.User;
import com.misolab.booksuwon.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class InDataService {

    final UserRepository userRepository;

    public Long saveUserInfo(String userId, String userToken, String userNo, String userName) {
        User user = userRepository.findByUserId(userId).orElse(User.builder().userId(userId).build());
        user.setInfo(userToken, userNo, userName);
        userRepository.save(user);
        return user.getId();
    }

    public User getUser(String userId) {
        return userRepository.findByUserId(userId).orElseThrow(() -> new NullPointerException(userId));
    }
}
