package com.somoim.model.dto;

import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UpdateInterest {

    private Long userId;
    private List<Long> categories;
}
