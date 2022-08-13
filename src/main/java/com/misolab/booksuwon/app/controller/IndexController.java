package com.misolab.booksuwon.app.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.misolab.booksuwon.common.util.DateTimeUtils;
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

    @GetMapping("/api")
    public ResponseEntity<Object> api() {
        ApiResponse response = ApiResponse.of()
                .add("message", "This is api module")
                .add("current", DateTimeUtils.toString(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss"));
        return response.toResponseEntity();
    }

}
