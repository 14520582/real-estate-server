package com.realestate.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.realestate.entity.News;
import com.realestate.entity.Property;

public interface IPropertyService {
	Property addProperty(Property pro);
	Property findOne(int id);
	List<Property> getNewList(int limit);
	List<Property> findByItemBased(int id);
	List<Property> findByUserBased(int id);
	Page<Property> filter(String content, Pageable pageable);
	List<Property> findByDistrictAndForm(String name, int form);
// 	List<Property> findAll();
// 	Property findByID(Integer id);
// 	List<House> findByNumofbedroom(Integer numofbedroom);
// 	List<House> findByNumofbathroom(Integer numofbathroom);
// 	List<House> findByNumoffloor(Integer numoffloor);
// 	List<House> findBySubject(String subject);
// 	List<House> findByOrientation(String orientation);
// 	List<House> findByLocation(String location);
// 	List<House> findByPrice(Integer minprice, Integer maxprice);
// 	List<House> findByArea(Float minarea, Float maxarea);
}
