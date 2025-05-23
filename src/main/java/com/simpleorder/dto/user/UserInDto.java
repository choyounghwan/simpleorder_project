package com.simpleorder.dto.user;

import com.simpleorder.entity.user.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInDto {
    private String username;
    private String password;
    private String email;

    public static User toEntity(UserInDto dto){
        return User.builder()
        .username(dto.getUsername())
        .password(dto.getPassword())
        .email(dto.getEmail())
        .role(User.Role.USER)
        .build();
    }
}
