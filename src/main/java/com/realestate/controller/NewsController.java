package com.realestate.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import com.realestate.entity.UnitNews;

import com.realestate.entity.News;
import com.realestate.service.INewsService;
import com.realestate.service.IUnitNewsService;

@RestController
@RequestMapping("/news")
public class NewsController {
	@Autowired
	private INewsService newsService;
	@Autowired
	private IUnitNewsService unitNewsService;
	
    @RequestMapping(value = "/get/page", method = RequestMethod.GET)
    public Page<News> findPage(@RequestParam("page") int page, @RequestParam("pagesize") int pageSize, @RequestParam("category") String category) {
    	Pageable pageable = new PageRequest(page, pageSize, Sort.Direction.DESC, "id");
    	return newsService.findByPageAndCategory(category, pageable);
    }
    
    @RequestMapping(value = "/get/mostview", method = RequestMethod.GET)
    public List<News> findMostView() {
    	return newsService.findMostView();
    }

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value= "/get/{id}", method = RequestMethod.GET)
	public News findById(@PathVariable("id") int id) {
		News list = newsService.findById(id);
		return list;
	}
	@RequestMapping(value= "/add", method = RequestMethod.POST)
	public News addNews(@RequestBody News news) {
		List<UnitNews> unites = new ArrayList<UnitNews>(news.getUnites());
		news.clearUnites();
		for (Iterator<UnitNews> i = unites.iterator(); i.hasNext();) {
			UnitNews item = i.next();
			UnitNews t = new UnitNews(item.getContent(), item.getThumbnail(), news);
			news.addUnit(t);
		}
        return newsService.save(news);
	}
	@RequestMapping(value= "/update", method = RequestMethod.PUT)
	public News updateNews(@RequestBody News news) {
        return newsService.save(news);
	}
	@RequestMapping(value= "/delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") int id) {
		unitNewsService.deleteByNews(id);
        newsService.delete(id);
	}
//	
//
//	@ResponseStatus(HttpStatus.OK)
//	@RequestMapping(value= "/getNewsByType",method = RequestMethod.GET)
//	public List<News> getNewsByType(@RequestParam("type") String type) {
//		List<News> list = newsService.getNewsByType(type);
//		return list;
//	}
//	
//	@ResponseStatus(HttpStatus.OK)
//	@RequestMapping(value= "/FindNewsBySubject",method = RequestMethod.GET)
//	public List<News> findNewsBySubject(@RequestParam("subject") String subject) {
//		List<News> list = newsService.findNewsBySubject(subject);
//		return list;
//	}
//	
//	@ResponseStatus(HttpStatus.OK)
//	@RequestMapping(value= "/allAsc", method = RequestMethod.GET)
//	public List<News> ascNews() {
//		List<News> list = newsService.ascNews();
//		return list;
//	}
//	
//	@ResponseStatus(HttpStatus.OK)
//	@RequestMapping(value= "/allDes", method = RequestMethod.GET)
//	public List<News> desNews() {
//		List<News> list = newsService.desNews();
//		return list;
//	}
//	
//	
//	
//	
}
