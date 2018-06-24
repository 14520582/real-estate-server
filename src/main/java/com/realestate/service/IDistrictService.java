package com.realestate.service;

import java.util.List;

import com.realestate.entity.District;
import com.realestate.entity.Ward;

public interface IDistrictService {
	List<District> findByCity(int city);
	List<Ward> findWardsByDistrict(int dis);
}
