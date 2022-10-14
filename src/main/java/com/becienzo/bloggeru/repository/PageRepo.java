package com.becienzo.bloggeru.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.becienzo.bloggeru.model.Page;

@Repository
public interface PageRepo extends CrudRepository<Page,Long>{
    
}
