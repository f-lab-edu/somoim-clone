package com.somoim.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private String imageId;
    private String email;
    private String password;
    private String name;
    private String birth;
    private boolean gender;
    private String cityCode1;
    private String cityCode2;
    private String createAt;
    private String modifyAt;
    private boolean disband;
}

