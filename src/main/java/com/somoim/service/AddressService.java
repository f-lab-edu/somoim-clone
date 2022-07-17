package com.somoim.service;

import com.somoim.exception.NotFoundException;
import com.somoim.mapper.AddressMapper;
import com.somoim.model.dao.Address;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AddressService {

	private final AddressMapper addressMapper;

	@Transactional(readOnly = true)
	public Integer getRegionId(Integer addressId) {
		Integer regionId = addressMapper.selectRegionIdByAddressId(addressId);
		if (regionId == 0) {
			throw new NotFoundException("addressId is invalid");
		}

		return regionId;
	}

	@Transactional(readOnly = true)
	public String getAddress(Integer addressId) {
		Address address = addressMapper.selectAddressString(addressId);
		if (address == null) {
			throw new NotFoundException("addressId is invalid");
		}

		return address.getSido() + " " + address.getSigungu();
	}
}
