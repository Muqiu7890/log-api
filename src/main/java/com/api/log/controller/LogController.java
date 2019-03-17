package com.api.log.controller;

import com.api.log.entity.Log;
import com.api.log.query.ExclogsPageQuery;
import com.api.log.query.LogListQuery;
import com.api.log.service.LogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api")
public class LogController {
    @Resource
    private LogService logService;

    private Logger logger = LoggerFactory.getLogger(LogController.class);


    @GetMapping("/exclogs")
    public ResponseEntity<ExclogsPageQuery> getAllExcellentLog(int id, int page) {
//        logger.info("Entering getAllExcellentLog.");
//        List<ExclogsQuery> res = null;
//        try {
//            res = logService.getAllExcellentLog();
//        } catch (Exception e) {
//            logger.error("Leave getAllExcellentLog", e);
//        }
//        logger.info("Leave getAllExcellentLog response={}", res);
        return new ResponseEntity<>(logService.getAllExcellentLog(page, id), HttpStatus.OK);
    }

    @GetMapping("/logs")
    public ResponseEntity<LogListQuery> getPageLog(int id, int page) {
        return new ResponseEntity(logService.getPageLog(page, id), HttpStatus.OK);
    }

    @PostMapping("/logs")
    public ResponseEntity addLog(@RequestBody Log log) {
        logService.addLog(log);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/logs/{logId}")
    public ResponseEntity updateLogById(@PathVariable int logId, @RequestBody Log log) {
        logService.updateLogById(logId, log);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @DeleteMapping("/logs/{logId}")
    public ResponseEntity deleteLogById(@PathVariable int logId) {
        logService.deleteLogById(logId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
