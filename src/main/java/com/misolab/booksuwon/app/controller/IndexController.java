package com.misolab.booksuwon.app.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.misolab.booksuwon.domain.entity.Comment;
import com.misolab.booksuwon.domain.entity.Review;
import com.misolab.booksuwon.domain.service.InDataService;
import com.misolab.booksuwon.web.util.LoginUser;
import com.misolab.booksuwon.web.vo.ApiResponse;
import com.misolab.booksuwon.web.vo.SessionUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/")
public class IndexController extends BaseController {

    final InDataService inDataService;

    final ObjectMapper objectMapper;

    @GetMapping
    public String index(Model model, @LoginUser SessionUser user) {
        log.info("user {}", user);

        List<Review> reviewList = inDataService.getReview();
        List<Object> list = reviewList.stream().map(r -> toObject(r))
                .collect(Collectors.toList());

        model.addAttribute("list", list);
        return "index";
    }

    private Object toObject(Review r) {
        try {
            String jsonString = objectMapper.writeValueAsString(r);
            return objectMapper.readValue(jsonString, Map.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/api/comment/{reviewId}")
    public ResponseEntity<Object> getComment(@PathVariable("reviewId") Long reviewId) {
        List<Comment> comments = inDataService.getComment(reviewId);

        ApiResponse response = ApiResponse.of()
                .add("list", comments);
        return response.toResponseEntity();
    }

    @PostMapping("/api/comment/{reviewId}")
    public ResponseEntity<Object> postComment(@PathVariable("reviewId") Long reviewId, @LoginUser SessionUser user, String comment) {
        Comment result = inDataService.addComment(reviewId, user.getUserId(), user.getUserName(), comment);
        List<Comment> comments = inDataService.getComment(result.getReviewId());

        ApiResponse response = ApiResponse.of()
                .add("list", comments);
        return response.toResponseEntity();
    }

}
