package com.api.log.service;


import com.api.log.LogRepository.FollowRepository;
import com.api.log.LogRepository.LogRepository;
import com.api.log.LogRepository.UserRepository;
import com.api.log.entity.Follow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List getAllFollow() {
        return followRepository.findAll();
    }

    public List getAllFollowByUserId(Integer id) {
        List allFollow = new ArrayList<>();
        List<Integer> myFollowedIdList = followRepository.findMyFollowedId(id);
        for (int i = 0; i < myFollowedIdList.size(); ++i) {
            Map<String,Object> map = new HashMap();
            map.put("logs", logRepository.findLogByFollowId(myFollowedIdList.get(i)));
            map.put("user", userRepository.findUserByFollowId(myFollowedIdList.get(i)));
            allFollow.add(map);
        }
        return allFollow;
    }

    public void addFollow(Follow follow) {
        followRepository.save(follow);
    }

    public void deleteFollow(Integer followed_id) {
        followRepository.deleteByFollowed_id(followed_id);
    }


}
