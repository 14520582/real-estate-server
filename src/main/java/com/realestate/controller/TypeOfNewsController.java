package com.realestate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.realestate.entity.TypeOfNews;
import com.realestate.service.ITypeOfNewsService;
@RestController
@RequestMapping("/typeOfNews")
public class TypeOfNewsController {
	@Autowired
	private ITypeOfNewsService typeOfNewsService;
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value= "/get/all", method = RequestMethod.GET)
	public List<TypeOfNews> findAll() {
		List<TypeOfNews> list = typeOfNewsService.findAll();
		return list;
	}
}
