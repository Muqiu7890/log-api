package com.api.log.service;


import com.api.log.LogRepository.FollowRepository;
import com.api.log.LogRepository.LogRepository;
import com.api.log.LogRepository.UserRepository;
import com.api.log.entity.Follow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.log.entity.User;
import com.api.log.entity.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FollowService {
    @Autowired
    private FollowRepository followRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LogRepository logRepository;


    public List getAllFollow(Integer id) {
        List allFollow = new ArrayList<>();
        Map<String,Object> map = new HashMap();
        List<Integer> myFollowedIdList = followRepository.getMyFollowedId(id);
        for (Integer i = 0, size = myFollowedIdList.size(); i < size; i++) {
            map.put("logs", logRepository.getLogByFollowId(myFollowedIdList.get(i)));
            map.put("user", userRepository.getUserByFollowId(myFollowedIdList.get(i)));
            allFollow.add(map);
        }
        return allFollow;
    }

    public void addFollow(Follow follow) {
        followRepository.save(follow);
    }


}
