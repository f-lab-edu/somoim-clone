package com.somoim.mapper;

import com.somoim.model.dao.User;
import com.somoim.model.dto.SignUpUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    void createUser(User user);
    boolean isExistsEmail(String email);
    SignUpUser selectUser(String email);
}
