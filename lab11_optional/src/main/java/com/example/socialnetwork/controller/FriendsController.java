package com.example.socialnetwork.controller;

import com.example.socialnetwork.entity.Friends;
import com.example.socialnetwork.service.FriendsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FriendsController {
    @Autowired
    private FriendsService service;

    @PostMapping("/addFriend")
    public Friends addFrend(@RequestBody Friends friend)
    {
        return service.saveFriend(friend);
    }
}
