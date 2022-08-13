package com.misolab.booksuwon.domain.repository;

import com.misolab.booksuwon.domain.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByWriterId(String writerId);
    List<Review> findAllByOrderByIdDesc();
}
