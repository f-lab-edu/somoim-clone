package com.somoim.mapper;

import com.somoim.model.dao.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    void createUser(User user);

    boolean isExistsEmail(String email);

    void deleteUser(User user);

    User findUserByEmail(String email);

    boolean getDisbandByEmail(String email);
}
