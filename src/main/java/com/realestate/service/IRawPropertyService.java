package com.realestate.service;

import java.util.List;

import com.realestate.entity.Property;

public interface IRawPropertyService {
	List<Object> getPriceByDistrict(int year, int month, int district);
	List<Object> getPriceByWard(int year, int month, int ward);

}
