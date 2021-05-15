package com.example.socialnetwork.repository;

import com.example.socialnetwork.entity.Friends;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendsRepository extends JpaRepository<Friends, Integer> {
}
