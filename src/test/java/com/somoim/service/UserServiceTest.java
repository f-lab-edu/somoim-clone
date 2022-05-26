package com.somoim.service;

import com.somoim.dto.User;
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
        User newUser = new User();
        newUser.setEmail("email123@email.com");
        newUser.setPassword("1234");
        // when
        userService.insertUser(newUser);
        // then
        assertEquals(newUser.getEmail(), userService.selectMember("email123@email.com").getEmail());
    }

    @Test
    @Transactional
    void checkEmail() {
        // given
        User user = new User();
        user.setEmail("email123@email.com");
        user.setPassword("1234");
        userService.insertUser(user);
        // when
        boolean result = userService.checkEmail(user.getEmail());
        // then
        assertTrue(result);
    }
}