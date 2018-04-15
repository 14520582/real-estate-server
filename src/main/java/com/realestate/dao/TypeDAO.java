package com.realestate.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.realestate.entity.Type;

@Repository
public interface TypeDAO extends CrudRepository<Type, Integer>{
    @Query("select u from Type u where u.name = ?1")
    public Type findByName(String name);
}

