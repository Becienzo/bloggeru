package com.becienzo.bloggeru.controller;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.becienzo.bloggeru.model.User;
import com.becienzo.bloggeru.service.UserServ;

@RestController
public class UserCtrlr {
    private static final Logger logger = LogManager.getLogger(UserCtrlr.class);

    @Autowired
    private UserServ userService;

    @GetMapping("/users")
    public ResponseEntity<Iterable<User>> getAllUsers() {
        try {
            return ResponseEntity.ok()
                    .location((new URI("/users")))
                    .body(userService.findAll());
        } catch (URISyntaxException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<?> getUser(@PathVariable Long userId) throws Exception {
        return userService.findById(userId)
                .map(user -> {
                    try {
                        return ResponseEntity
                                .ok()
                                .location(new URI("/users/" + user.getUserId()))
                                .body(user);
                    } catch (URISyntaxException e) {
                        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
                    }
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/users")
    public ResponseEntity<?> createOrder(@RequestBody User user) {
        logger.info("New User: UserName: " + user.getUserName());
        logger.info("New User: Email: " + user.getUserEmail());
            User newUser = userService.save(user);
            try {
                return ResponseEntity
                        .created(new URI("/orders/" + newUser.getUserId()))
                        .body(newUser);
            } catch (URISyntaxException e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
      

    }
    
}
