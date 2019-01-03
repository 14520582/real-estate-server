package com.realestate.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.realestate.entity.Pending;

@Repository
public interface PendingDAO extends CrudRepository<Pending, Integer> {

}
