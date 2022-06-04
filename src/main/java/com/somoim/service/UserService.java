package com.somoim.service;

import com.somoim.model.dao.User;
import com.somoim.model.dto.SignUpUser;
import com.somoim.exception.DuplicateEmailException;
import com.somoim.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class UserService {

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:sss");

    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncorder;

    @Transactional
    public void insertUser(SignUpUser user) {
        if(checkEmail(user.getEmail())) {
            throw new DuplicateEmailException("This email already registered.");
        }
        User newUser = User.signUpUser()
                        .email(user.getEmail())
                        .password(passwordEncorder.encode(user.getPassword()))
                        .createAt(simpleDateFormat.format(new Date()))
                        .build();
        userMapper.createUser(newUser);
    }

    @Transactional(readOnly = true)
    public boolean checkEmail(String email) {
        return userMapper.isExistsEmail(email);
    }
}