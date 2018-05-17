package com.realestate.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.realestate.dao.NewsDAO;
import com.realestate.entity.News;
import com.realestate.service.INewsService;
@Service(value = "newsService")
public class NewsService implements INewsService{
	@Autowired
	private NewsDAO newsDAO;

	@Override
	public Page<News> findByPageAndCategory(String category, Pageable pageable) {
		// TODO Auto-generated method stub
		return newsDAO.findBySearchTerm(category, pageable);
	}
	
//	
//	@Override
//	public List<News> findAll() {
//		// TODO Auto-generated method stub
//		return (List<News>) newsDAO.findAll();
//	}
//	@Override
//	public List<News> getNewsByType(String type) {
//		// TODO Auto-generated method stub
//		return (List<News>) newsDAO.getNewsByType(type);
//	}
//	
//	@Override
//	public List<News> findNewsBySubject(String subject) {
//		// TODO Auto-generated method stub
//		return (List<News>) newsDAO.findNewsBySubject(subject);
//	}
//	
//	@Override
//	public List<News> ascNews() {
//		// TODO Auto-generated method stub
//		return (List<News>) newsDAO.ascNews();
//	}
//	
//	@Override
//	public List<News> desNews() {
//		// TODO Auto-generated method stub
//		return (List<News>) newsDAO.desNews();
//	}
	
	
}
