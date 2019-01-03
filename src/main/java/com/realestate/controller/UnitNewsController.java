package com.realestate.controller;

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
import com.realestate.service.IUnitNewsService;

@RestController
@RequestMapping("/unitnews")
public class UnitNewsController {
	@Autowired
	private IUnitNewsService unitNewsService;
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value= "/get/{news}", method = RequestMethod.GET)
	public List<UnitNews> findByID(@PathVariable("news") Integer news) {
		return unitNewsService.findByNews(news);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value= "/add", method = RequestMethod.POST)
	public UnitNews addUnit(@RequestBody UnitNews item) {
		return unitNewsService.save(item);
	}
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value= "/update", method = RequestMethod.PUT)
	public UnitNews updateUnit(@RequestBody UnitNews item) {
		return unitNewsService.save(item);
	}
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value= "/delete/{id}", method = RequestMethod.DELETE)
	public void deleteUnit(@PathVariable("id") int id) {
		unitNewsService.delete(id);
	}	
//	@ResponseStatus(HttpStatus.OK)
//	@RequestMapping(value= "/get/{id}", method = RequestMethod.GET)
//	public List<District> findByID(@PathVariable("id") Integer id) {
//		return districtService.findByCity(id);
//		
//	}

}
