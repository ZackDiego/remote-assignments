package org.example.assignments;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

@Controller
public class UserName {
    // assignment 4 Cookie
    @GetMapping("/myName")
    public String getUserName(@CookieValue(value = "userName", defaultValue = "") String userName, Model model) {
        if (!userName.isEmpty()) {
            model.addAttribute("userName", URLDecoder.decode(userName, StandardCharsets.UTF_8));
            return "userName";
        } else {
            return "userNameForm";
        }
    }

}
