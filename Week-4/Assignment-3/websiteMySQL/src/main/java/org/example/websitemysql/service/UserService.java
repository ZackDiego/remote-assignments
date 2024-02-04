package org.example.websitemysql.service;

import org.example.websitemysql.entity.User;
import org.example.websitemysql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Objects;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // add new user
    public ResponseEntity<String> addNewUser(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user != null) {  // the user already exists, not allow
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email already exists");
        } else {   // the user sure not exists
            User newUser = new User(email, password);
            userRepository.save(newUser);
            return ResponseEntity.status(HttpStatus.CREATED).body("Saved New User");
        }
    }

    // sign in
    public ResponseEntity<String> signInUser(@RequestBody String email, @RequestBody String password) {
        User user = userRepository.findByEmail(email);

        if (user != null) {  //user exists
            if (Objects.equals(user.getPassword(), password)) {  // the password is correct
                return ResponseEntity.status(200).body("Sign In Success");
            } else {  // wrong password
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Wrong Password");
            }
        } else {  // email not registered
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email not registered");
        }
    }
}
