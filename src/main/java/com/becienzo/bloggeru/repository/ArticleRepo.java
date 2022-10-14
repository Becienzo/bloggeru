package com.becienzo.bloggeru.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.becienzo.bloggeru.model.Arcticle;

@Repository
public interface ArticleRepo extends CrudRepository<Arcticle,Long>{
    
}
