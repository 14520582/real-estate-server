package com.realestate.service;

import java.util.List;

import com.realestate.entity.Province;

public interface IProvinceService {
	Province findByName(String name);
	List<Province> findAll();
}
