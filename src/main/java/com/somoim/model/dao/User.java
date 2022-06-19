package com.somoim.model.dao;

import com.somoim.enumeration.GenderType;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Setter
@Getter
@Builder
public class User {

    @NotBlank
    private Long id;
    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    private String name;
    private String birth;
    private GenderType gender;
    private Integer cityCode1;
    private Integer cityCode2;
    private Long imageId;
    private LocalDateTime createAt;
    private LocalDateTime modifyAt;
    private Boolean disband;

}
