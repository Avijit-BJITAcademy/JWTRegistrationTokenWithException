package com.spring.securityPractice.controller;

import com.spring.securityPractice.model.RegistrationResponse;
import com.spring.securityPractice.model.UserDto;
import com.spring.securityPractice.service.UserService;
import com.spring.securityPractice.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    public String hello(){
        return "Hello";
    }

    @GetMapping("/hello2")
    public String hello2(){
        return "Hello2";
    }
    @PostMapping("/registration")
    public ResponseEntity<?> register (@RequestBody UserDto userDto) throws Exception {
        try {
            UserDto createdUser = userService.createUser(userDto);
            String token = JWTUtils.generateToken(createdUser.getEmail());
            RegistrationResponse registrationResponse = new RegistrationResponse(userDto,token);
            return new ResponseEntity<>(registrationResponse, HttpStatus.CREATED);

        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
        }
    }
}
