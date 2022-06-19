package com.somoim.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class LoginUser {
    @Email
    @NotBlank
    String email;
    @NotBlank
    String password;
}
