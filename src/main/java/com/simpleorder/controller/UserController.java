package com.simpleorder.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simpleorder.dto.login.LoginInDto;
import com.simpleorder.dto.login.LoginOutDto;
import com.simpleorder.dto.user.UserInDto;
import com.simpleorder.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {
    
    private final UserService userService;

    @PostMapping("/register")
    public String registerUser(@RequestBody UserInDto user) {
        userService.saveUser(user);
        return "회원가입이 완료되었습니다.";
    }

    @PostMapping("/login")
    public LoginOutDto login(@RequestBody LoginInDto request) {
        String token = userService.login(request.getUsername(), request.getPassword());
        return new LoginOutDto(token);
    }

    @GetMapping("/user/mypage")
    public String mypage() {
        
        return "JWT 성공";
    }
    
}
