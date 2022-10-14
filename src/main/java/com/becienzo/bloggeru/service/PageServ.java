package com.becienzo.bloggeru.service;



import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.becienzo.bloggeru.model.Page;

@Service
public interface PageServ{
    Optional<Page> findById(Long id);
    List<Page> findAll();
    Page save(Page page);
    void updateById(Page page,Long id);
}
