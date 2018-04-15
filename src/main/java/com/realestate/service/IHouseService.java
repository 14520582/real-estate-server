package com.realestate.service;

import java.util.List;

import com.realestate.entity.House;
import com.realestate.entity.Owner;

public interface IHouseService {
 	List<House> getHouseByType(String typeName);
 	List<House> findAll();
// 	List<House> getHouseByNumofbedroom(Integer numofbedroom);
 	List<House> findBySubject(String subject);
 	List<House> findByOrientation(String orientation);
// 	List<House> findByLocation(String location);
}
