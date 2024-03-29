package org.example.assignments;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import static java.lang.Integer.parseInt;

@RestController
public class Api {

    @GetMapping("/")
    public String helloWorld() {
        return "Hello, My Server!";
    }


    // assignment 2
    @GetMapping("/data")
    public String data(@RequestParam(name = "number", required = false) String number) {
        System.out.println(number);
        if (number == null || number.isEmpty() ) {
            return "Lack of Parameter";
        }
        try {
            int num = parseInt(number);
            return "result: " + (num * (num + 1)) / 2;

        } catch (IllegalArgumentException e) {
            return "Wrong Parameter";
        }
    }

    @PostMapping("/trackName")
    public ResponseEntity<Object> trackName(@RequestParam(name = "name", required = true) String name) {
        String encoded_name = URLEncoder.encode(name, StandardCharsets.UTF_8);

        ResponseCookie cookie = ResponseCookie.from("userName", encoded_name).build();

        return ResponseEntity
                .status(HttpStatus.SEE_OTHER)
                .location(URI.create("/myName"))
                .header(HttpHeaders.SET_COOKIE, cookie.toString())
                .build();
    }
}





