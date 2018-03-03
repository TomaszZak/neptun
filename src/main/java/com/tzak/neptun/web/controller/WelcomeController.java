package com.tzak.neptun.web.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class WelcomeController {

    // inject via application.properties
    @Value("${welcome.page.message}")
    private String welcomePageMessage;

    @RequestMapping("/")
    public String welcome(Map<String, Object> model) {
        model.put("welcomePageMessage", this.welcomePageMessage);
        return "welcome";
    }

}