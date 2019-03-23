package com.api.log.controller;

import com.api.log.entity.User;
import com.api.log.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity getAllUser() {
        return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
    }

    @GetMapping("/users/follow/{id}")
    public ResponseEntity getAllFollowedUser(@PathVariable int id) {
        return new ResponseEntity<>(userService.getAllFollowedUser(id), HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity getUserById(@PathVariable int id) {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @GetMapping("/users/search")
    public ResponseEntity findByName(@RequestParam String name) {
        return new ResponseEntity<>(userService.findByName(name),HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity addUser(@RequestBody User user) {
        userService.addUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}