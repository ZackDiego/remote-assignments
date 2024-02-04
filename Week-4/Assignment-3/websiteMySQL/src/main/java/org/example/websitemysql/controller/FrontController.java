package org.example.websitemysql.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class FrontController {

    // Home Page
    @GetMapping("/home")
    public String getHomePage() {
        return "homePage";
    }

    @GetMapping("/memberPage")
    public String getMemberPage() {
        return "memberPage";
    }

}
