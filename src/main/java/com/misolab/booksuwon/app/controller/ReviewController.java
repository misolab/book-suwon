package com.misolab.booksuwon.app.controller;

import com.misolab.booksuwon.web.util.LoginUser;
import com.misolab.booksuwon.web.vo.SessionUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/review")
public class ReviewController extends BaseController {

    @GetMapping
    public String review(@LoginUser SessionUser sessionUser, Model model) {
        if (sessionUser == null) {
            return "redirect:/login?returnUrl=/review";
        }

        return "review";
    }

}
