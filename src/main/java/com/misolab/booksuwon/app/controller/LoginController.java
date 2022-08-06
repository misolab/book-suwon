package com.misolab.booksuwon.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.misolab.booksuwon.domain.entity.User;
import com.misolab.booksuwon.domain.service.InDataService;
import com.misolab.booksuwon.domain.service.OutDataService;
import com.misolab.booksuwon.domain.vo.LoginParam;
import com.misolab.booksuwon.domain.vo.LoginResult;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {

    final OutDataService outDataService;
    final InDataService inDataService;

    @GetMapping
    public void login(String userId, Model model) {
        User user = inDataService.getUser(userId);
        model.addAttribute("token", user.getUserToken());
    }

    @PostMapping
    public String loginPost(@RequestParam String userId, @RequestParam String userPw) throws JsonProcessingException {

        LoginResult result = outDataService.login(new LoginParam(userId, userPw));

        String userToken = result.getContents().getUserToken();
        String userNo = result.getContents().getUserNo();
        String userName = result.getContents().getUserName();

        Long id = inDataService.saveUserInfo(userId, userToken, userNo, userName);
        log.info("save id-{}", id);
        // TODO: 세션에 저장

        return "redirect:/";
    }
}
