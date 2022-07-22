package com.somoim.mapper;

import com.somoim.model.dao.Address;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AddressMapper {

	Integer selectRegionIdByAddressId(Integer addressId);

	Address selectAddressString(Integer addressId);
}
