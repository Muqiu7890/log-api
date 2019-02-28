package com.api.log.service;

import com.api.log.LogRepository.LogRepository;
import com.api.log.entity.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService {
    @Autowired
    private LogRepository logRepository;

//    public List<Log> getLog() {
//        return logRepository.findAll();
//    }

    public List<Log> getPageLog(Integer page,Integer id) {
        Integer size = 5;
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(page, size, sort);
        return logRepository.getAllLogByUserId(pageable,id);
    }

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
        logRepository.save(LogInfo);
    }
}
