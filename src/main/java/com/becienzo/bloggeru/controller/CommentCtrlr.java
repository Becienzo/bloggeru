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

import com.becienzo.bloggeru.model.Comment;
import com.becienzo.bloggeru.service.CommentServ;

public class CommentCtrlr {
    private static final Logger logger = LogManager.getLogger(UserCtrlr.class);

    @Autowired
    private CommentServ commentService;

    @GetMapping("/comments")
    public ResponseEntity<Iterable<Comment>> getAllComments() {
        try {
            return ResponseEntity.ok()
                    .location((new URI("/comments")))
                    .body(commentService.findAll());
        } catch (URISyntaxException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/comments/{commentId}")
    public ResponseEntity<?> getComment(@PathVariable Long userId) throws Exception {
        return commentService.findById(userId)
                .map(user -> {
                    try {
                        return ResponseEntity
                                .ok()
                                .location(new URI("/comments/" + user.getPageId()))
                                .body(user);
                    } catch (URISyntaxException e) {
                        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
                    }
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/comments")
    public ResponseEntity<?> createComment(@RequestBody Comment comment) {
        logger.info("New User: UserName: " + comment.getCommentArticleReference());
        logger.info("New User: Email: " + comment.getCommentText());
        Comment newcomment = commentService.save(comment);
            try {
                return ResponseEntity
                        .created(new URI("/orders/" + newcomment.getPageId()))
                        .body(newcomment);
            } catch (URISyntaxException e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
      

    }
}
