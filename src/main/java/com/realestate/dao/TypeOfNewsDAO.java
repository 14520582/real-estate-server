package com.realestate.dao;

import org.springframework.data.jpa.repository.Query;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.realestate.entity.TypeOfNews;

@Repository
public interface TypeOfNewsDAO extends CrudRepository<TypeOfNews, Integer>{
    @Query("select u from TypeOfNews u where u.name = ?1")
    public TypeOfNews findByName(String name);
    public List<TypeOfNews> findAll();
}

