package com.somoim.model.dao;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class Address {

	private Integer id;

	private Integer regionId;

	private String sido;

	private String sigungu;

	private String eupmyundong;
}
