package com.somoim.model.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginUser {

    @Email
    @NotBlank
    String email;
    @NotBlank
    String password;
}
