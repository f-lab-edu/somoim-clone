package com.somoim.controller;

import com.somoim.model.dao.Category;
import com.somoim.model.dto.UpdateInterest;
import com.somoim.model.dto.UserInterest;
import com.somoim.service.InterestService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/interests")
public class InterestController {

    private final InterestService interestService;

    @GetMapping("/categories")
    public List<Category> getCategories(
        @RequestParam(value = "parentId", defaultValue = "0") Integer parentId) {
        return interestService.getCategoryFromParent(parentId);
    }

    @GetMapping
    public List<UserInterest> getUserInterests(
        @RequestParam(value = "userId") Long userId) {
        return interestService.getUserInterests(userId);
    }

    @PutMapping
    public void updateInterests(@RequestBody UpdateInterest updateInterest) {
        interestService.updateUserInterests(updateInterest);
    }
}
