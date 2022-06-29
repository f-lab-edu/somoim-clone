package com.somoim.model.dao;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class Interest {

    private Long id;
    private Long userId;
    private Long categoryId;
}
