package com.realestate.service;

import java.util.List;

import com.realestate.entity.UnitNews;

public interface IUnitNewsService {
	
	List <UnitNews> findByNews(int news);
	UnitNews save(UnitNews unit);
	void delete(int id);
	void deleteByNews(int id);
}
