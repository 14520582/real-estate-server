package com.realestate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.realestate.entity.Province;
import com.realestate.service.IProvinceService;
@RestController
@RequestMapping("/Province")
public class ProvinceController {
	@Autowired
	private IProvinceService provinceService;
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value= "/all", method = RequestMethod.GET)
	public List<Province> findAll() {
		List<Province> list = provinceService.findAll();
		return list;
	}
}
