package com.realestate.service;

import java.util.List;

import com.realestate.entity.Property;

public interface IPropertyService {
	Property addProperty(Property pro);
	Property findOne(int id);
	List<Property> getNewList(int limit);
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
