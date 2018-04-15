package com.realestate.service;

import java.util.List;

import com.realestate.entity.Type;

public interface ITypeService {
	Type findByName(String name);
	List<Type> findAll();
}
