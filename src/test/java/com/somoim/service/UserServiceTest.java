package com.somoim.service;

import com.somoim.mapper.UserMapper;
import com.somoim.model.dao.User;
import com.somoim.model.dto.LoginUser;
import com.somoim.model.dto.ResignUser;
import com.somoim.model.dto.SignUpUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.servlet.http.HttpSession;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    PasswordEncoder passwordEncorder;

    @Mock
    HttpSession httpSession;

    @Mock
    UserMapper userMapper;

    @InjectMocks
    UserService userService;

    SignUpUser signUpUser;
    ResignUser resignUser;
    LoginUser loginUser;

    @BeforeEach
    void setUp () {
        signUpUser = new SignUpUser();
        signUpUser.setEmail("emailTest@email.com");
        signUpUser.setPassword("password");

        resignUser = new ResignUser();
        resignUser.setEmail("emailTest@email.com");

        loginUser = new LoginUser();
        loginUser.setEmail("emailTest@email.com");
        loginUser.setPassword("password");
    }

    @Test
    void insertUser() {
        //given
        when(userService.checkEmail("emailTest@email.com")).thenReturn(false);
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
        when(userMapper.isExistsEmail("emailTest@email.com")).thenReturn(true);
        //when
        assertTrue(userService.checkEmail(signUpUser.getEmail()));
    }

    @Test
    void deleteUser() {
        //when
        userService.deleteUser(resignUser);
        //then
        ArgumentCaptor<User> argument = ArgumentCaptor.forClass(User.class);
        Mockito.verify(userMapper).deleteUser(argument.capture());
        assertTrue(argument.getValue().getDisband());
        assertNotNull(argument.getValue().getModifyAt());
    }

    @Test
    void checkLogin() {
        //given
        when(httpSession.getAttribute("USER_EMAIL")).thenReturn(loginUser.getEmail());

        //when
        boolean result = userService.checkLogin(loginUser.getEmail());

        //then
        assertTrue(result);
    }

    @Test
    void loginUser() {
        //given
        User signUpUser = User.signUpUser()
                        .email(this.signUpUser.getEmail())
                        .password(this.signUpUser.getPassword())
                        .build();

        //when
        when(userService.findUserByEmail(loginUser.getEmail())).thenReturn(signUpUser);
        when(passwordEncorder.matches(loginUser.getPassword(), signUpUser.getPassword())).thenReturn(true);
        when(httpSession.getAttribute("USER_EMAIL")).thenReturn(loginUser.getEmail());

        userService.loginUser(loginUser);

        //then
        assertTrue(userService.checkLogin(loginUser.getEmail()));
    }
}