package com.somoim.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.somoim.mapper.InterestMapper;
import com.somoim.model.dao.Category;
import com.somoim.model.dto.UserInterest;
import com.somoim.model.dto.UpdateInterest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class InterestServiceTest {

    @Mock
    InterestMapper interestMapper;

    @InjectMocks
    InterestService interestService;

    List<Category> categories;
    List<Category> subcategories;

    @Test
    void getCategoryFromParentTest() {
        categories = new ArrayList<>();
        Category category1 = Category.builder()
            .id(1L)
            .level(0)
            .parent(0L)
            .name("IT")
            .build();

        Category category2 = Category.builder()
            .id(2L)
            .level(0)
            .parent(0L)
            .name("외국어")
            .build();

        categories.add(category1);
        categories.add(category2);

        subcategories = new ArrayList<>();
        Category category3 = Category.builder()
            .id(3L)
            .level(1)
            .parent(1L)
            .name("백엔드")
            .build();

        Category category4 = Category.builder()
            .id(4L)
            .level(1)
            .parent(2L)
            .name("영어")
            .build();

        subcategories.add(category3);
        subcategories.add(category4);

        when(interestMapper.selectInterestFromParent(0))
            .thenReturn(categories);

        List<Category> result = interestService.getCategoryFromParent(0);
        assertThat(categories, is(equalTo(result)));

        when(interestMapper.selectInterestFromParent(1))
            .thenReturn(subcategories);

        result = interestService.getCategoryFromParent(1);
        assertThat(subcategories, is(equalTo(result)));
    }

    @Test
    void getUserInterestTest() {
        List<UserInterest> interests = new ArrayList<>();
        UserInterest userInterest1 = UserInterest.builder()
            .parentId(1L)
            .categoryId(3L)
            .parentName("IT")
            .categoryName("백엔드")
            .build();

        UserInterest userInterest2 = UserInterest.builder()
            .parentId(2L)
            .categoryId(4L)
            .parentName("외국어")
            .categoryName("영어")
            .build();

        interests.add(userInterest1);
        interests.add(userInterest2);

        when(interestMapper.selectUserInterests(0L))
            .thenReturn(interests);

        List<UserInterest> result = interestService.getUserInterests(0L);
        assertThat(interests, is(equalTo(result)));
    }

    @Test
    void updateUserInterestsTest() {
        List<Long> categories = new ArrayList<>();
        categories.add(3L);
        categories.add(4L);

        UpdateInterest updateInterest = UpdateInterest.builder()
            .userId(1L)
            .categories(categories)
            .build();

        interestService.updateUserInterests(updateInterest);
        verify(interestMapper).deleteInterests(any(UpdateInterest.class));
        verify(interestMapper).insertInterests(any(UpdateInterest.class));
    }
}

