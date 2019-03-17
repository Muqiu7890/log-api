package com.api.log.service.impl;

import com.api.log.LogRepository.FollowRepository;
import com.api.log.LogRepository.LogRepository;
import com.api.log.LogRepository.UserRepository;
import com.api.log.entity.Log;
import com.api.log.entity.User;
import com.api.log.query.ExclogsPageQuery;
import com.api.log.query.ExclogsQuery;
import com.api.log.query.LogListQuery;
import com.api.log.service.LogService;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class LogServiceImpl implements LogService {

    private static final Integer PAGE_SIZE=5;

    @Resource
    private LogRepository logRepository;
    @Resource
    private UserRepository userRepository;
    @Resource
    private FollowRepository followRepository;
//    private UserRepository userRepository;


    public ExclogsPageQuery getAllExcellentLog(Integer page, Integer id) {
        Page<Log> logPage = logRepository.getAllId(id, new PageRequest(page, PAGE_SIZE, new Sort(Sort.Direction.DESC, "create_time")));
        List<ExclogsQuery> exs = new ArrayList<>();
        for (Log log : logPage.getContent()) {
            ExclogsQuery eq = new ExclogsQuery();
            eq.setId(log.getId());
            eq.setContent(log.getContent());
            eq.setCreateTime(log.getCreate_time());
            eq.setExc(log.getExc());
            eq.setType(log.getType());
            eq.setUserId(log.getUser_id());
            User user = userRepository.findById(log.getUser_id()).get();
            if (user != null) {
                eq.setName(user.getName());
                eq.setNickname(user.getNickname());
            }
            exs.add(eq);
        }
        ExclogsPageQuery result=new ExclogsPageQuery();
        result.setTotal(logPage.getTotalElements());
        result.setContent(exs);
        return result;
    }


    public LogListQuery getPageLog(Integer page, Integer id) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(page, PAGE_SIZE, sort);
        LogListQuery res=new LogListQuery();
        Page<Log> logPage = logRepository.findAllLogByUserId(pageable, id);
        res.setTotal(logPage.getTotalElements());
        res.setContent(logPage.getContent());
        return res;
    }

    //
    public void addLog(Log log) {
        logRepository.save(log);
    }

    public void deleteLogById(int LogId) {
        logRepository.deleteById(LogId);
    }

    public void updateLogById(int LogId, Log log) {
        Log LogInfo = logRepository.findById(LogId).get();
        LogInfo.setType(log.getType());
        LogInfo.setCreate_time(log.getCreate_time());
        LogInfo.setContent(log.getContent());
        LogInfo.setUser_id(log.getUser_id());
        LogInfo.setExc(log.getExc());
        logRepository.save(LogInfo);
    }



}
