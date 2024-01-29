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

import static java.lang.Integer.parseInt;

@RestController
public class api {

    @GetMapping("/")
    public String helloWorld() {
        return "Hello, My Server!";
    }


    // assignment 2
    @GetMapping("/data")
    public String data(@RequestParam(name = "number", required = false) String number) {
        if (number.isEmpty()) {
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
        ResponseCookie cookie = ResponseCookie.from("userName", name).build();

        return ResponseEntity
                .status(HttpStatus.SEE_OTHER)
                .location(URI.create("/myName"))
                .header(HttpHeaders.SET_COOKIE, cookie.toString())
                .build();
    }
}





