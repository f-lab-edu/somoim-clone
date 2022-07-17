package com.somoim.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UpdateGroup {

	@NotNull
	private Long categoryId;

	private Long imageId;

	@NotNull
	private Integer addressId;

	private Integer cityCode2;

	@NotBlank
	private String name;

	private String detail;
}
