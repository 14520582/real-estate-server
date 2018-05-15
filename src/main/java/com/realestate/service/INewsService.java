package com.realestate.service;

import java.util.List;

import com.realestate.entity.News;

public interface INewsService {
	List<News> findAll();
	List<News> findNewsBySubject(String subject);
	List<News> getNewsByType(String type);
	List<News> ascNews();
	List<News> desNews();
}
