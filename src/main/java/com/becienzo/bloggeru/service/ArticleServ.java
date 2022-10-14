package com.becienzo.bloggeru.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.becienzo.bloggeru.model.Arcticle;

@Service
public interface ArticleServ {
    Optional<Arcticle> findById(Long id);
    List<Arcticle> findAll();
    Arcticle save(Arcticle art);
    void updateById(Arcticle art,Long id);
}
