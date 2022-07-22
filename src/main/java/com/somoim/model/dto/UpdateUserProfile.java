package com.somoim.model.dto;

import com.somoim.enumeration.GenderType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class UpdateUserProfile {

	private Long id;

	private String name;

	private String birth;

	private GenderType gender;

	private Integer addressId;

	private String profileImagePath;
}
