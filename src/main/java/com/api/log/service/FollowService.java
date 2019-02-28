package com.api.log.service;


import com.api.log.LogRepository.FollowRepository;
import com.api.log.entity.Follow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowService {
    @Autowired
    private FollowRepository followRepository;

    public List<Follow> getAllFollow() {
        return followRepository.findAll();
    }

    public void addFollow(Follow follow) {
        followRepository.save(follow);
    }



}
