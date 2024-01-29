package org.example.assignments;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.URI;
@Controller
public class userName {
    // assignment 4 Cookie
    @GetMapping("/myName")
    public String getUserName(@CookieValue(value = "userName", defaultValue = "") String userName, Model model) {
        if (!userName.isEmpty()) {
            model.addAttribute("userName", userName);
            return "userName";
        } else {
            return "userNameForm";
        }
    }

}
