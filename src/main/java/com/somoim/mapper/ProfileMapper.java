package com.somoim.mapper;

import com.somoim.model.dao.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProfileMapper {

    User getProfile(Long userId);

    void updateProfile(User user);
}
