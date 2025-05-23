package com.simpleorder.service;

import org.springframework.stereotype.Service;

import com.simpleorder.dto.user.UserInDto;
import com.simpleorder.entity.user.User;
import com.simpleorder.repository.UserRepository;
import com.simpleorder.util.JwtUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    public void saveUser(UserInDto userInDto) {
        if (userRepository.existsByUsername(userInDto.getUsername())) {
            throw new IllegalArgumentException("이미 존재하는 사용자입니다.");
        }
        User user = UserInDto.toEntity(userInDto);
        userRepository.save(user);
    }

    public String login(String username, String password) {
        User user = userRepository.findByUsername(username)
            .orElseThrow(() -> new IllegalArgumentException("사용자가 존재하지 않습니다."));
        
        if (!user.getPassword().equals(password)) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        return jwtUtil.generateToken(user);
    }
}
