package com.realestate.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.realestate.service.*;
import com.realestate.dao.PropertyDAO;
import com.realestate.entity.Property;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

@Service(value = "propertyService")
public class PropertyService implements IPropertyService{
	@Autowired
	private PropertyDAO propertyDAO;
	private final RestTemplate restTemplate = new RestTemplate();
//	
//
//	@Override
//	public List<Property> findAll() {
//		return (List<Property>) propertyDAO.findAll();
//	}
//
//	@Override
//	public Property findByID(Integer id){
//		return propertyDAO.findByID(id);
//	}
//	
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

	@Override
	public Property addProperty(Property pro) {
		return propertyDAO.save(pro);	
	}

	@Override
	public Property findOne(int id) {
		// TODO Auto-generated method stub
		return propertyDAO.findOne(id);
	}

	@Override
	public List<Property> getNewList(int limit) {
		// TODO Auto-generated method stub
		return propertyDAO.getNewList(limit);
	}

	@Override
	public List<Property> findByDistrictAndForm(String name, int form) {
		// TODO Auto-generated method stub
		if(form != 0)
			return propertyDAO.findByDistrictAndForm(name, form);
		else
			return propertyDAO.findByDistrict(name);
	}

	@Override
	public List<Property> findByItemBased(int id) {
		// TODO Auto-generated method stub
		String url = "http://127.0.0.1:5000/item/" + id;	
		ResponseEntity<List<Integer>> result =  restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Integer>>(){});
		List<Integer> listId = result.getBody();
		return (List<Property>) propertyDAO.findAll(listId);
	};
	
	@Override
	public List<Property> findByUserBased(int id) {
		// TODO Auto-generated method stub
		String url = "http://127.0.0.1:5000/user/" + id;	
		ResponseEntity<List<Integer>> result =  restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Integer>>(){});
		List<Integer> listId = result.getBody();
		return (List<Property>) propertyDAO.findAll(listId);
	};

}
