package com.realestate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.realestate.entity.Type;
import com.realestate.service.ITypeService;
@RestController
@RequestMapping("/type")
public class TypeController {
	@Autowired
	private ITypeService typeService;
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value= "/all", method = RequestMethod.GET)
	public List<Type> findAll() {
		List<Type> list = typeService.findAll();
		return list;
	}
}
