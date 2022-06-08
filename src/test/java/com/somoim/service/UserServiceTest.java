package com.somoim.service;

import com.somoim.mapper.UserMapper;
import com.somoim.model.dao.User;
import com.somoim.model.dto.SignUpUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

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
        signUpUser.setPassword("password");
    }

    @Test
    void insertUser() {
        //given
        Mockito.when(userService.checkEmail("emailTest@email.com")).thenReturn(false);
        //when
        userService.insertUser(signUpUser);
        //then
        ArgumentCaptor<User> argument = ArgumentCaptor.forClass(User.class);
        Mockito.verify(userMapper).createUser(argument.capture());
        assertEquals(signUpUser.getEmail(), argument.getValue().getEmail());
    }

    @Test
    void checkEmail() {
        //given
        Mockito.when(userMapper.isExistsEmail("emailTest@email.com")).thenReturn(true);
        //when
        assertTrue(userService.checkEmail(signUpUser.getEmail()));
    }
}