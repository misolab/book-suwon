package com.misolab.booksuwon.app.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.misolab.booksuwon.app.controller.dto.ReviewParam;
import com.misolab.booksuwon.domain.service.OutDataService;
import com.misolab.booksuwon.domain.vo.ApplyListResult;
import com.misolab.booksuwon.domain.vo.RentalParam;
import com.misolab.booksuwon.web.util.LoginUser;
import com.misolab.booksuwon.web.vo.SessionUser;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/review")
public class ReviewController extends BaseController {

    final OutDataService outDataService;

    @GetMapping
    public String review(@LoginUser SessionUser sessionUser, Model model) throws JsonProcessingException {
        if (sessionUser == null) {
            return "redirect:/login?returnUrl=/review";
        }

        ApplyListResult list = outDataService.rental(sessionUser.getUserToken(), new RentalParam());
        model.addAttribute("list", list.getContents().getApplyList());

        return "review";
    }

    @PostMapping
    public String reviewPost(@LoginUser SessionUser sessionUser, @RequestBody ReviewParam param) {
        log.info("param {}", param);

        return "redirect:/";
    }

}
