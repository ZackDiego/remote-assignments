package org.example.websitemysql.controller;

import org.example.websitemysql.dto.SignInAndUpForm;
import org.example.websitemysql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ApiController {

    private final UserService userService;

    @Autowired
    public ApiController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping(path = "/signUp")
    public ResponseEntity<String> signUpUser(@RequestBody SignInAndUpForm signUpRequest) {
        String email = signUpRequest.getEmail();
        String password = signUpRequest.getPassword();
        return userService.addNewUser(email, password);
    }

    @PostMapping(path = "/signIn")
    public ResponseEntity<String> signInUser(@RequestBody SignInAndUpForm signUpRequest) {
        String email = signUpRequest.getEmail();
        String password = signUpRequest.getPassword();
        return userService.signInUser(email, password);
    }

}