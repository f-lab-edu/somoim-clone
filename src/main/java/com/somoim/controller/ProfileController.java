package com.somoim.controller;

import com.somoim.model.dto.UserProfile;
import com.somoim.service.ProfileService;
import com.somoim.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/profiles")
public class ProfileController {

    private final ProfileService profileService;

    private final UserService userService;

    @GetMapping
    public UserProfile getProfile(@RequestParam Long userId) {
        if (!userService.checkLogin()) {
            throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED);
        }

        return profileService.getUserProfile(userId);
    }

    @PutMapping
    public void updateProfile(@RequestBody UserProfile userProfile) {
        if (!userService.checkLogin()) {
            throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED);
        }

        profileService.updateProfile(userProfile);
    }
}
