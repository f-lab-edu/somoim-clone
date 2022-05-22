package com.somoim.mapper;

import com.somoim.dto.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    void createUser(User user);
    boolean isExistsEmail(String email);
}
