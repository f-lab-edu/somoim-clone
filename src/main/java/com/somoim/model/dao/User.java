package com.somoim.model.dao;

import com.somoim.model.dto.SignUpUser;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Setter
@Getter
public class User {
    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    private String imageId;
    private String name;
    private String birth;
    private boolean gender;
    private String cityCode1;
    private String cityCode2;
    private String createAt;
    private String modifyAt;
    private boolean disband;

    @Builder
    public User(String email, String password, String createAt) {
        this.email = email;
        this.password = password;
        this.createAt = createAt;
    }
}
