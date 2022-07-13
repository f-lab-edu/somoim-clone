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

@ExtendWith(MockitoExtension.class)
class GroupServiceTest {

    @InjectMocks
    GroupService groupService;

    @Mock
    GroupMapper groupMapper;

    @Test
    void createGroup() {

        UpdateGroup updateGroup = new UpdateGroup();
        updateGroup.setName("testGroup");
        updateGroup.setCategoryId(1L);
        updateGroup.setCityCode1(0);

        groupService.createGroup(updateGroup);

        verify(groupMapper).insertGroup(any(Group.class));
    }
}