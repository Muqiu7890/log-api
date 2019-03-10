package com.api.log.controller;

import com.api.log.entity.Follow;
import com.api.log.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class FollowController {
    @Autowired
    private FollowService followService;

    @GetMapping("/follows")
    public ResponseEntity getAllFollow() {
        return new ResponseEntity<>(followService.getAllFollow(), HttpStatus.OK);
    }

    @GetMapping("/follows/{userId}")
    public ResponseEntity getAllFollowByUserId(@PathVariable int userId) {
        return new ResponseEntity<>(followService.getAllFollowByUserId(userId), HttpStatus.OK);
    }

    @PostMapping("/follows")
    public ResponseEntity addFollow(@RequestBody Follow follow) {
        followService.addFollow(follow);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/follows/{followed_id}")
    public ResponseEntity deleteFollow(@PathVariable int followed_id) {
        followService.deleteFollow(followed_id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
