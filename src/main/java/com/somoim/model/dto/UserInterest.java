package com.somoim.model.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserInterest {

    private Long parentId;
    private Long categoryId;
    private String parentName;
    private String categoryName;
}
