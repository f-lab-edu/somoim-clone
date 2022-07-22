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
import com.somoim.model.dto.UpdateUserProfile;
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
    AddressService addressService;

    @Mock
    ProfileMapper profileMapper;

    UpdateUserProfile updateUserProfile;
    UserProfile userProfile;
    User user;

    @BeforeEach
    void setUp() {
        updateUserProfile = UpdateUserProfile.builder()
            .id(1L)
            .name("test01")
            .birth("2000-01-01")
            .gender(GenderType.M)
            .addressId(1)
            .profileImagePath("")
            .build();

        userProfile = UserProfile.builder()
            .id(1L)
            .name("test01")
            .birth("2000-01-01")
            .gender(GenderType.M)
            .address("서울특별시 강남구")
            .profileImagePath("")
            .build();

        user = User.builder()
            .id(1L)
            .name("test01")
            .birth("2000-01-01")
            .gender(GenderType.M)
            .addressId(1)
            .regionId(1)
            .imageId(0L)
            .build();
    }

    @Test
    void updateProfileTest() {
        profileService.updateProfile(updateUserProfile);
        verify(profileMapper).updateProfile(any(User.class));
    }

    @Test
    void getUserProfileTest() {
        when(profileMapper.getProfile(1L))
            .thenReturn(user);
        when(addressService.getAddress(1))
            .thenReturn("서울특별시 강남구");
        UserProfile testProfile = profileService.getUserProfile(1L);
        assertThat(testProfile, is(equalTo(userProfile)));
    }

    @Test
    void getUserProfileTestWithFail() {
        assertThrows(NotFoundException.class, () -> profileService.getUserProfile(1L));
    }
}
