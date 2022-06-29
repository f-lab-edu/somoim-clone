package com.somoim.mapper;

import com.somoim.model.dao.Category;
import com.somoim.model.dto.UpdateInterest;
import com.somoim.model.dto.UserInterest;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface InterestMapper {

    List<Category> selectInterestFromParent(Integer parent);

    List<UserInterest> selectUserInterests(Long userId);

    void deleteInterests(UpdateInterest updateInterest);

    void insertInterests(UpdateInterest updateInterest);
}
