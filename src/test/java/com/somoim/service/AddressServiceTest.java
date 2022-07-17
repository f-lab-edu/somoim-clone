package com.somoim.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import com.somoim.exception.NotFoundException;
import com.somoim.mapper.AddressMapper;
import com.somoim.model.dao.Address;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AddressServiceTest {

	@InjectMocks
	AddressService addressService;

	@Mock
	AddressMapper addressMapper;

	Address address;

	@BeforeEach
	void setUp() {
		address = Address.builder()
			.id(1)
			.regionId(1)
			.sido("서울특별시")
			.sigungu("강남구")
			.eupmyundong("수서동")
			.build();
	}

	@Test
	void getRegionIdTestWithSuccess() {
		Integer addressId = address.getId();
		Integer regionId = address.getRegionId();

		when(addressMapper.selectRegionIdByAddressId(addressId))
			.thenReturn(regionId);
		assertThat(regionId, is(equalTo(addressService.getRegionId(addressId))));
	}

	@Test
	void getRegionIdTestWithFail() {
		assertThrows(NotFoundException.class, () -> addressService.getRegionId(1));
	}

	@Test
	void getAddressWithSuccess() {
		when(addressMapper.selectAddressString(address.getId()))
			.thenReturn(address);

		String expected = address.getSido() + " " + address.getSigungu();
		String result = addressService.getAddress(address.getId());
		assertThat(result, is(equalTo(expected)));
	}

	@Test
	void getAddressWithFail() {
		assertThrows(NotFoundException.class, () -> addressService.getAddress(1));
	}
}
