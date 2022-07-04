package com.somoim.mapper;

import com.somoim.model.dao.Group;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GroupMapper {
    void insertGroup(Group group);
}
