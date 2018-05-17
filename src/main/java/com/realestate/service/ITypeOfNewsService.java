package com.realestate.service;

import java.util.List;

import com.realestate.entity.TypeOfNews;

public interface ITypeOfNewsService {
//	TypeOfNews findByName(String name);
	List<TypeOfNews> findAll();
}
