package com.somoim.dto;

import com.somoim.util.PasswordEncrypt;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class User {
    private String imageId;
    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    private String name;
    private String birth;
    private boolean gender;
    private String cityCode1;
    private String cityCode2;
    private String createAt;
    private String modifyAt;
    private boolean disband;

    public void setPassword(String password) {
        PasswordEncrypt passwordEncrypt = new PasswordEncrypt();
        this.password = passwordEncrypt.hashPassword(password);
    }
}

