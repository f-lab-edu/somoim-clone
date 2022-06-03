package com.somoim.service;

import com.somoim.mapper.UserMapper;
import com.somoim.model.dao.User;
import com.somoim.model.dto.SignUpUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;
import static reactor.core.publisher.Mono.when;

//@SpringBootTest
@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    PasswordEncoder passwordEncorder;

    @Mock
    UserMapper userMapper;

    @InjectMocks
    UserService userService;

    SignUpUser signUpUser;

    @BeforeEach
    void setUp () {
        signUpUser = new SignUpUser();
        signUpUser.setEmail("emailTest@email.com");
        signUpUser.setPassword("emailTest@email.com");
        signUpUser.setCreateAt("DateTest");
    }

    @Test
    void insertUser() {
        //given
        Mockito.when(userService.checkEmail("emailTest@email.com")).thenReturn(false);
        //when
        User user = userService.insertUser(signUpUser);
        //then
        Mockito.verify(userMapper).createUser(user);
    }

    @Test
    void checkEmail() {
        //given
        Mockito.when(userMapper.isExistsEmail("emailTest@email.com")).thenReturn(true);
        //when
        assertTrue(userService.checkEmail(signUpUser.getEmail()));
    }
}