package com.misolab.booksuwon.app.controller;

import com.misolab.booksuwon.domain.service.OutDataService;
import com.misolab.booksuwon.domain.service.RestOutDataService;
import org.springframework.context.annotation.Bean;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.client.RestTemplate;

public class BaseController {

    @Bean
    OutDataService outDataService() {
        return new RestOutDataService(new RestTemplate());
    }

    @ModelAttribute("common")
    public void common(Model model) {

    }
}
