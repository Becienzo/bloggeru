package com.becienzo.bloggeru.service;

import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;

import com.becienzo.bloggeru.model.User;

@Service
public interface UserServ{
    Optional<User> findById(Long id);
    List<User> findAll();
    User save(User user);
    void updateById(User user,Long id);
}
