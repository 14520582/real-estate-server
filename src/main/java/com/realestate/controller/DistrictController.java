package com.realestate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.realestate.entity.District;
import com.realestate.entity.Property;
import com.realestate.entity.Ward;
import com.realestate.service.IDistrictService;;
@RestController
@RequestMapping("/district")
public class DistrictController {
	@Autowired
	private IDistrictService districtService;
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value= "/get/{id}", method = RequestMethod.GET)
	public List<District> findByID(@PathVariable("id") Integer id) {
		return districtService.findByCity(id);
	}
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value= "/get/ward/{id}", method = RequestMethod.GET)
	public List<Ward> findWardsByDistrict(@PathVariable("id") Integer id) {
		return districtService.findWardsByDistrict(id);
	}
//	
//	@ResponseStatus(HttpStatus.OK)
//	@RequestMapping(value= "/all", method = RequestMethod.GET)
//	public List<District> findAll() {
//		List<District> list = districtService.findAll();
//		return list;
//	}	
	
}
