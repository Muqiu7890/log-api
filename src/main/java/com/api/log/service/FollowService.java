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
        List<Integer> myFollowedIdList = followRepository.findMyFollowedId(id);
        for (Integer i = 0; i < myFollowedIdList.size(); i++) {
            //System.out.println(myFollowedIdList.get(i));
            List logs = logRepository.findLogByFollowId(myFollowedIdList.get(i));
            List user = userRepository.findUserByFollowId(myFollowedIdList.get(i));
            map.put("logs", logs);
            map.put("user", user);
            allFollow.add(map);
        }
        return allFollow;
    }

    public void addFollow(Follow follow) {
        followRepository.save(follow);
    }


}
