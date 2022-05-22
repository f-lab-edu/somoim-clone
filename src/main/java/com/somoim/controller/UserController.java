package com.somoim.controller;

import com.somoim.dto.User;
import com.somoim.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @PostMapping("/signUp")
    public void createUser(@RequestBody User user) {
        userService.insertUser(user);
    }
}
