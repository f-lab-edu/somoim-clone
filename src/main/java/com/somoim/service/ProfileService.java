package com.somoim.service;

import com.somoim.exception.NotFoundException;
import com.somoim.mapper.ProfileMapper;
import com.somoim.model.dao.User;
import com.somoim.model.dto.UpdateUserProfile;
import com.somoim.model.dto.UserProfile;

import java.time.LocalDateTime;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProfileService {

	private final AddressService addressService;

	private final ProfileMapper profileMapper;

	@Transactional
	public void updateProfile(UpdateUserProfile updateUserProfile) {
		User user = User.builder()
			.id(updateUserProfile.getId())
			.name(updateUserProfile.getName())
			.birth(updateUserProfile.getBirth())
			.gender(updateUserProfile.getGender())
			.addressId(updateUserProfile.getAddressId())
			.regionId(addressService.getRegionId(updateUserProfile.getAddressId()))
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
			.address(addressService.getAddress(user.getAddressId()))
			.profileImagePath("")
			.build();
	}
}

