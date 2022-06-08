package com.somoim.controller;

import com.somoim.model.dto.SignUpUser;
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
    public void createUser(@Valid @RequestBody SignUpUser user) {
        userService.insertUser(user);
    }

    @PostMapping("/resign")
    public void deleteUser(@RequestBody SignUpUser user) { userService.deleteUser(user.getEmail()); }
}
