package com.somoim.controller;

import com.somoim.dto.User;
import com.somoim.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @PostMapping("/signUp")
    public void createUser(@Valid @RequestBody User user) {
        userService.insertUser(user);
    }
}
