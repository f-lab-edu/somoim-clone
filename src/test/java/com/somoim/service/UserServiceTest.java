package com.somoim.service;

import com.somoim.model.dto.SignUpUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    @Transactional
    void insertUser() {
        // given
        SignUpUser newUser = new SignUpUser();
        newUser.setEmail("email123@email.com");
        newUser.setPassword("1234");
        // when
        userService.insertUser(newUser);
        // then
        assertEquals(newUser.getEmail(), userService.selectUser("email123@email.com").getEmail());
    }

    @Test
    @Transactional
    void checkEmail() {
        // given
        SignUpUser user = new SignUpUser();
        user.setEmail("email123@email.com");
        user.setPassword("1234");
        userService.insertUser(user);
        // when
        boolean result = userService.checkEmail(user.getEmail());
        // then
        assertTrue(result);
    }
}