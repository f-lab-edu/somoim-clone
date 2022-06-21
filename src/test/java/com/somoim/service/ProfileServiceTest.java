package com.somoim.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

import com.somoim.enumeration.GenderType;
import com.somoim.exception.NotFoundException;
import com.somoim.mapper.ProfileMapper;
import com.somoim.model.dao.User;
import com.somoim.model.dto.UserProfile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ProfileServiceTest {

    @InjectMocks
    ProfileService profileService;

    @Mock
    ProfileMapper profileMapper;

    UserProfile userProfile;
    User user;

    @BeforeEach
    void setUp() {
        userProfile = UserProfile.builder()
            .id(1L)
            .name("test01")
            .birth("2000-01-01")
            .gender(GenderType.M)
            .address("서울시 강남구")
            .profileImagePath("")
            .build();

        user = User.builder()
            .id(1L)
            .name("test01")
            .birth("2000-01-01")
            .gender(GenderType.M)
            .cityCode1(0)
            .cityCode2(0)
            .imageId(0L)
            .build();
    }

    @Test
    void updateProfileTest() {
        profileService.updateProfile(userProfile);
        verify(profileMapper).updateProfile(any(User.class));
    }

    @Test
    void getUserProfileTest() {
        when(profileMapper.getProfile(1L))
            .thenReturn(user);
        UserProfile testProfile = profileService.getUserProfile(1L);
        assertThat(testProfile, is(equalTo(userProfile)));
    }

    @Test
    void getUserProfileTestWithFail() {
        assertThrows(NotFoundException.class, () -> profileService.getUserProfile(1L));
    }
}
