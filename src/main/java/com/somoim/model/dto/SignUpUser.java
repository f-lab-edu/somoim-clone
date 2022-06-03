package com.somoim.model.dto;

import com.somoim.model.dao.User;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class SignUpUser {
    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    private String createAt;
    private boolean disband;

    public static User createUser(String email, String password, String createAt) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setCreateAt(createAt);
        user.setDisband(false);
        return user;
    }
}

