package com.somoim.service;

import com.somoim.mapper.GroupMapper;
import com.somoim.model.dao.Group;
import com.somoim.model.dto.UpdateGroup;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class GroupService {

    private final GroupMapper groupMapper;

    @Transactional
    public void createGroup(UpdateGroup updateGroup) {
        LocalDateTime time = LocalDateTime.now();

        Group group = Group.builder()
                .categoryId(updateGroup.getCategoryId())
                .imageId(updateGroup.getImageId())
                .cityCode1(updateGroup.getCityCode1())
                .cityCode2(updateGroup.getCityCode2())
                .name(updateGroup.getName())
                .detail(updateGroup.getDetail())
                .createAt(time)
                .modifyAt(time)
                .disband(false)
                .build();
        groupMapper.insertGroup(group);
    }
}