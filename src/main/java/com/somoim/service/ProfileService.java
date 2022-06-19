package com.somoim.service;

import com.somoim.exception.NotFoundException;
import com.somoim.mapper.ProfileMapper;
import com.somoim.model.dao.User;
import com.somoim.model.dto.UserProfile;

import java.time.LocalDateTime;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProfileService {

    private final ProfileMapper profileMapper;

    @Transactional
    public void updateProfile(UserProfile userProfile) {
        User user = User.builder()
            .id(userProfile.getId())
            .name(userProfile.getName())
            .birth(userProfile.getBirth())
            .gender(userProfile.getGender())
            // 주소와 프로필 이미지는 다른 브랜치에서 구현될 예정입니다.
            .cityCode1(0)
            .cityCode2(0)
            .imageId(null)
            .modifyAt(LocalDateTime.now())
            .build();

        profileMapper.updateProfile(user);
    }

    @Transactional(readOnly = true)
    public UserProfile getUserProfile(Long userId) {
        User user = profileMapper.getProfile(userId);
        if (user == null) {
            throw new NotFoundException("User not found");
        }
        
        return UserProfile.builder()
            .id(userId)
            .name(user.getName())
            .birth(user.getBirth())
            .gender(user.getGender())
            // 주소와 프로필 이미지는 다른 브랜치에서 구현될 예정입니다.
            .address("서울시 강남구")
            .profileImagePath("")
            .build();
    }
}

