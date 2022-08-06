package com.misolab.booksuwon.app.controller;

import static com.misolab.booksuwon.common.Constants.SESSION_USER;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.misolab.booksuwon.domain.service.InDataService;
import com.misolab.booksuwon.domain.service.OutDataService;
import com.misolab.booksuwon.domain.vo.LoginParam;
import com.misolab.booksuwon.domain.vo.LoginResult;
import com.misolab.booksuwon.web.util.LoginUser;
import com.misolab.booksuwon.web.vo.SessionUser;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {

    final OutDataService outDataService;
    final InDataService inDataService;
    final HttpSession httpSession;

    @GetMapping
    public void login(@LoginUser SessionUser sessionUser, Model model) {
        if (sessionUser != null) {
            model.addAttribute("token", sessionUser.getUserToken());
        }
    }

    @PostMapping
    public String loginPost(@RequestParam String userId, @RequestParam String userPw)
            throws JsonProcessingException {

        LoginResult result = outDataService.login(new LoginParam(userId, userPw));

        String userToken = result.getContents().getUserToken();
        String userNo = result.getContents().getUserNo();
        String userName = result.getContents().getUserName();

        Long id = inDataService.saveUserInfo(userId, userToken, userNo, userName);
        log.info("save id-{}", id);

        httpSession.setAttribute(SESSION_USER, new SessionUser(id, userId, userToken, userName));

        return "redirect:/";
    }
}
