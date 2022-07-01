package com.somoim.model.dao;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Category {

    private Long id;
    private Integer level;
    private Long parent;
    private String name;
}
