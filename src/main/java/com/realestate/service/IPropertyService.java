package com.realestate.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.realestate.entity.Property;

public interface IPropertyService {
	Property addProperty(Property pro);
	void deleteProperty(int id);
	Property findOne(int id);
	float predict(Property pro);
	List<Property> getNewList(int limit);
	Page<Property> getUptownList(Pageable pageable);
	Page<Property> getDowntownList(Pageable pageable);
	List<Property> findByItemBased(int id);
	List<Property> findByUserBased(int id);
	Page<Property> filter(String content, Pageable pageable);
	Page<Property> findById(int content, Pageable pageable);
	List<Property> findByDistrictAndForm(String name, int form);
}
