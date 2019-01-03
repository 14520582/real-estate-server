package com.realestate.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.realestate.service.*;
import com.realestate.dao.PropertyDAO;
import com.realestate.entity.Property;
import com.realestate.filter.SearchCriteria;
import com.realestate.filter.PropertySpecification;
import com.realestate.filter.PropertySpecificationsBuilder;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

@Service(value = "propertyService")
public class PropertyService implements IPropertyService{
	@Autowired
	private PropertyDAO propertyDAO;
	private final RestTemplate restTemplate = new RestTemplate();

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
	public Page<Property> getUptownList(Pageable pageable) {
		// TODO Auto-generated method stub
		List<Integer> upTown = new ArrayList<Integer>();
		upTown.add(760);
		upTown.add(767);
		upTown.add(768);
		upTown.add(774);
		upTown.add(766);
		return propertyDAO.getUptownList(upTown, pageable);
	}
	@Override
	public Page<Property> getDowntownList(Pageable pageable) {
		// TODO Auto-generated method stub
		List<Integer> downTown = new ArrayList<Integer>();
		downTown.add(783);
		downTown.add(784);
		downTown.add(786);
		downTown.add(787);
		downTown.add(762);
		return propertyDAO.getDowntownList(downTown, pageable);
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
	}

	@Override
	public Page<Property> filter(String content, Pageable pageable) {
		PropertySpecificationsBuilder builder = new PropertySpecificationsBuilder();
        Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
        Matcher matcher = pattern.matcher(content + ",");
        while (matcher.find()) {
            builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
        }
		Specification<Property> spec = builder.build();
		return (Page<Property>) propertyDAO.findAll(Specifications.where(spec),pageable);
	}

	@Override
	public void deleteProperty(int id) {
		// TODO Auto-generated method stub
		propertyDAO.delete(id);
	}

	@Override
	public Page<Property> findById(int id, Pageable pageable) {
		// TODO Auto-generated method stub
		return propertyDAO.findById(id, pageable);
	}

	@Override
	public float predict(Property pro) {
		String url = "http://127.0.0.1:5000/predict";
		List<Integer> data = new ArrayList<>();
		data.add(75);
		data.add(12);
		data.add(6);
		data.add(0);
		data.add(2);
		data.add(0);
		data.add(2);
		data.add(2);
		data.add(1);
		data.add(1);
		data.add(27430);
		data.add(776);
		ResponseEntity<Float> result =  restTemplate.postForObject(url, data, ResponseEntity.class);
		float listId = result.getBody();
		return listId;
	};

}
