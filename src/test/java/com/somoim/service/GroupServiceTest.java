package com.somoim.service;

import com.somoim.mapper.GroupMapper;
import com.somoim.model.dao.Group;
import com.somoim.model.dto.UpdateGroup;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GroupServiceTest {

	@InjectMocks
	GroupService groupService;

	@Mock
	AddressService addressService;

	@Mock
	GroupMapper groupMapper;

	@Test
	void createGroup() {

		UpdateGroup updateGroup = new UpdateGroup();
		updateGroup.setName("testGroup");
		updateGroup.setCategoryId(1L);
		updateGroup.setAddressId(1);

		when(addressService.getRegionId(1))
			.thenReturn(1);
		groupService.createGroup(updateGroup);

		verify(groupMapper).insertGroup(any(Group.class));
	}
}