package com.realestate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.realestate.entity.News;
import com.realestate.service.INewsService;
@RestController
@RequestMapping("/news")
public class NewsController {
	@Autowired
	private INewsService newsService;
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value= "/all", method = RequestMethod.GET)
	public List<News> findAll() {
		List<News> list = newsService.findAll();
		return list;
	}
	

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value= "/getNewsByType",method = RequestMethod.GET)
	public List<News> getNewsByType(@RequestParam("type") String type) {
		List<News> list = newsService.getNewsByType(type);
		return list;
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value= "/FindNewsBySubject",method = RequestMethod.GET)
	public List<News> findNewsBySubject(@RequestParam("subject") String subject) {
		List<News> list = newsService.findNewsBySubject(subject);
		return list;
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value= "/allAsc", method = RequestMethod.GET)
	public List<News> ascNews() {
		List<News> list = newsService.ascNews();
		return list;
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value= "/allDes", method = RequestMethod.GET)
	public List<News> desNews() {
		List<News> list = newsService.desNews();
		return list;
	}
	
	
	
	
}
