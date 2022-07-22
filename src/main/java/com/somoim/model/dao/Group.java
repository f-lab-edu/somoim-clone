package com.somoim.model.dao;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Builder
public class Group {

	private Long id;

	private Long categoryId;

	private Long imageId;

	private Integer addressId;

	private Integer regionId;

	private String name;

	private String detail;

	private LocalDateTime createAt;

	private LocalDateTime modifyAt;

	private Boolean disband;
}
