package com.realestate.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;
import com.realestate.entity.District;

@Repository
public interface DistrictDAO extends CrudRepository<District, Integer> {
	public List<District> findAll();
 
}
