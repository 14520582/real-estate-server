package com.realestate.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.realestate.entity.News;

public interface INewsService {
	
	Page<News> findByPageAndCategory(String category, Pageable pageable);
	List<News> findMostView();
	News findById(int id);
	void delete(int id);
	News save(News item);
//	List<News> getNewsByType(String type);
//	List<News> ascNews();
//	List<News> desNews();
}
