package com.realestate.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.realestate.entity.RawProperty;

@Repository
public interface RawPropertyDAO extends CrudRepository<RawProperty, Integer> {
	  @Query(value = "SELECT A.type as type, AVG(price) / AVG(area) as price\n" + 
	  		"FROM rawproperty as A, address as B\n" + 
	  		"where A.id_address = B.id and YEAR(created_date) = :year and month(created_date) = :month and form = 0 and id_ward = :ward\n" + 
	  		"group by A.type", nativeQuery = true)
	  public List<Object> getAvgByWard(@Param("month") int month, @Param("year") int year, @Param("ward") int ward);

	  @Query(value = "SELECT A.type as type, AVG(price) / AVG(area) as price\n" + 
		  		"FROM rawproperty as A, address as B\n" + 
		  		"where A.id_address = B.id and YEAR(created_date) = :year and month(created_date) = :month and form = 0 and id_district = :district\n" + 
		  		"group by A.type", nativeQuery = true)
	  public List<Object> getAvgByDistrict(@Param("month") int month, @Param("year") int year, @Param("district") int district);
}
