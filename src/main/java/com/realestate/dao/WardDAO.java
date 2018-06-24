package com.realestate.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.realestate.entity.Ward;

@Repository
public interface WardDAO extends CrudRepository<Ward, Integer>  {
	@Query("select u from Ward u where u.district.id = :dis")
	public List<Ward> findByDistrict(@Param("dis") int dis);
}
