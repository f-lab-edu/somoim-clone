package com.somoim.service;

import com.somoim.dto.User;
import com.somoim.exception.DuplicateEmailException;
import com.somoim.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.somoim.util.PasswordEncrypt;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class UserService {
    Date time = new Date();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:sss");

    private final UserMapper userMapper;
    private final PasswordEncrypt passwordEncrypt;

    @Transactional
    public void insertUser(User user) {
        if(checkEmail(user.getEmail())) {
            throw new DuplicateEmailException("This email already registered.");
        }
        user.setPassword(passwordEncrypt.hashPassword(user.getPassword()));
        user.setCreateAt(simpleDateFormat.format(time));
        user.setModifyAt(user.getCreateAt());
        user.setDisband(false);
        userMapper.createUser(user);
    }

    @Transactional(readOnly = true)
    public boolean checkEmail(String email) {
        return userMapper.isExistsEmail(email);
    }

    public User selectMember(String email) {
        return userMapper.selectMember(email);
    }
}
