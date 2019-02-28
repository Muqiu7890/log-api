package com.api.log.controller;

import com.api.log.entity.Log;
import com.api.log.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LogController {
    @Autowired
    private LogService logService;

//    @GetMapping("/logs")
//    public ResponseEntity getAllLog() {
//        return new ResponseEntity<>(logService.getAllLog(), HttpStatus.OK);
//    }

    @GetMapping("/logs/{id}")
    public ResponseEntity getPageLog(@PathVariable int id,@RequestParam Integer page) {
        return new ResponseEntity<>(logService.getPageLog(page,id),HttpStatus.OK);
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
