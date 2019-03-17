package com.api.log.service;

import com.api.log.entity.Log;
import com.api.log.query.ExclogsPageQuery;
import com.api.log.query.ExclogsQuery;
import com.api.log.query.LogListQuery;
import org.springframework.data.domain.Page;

import java.util.List;

public interface LogService {
    ExclogsPageQuery getAllExcellentLog(Integer page, Integer id);

    void addLog(Log log);

    void deleteLogById(int LogId);

    void updateLogById(int LogId, Log log);
    LogListQuery getPageLog(Integer page, Integer id);
}
