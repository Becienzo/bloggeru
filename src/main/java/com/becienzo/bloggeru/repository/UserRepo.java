package com.becienzo.bloggeru.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.becienzo.bloggeru.model.User;

@Repository
public interface UserRepo extends CrudRepository<User,Long>{
    
}
