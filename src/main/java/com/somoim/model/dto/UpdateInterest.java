package com.somoim.model.dto;

import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UpdateInterest {

    Long userId;
    List<Long> categories;
}
