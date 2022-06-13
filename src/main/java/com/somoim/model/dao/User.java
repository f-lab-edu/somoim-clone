package com.somoim.model.dao;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    private Long imageId;
    private String name;
    private String birth;
    private String gender;
    private Integer cityCode1;
    private Integer cityCode2;
    private LocalDateTime createAt;
    private LocalDateTime modifyAt;
    private Boolean disband;

    @Builder(builderMethodName = "signUpUser", builderClassName = "signUpUser")
    public User(String email, String password, LocalDateTime createAt) {
        this.email = email;
        this.password = password;
        this.createAt = createAt;
        this.disband = false;
    }

    @Builder(builderMethodName = "resignUser", builderClassName = "resignUser")
    public User(String email, LocalDateTime modifyAt) {
        this.email = email;
        this.modifyAt = modifyAt;
        this.disband = true;
    }
}
