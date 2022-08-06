package com.misolab.booksuwon.app.controller;

import java.util.Arrays;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.misolab.booksuwon.common.util.DateTimeUtils;
import com.misolab.booksuwon.web.util.LoginUser;
import com.misolab.booksuwon.web.vo.ApiResponse;
import com.misolab.booksuwon.web.vo.SessionUser;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/")
public class IndexController extends BaseController {

    @GetMapping
    public String index(Model model, @LoginUser SessionUser user) {
        log.info("user {}", user);

        model.addAttribute("name", "hello misolab");
        model.addAttribute("list", Arrays.asList(1, 2, 3, 4));
        return "index";
    }

    @GetMapping("/api")
    public ResponseEntity<Object> api() {
        ApiResponse response = ApiResponse.of()
                .add("message", "This is api module")
                .add("current", DateTimeUtils.toString(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss"));
        return response.toResponseEntity();
    }

}
