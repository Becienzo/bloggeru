package com.becienzo.bloggeru.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.becienzo.bloggeru.model.Comment;

@Repository
public interface CommentRepo extends CrudRepository<Comment,Long>{
    
}
