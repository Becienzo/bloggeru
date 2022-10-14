package com.becienzo.bloggeru.service;

import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;

import com.becienzo.bloggeru.model.Comment;

@Service
public interface CommentServ {
    Optional<Comment> findById(Long id);
    List<Comment> findAll();
    Comment save(Comment art);
    void updateById(Comment art,Long id);
}
