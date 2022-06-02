package com.somoim.model.dto;

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

    public static SignUpUser createUser(String email, String password, String createAt) {
        SignUpUser user = new SignUpUser();
        user.email = email;
        user.password = password;
        user.createAt = createAt;
        user.disband = false;
        return user;
    }
}

