package com.somoim.service;

import com.somoim.mapper.InterestMapper;
import com.somoim.model.dao.Category;
import com.somoim.model.dto.UpdateInterest;
import com.somoim.model.dto.UserInterest;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class InterestService {

    private final InterestMapper interestMapper;

    @Transactional(readOnly = true)
    public List<Category> getCategoryFromParent(Integer parent) {
        return interestMapper.selectInterestFromParent(parent);
    }

    @Transactional(readOnly = true)
    public List<UserInterest> getUserInterests(Long userId) {
        return interestMapper.selectUserInterests(userId);
    }

    @Transactional
    public void updateUserInterests(UpdateInterest updateInterest) {
        interestMapper.deleteInterests(updateInterest);
        interestMapper.insertInterests(updateInterest);
    }
}
