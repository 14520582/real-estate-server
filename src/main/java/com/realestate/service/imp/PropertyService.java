package com.realestate.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.realestate.service.*;
import com.realestate.dao.PropertyDAO;
import com.realestate.entity.Property;
@Service(value = "propertyService")
public class PropertyService implements IPropertyService{
	@Autowired
	private PropertyDAO propertyDAO;
	

	@Override
	public List<Property> findAll() {
		return (List<Property>) propertyDAO.findAll();
	}

	@Override
	public Property findByID(Integer id){
		return propertyDAO.findByID(id);
	}
	
//	@Override
//	public List<House> findByNumofbathroom(Integer numofbathroom) {
//		return (List<House>) houseDAO.findByNumofbathroom(numofbathroom);
//	}
//	
//	@Override
//	public List<House> findByNumoffloor(Integer numoffloor) {
//		return (List<House>) houseDAO.findByNumoffloor(numoffloor);
//	}
//	
//	@Override
//	public List<House> findBySubject(String subject) {
//		// TODO Auto-generated method stub
//		return (List<House>) houseDAO.findBySubject(subject);
//	}
//	
//
//	@Override
//	public List<House> findByOrientation(String orientation) {
//		// TODO Auto-generated method stub
//		return (List<House>) houseDAO.findByOrientation(orientation);
//	}
//	
//	@Override
//	public List<House> findByLocation(String location) {
//		// TODO Auto-generated method stub
//		return (List<House>) houseDAO.findByLocation(location);
//	}
//	
//	@Override
//	public List<House> findByPrice(Integer minprice, Integer maxprice) {
//		return (List<House>) houseDAO.findByPrice(minprice, maxprice);
//	}
//	
//	@Override
//	public List<House> findByArea(Float minarea, Float maxarea) {
//		return (List<House>) houseDAO.findByArea(minarea, maxarea);
//	}

}
