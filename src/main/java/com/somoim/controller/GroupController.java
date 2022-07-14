package com.somoim.controller;

import com.somoim.annotation.LoginCheck;
import com.somoim.model.dto.UpdateGroup;
import com.somoim.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/groups")
public class GroupController {

    private final GroupService groupService;

    @LoginCheck
    @PostMapping
    public void createGroup(@Valid @RequestBody UpdateGroup updateGroup) {
        groupService.createGroup(updateGroup);
    }
}
