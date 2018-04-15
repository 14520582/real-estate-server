package com.realestate.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.realestate.service.*;
import com.realestate.dao.HouseDAO;
import com.realestate.entity.House;
import com.realestate.entity.Owner;
@Service(value = "houseService")
public class HouseService implements IHouseService{
	@Autowired
	private HouseDAO houseDAO;
	@Override
	public List<House> getHouseByType(String typeName) {
		return houseDAO.getHouseByType(typeName);
	}
	@Override
	public List<House> findAll() {
		return (List<House>) houseDAO.findAll();
	}

//	public List<House> getHouseByNumofbedroom(Integer numofbedroom) {
//		return (List<House>) houseDAO.getHouseByNumofbedroom(numofbedroom);
//	}
	
	@Override
	public List<House> findBySubject(String subject) {
		// TODO Auto-generated method stub
		return (List<House>) houseDAO.findBySubject(subject);
	}
	

	@Override
	public List<House> findByOrientation(String orientation) {
		// TODO Auto-generated method stub
		return (List<House>) houseDAO.findByOrientation(orientation);
	}
	
//	@Override
//	public List<House> findByLocation(String location) {
//		// TODO Auto-generated method stub
//		return (List<House>) houseDAO.findByLocation(location);
//	}

}
