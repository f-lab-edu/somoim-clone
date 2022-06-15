package com.somoim.model.dao;

import com.somoim.model.dto.SignUpUser;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

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
    private Boolean gender;
    private String cityCode1;
    private String cityCode2;
    private LocalDateTime createAt;
    private LocalDateTime modifyAt;
    private Boolean disband;

    @Builder(builderMethodName = "signUpUser", builderClassName = "signUpUser")
    public User(String email, String password, LocalDateTime createAt, LocalDateTime modifyAt) {
        this.email = email;
        this.password = password;
        this.createAt = createAt;
        this.modifyAt = modifyAt;
        this.disband = false;
    }

    @Builder(builderMethodName = "resignUser", builderClassName = "resignUser")
    public User(String email, LocalDateTime modifyAt) {
        this.email = email;
        this.modifyAt = modifyAt;
        this.disband = true;
    }
}
