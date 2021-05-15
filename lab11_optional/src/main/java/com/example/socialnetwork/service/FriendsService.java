package com.example.socialnetwork.service;

import com.example.socialnetwork.entity.Friends;
import com.example.socialnetwork.repository.FriendsRepository;
import com.example.socialnetwork.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendsService {
    @Autowired
    private FriendsRepository repository;

    //CREATE
    public Friends saveFriend(Friends friend){
        return repository.save(friend);
    }
    public List<Friends> saveFriends(List<Friends> friends){
        return repository.saveAll(friends);
    }

    //TODO finish the CRUD (UPDATE AND DELETE, the read is done in the user)
}
