package com.misolab.booksuwon.domain.service;

import com.misolab.booksuwon.domain.entity.Review;
import com.misolab.booksuwon.domain.entity.User;
import com.misolab.booksuwon.domain.repository.ReviewRepository;
import com.misolab.booksuwon.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class InDataService {

    final UserRepository userRepository;
    final ReviewRepository reviewRepository;

    public Long saveUserInfo(String userId, String userToken, String userNo, String userName) {
        User user = userRepository.findByUserId(userId).orElse(User.builder().userId(userId).build());
        user.setInfo(userToken, userNo, userName);
        userRepository.save(user);
        return user.getId();
    }

    public User getUser(String userId) {
        return userRepository.findByUserId(userId).orElseThrow(() -> new NullPointerException(userId));
    }

    public void addReview(Review review) {
        reviewRepository.save(review);
    }

    public void updateReview(Review review) {
        //  todo: 조회 후 업데이트
    }

    public List<Review> getReview() {
        return reviewRepository.findAllByOrderByIdDesc();
    }
}
