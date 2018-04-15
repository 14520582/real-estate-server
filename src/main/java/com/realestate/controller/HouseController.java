package com.realestate.controller;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.realestate.entity.Account;
import com.realestate.entity.House;
import com.realestate.entity.Owner;
import com.realestate.service.IHouseService;
import com.realestate.service.IOwnerService;
import com.realestate.service.ITypeService;

@RestController
@RequestMapping("/house")
public class HouseController {
	@Autowired
	private IHouseService houseService;
	@Autowired
	private IOwnerService OwnerService;
	@Autowired
	private IOwnerService genreService;

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value= "/all", method = RequestMethod.GET)
	public List<House> findAll() {
		List<House> list = houseService.findAll();
		return list;
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value= "/type/{type}", method = RequestMethod.GET)
	public List<House> getHouseByType(@PathVariable("type") String type) {
		List<House> list = houseService.getHouseByType(type);
		return list;
	}
	
//	@ResponseStatus(HttpStatus.OK)
//	@RequestMapping(method = RequestMethod.GET)
//	public List<House> getHouseByNumofbedroom(@RequestParam("numofbedroom") Integer numofbedroom) {
//		List<House> list = houseService.getHouseByNumofbedroom(numofbedroom);
//		return list;
//	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(method = RequestMethod.GET)
	public List<House> getHouseBySubject(@RequestParam("subject") String subject) {
		List<House> list = houseService.findBySubject(subject);
		return list;
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(method = RequestMethod.GET)
	public List<House> getHouseByOrientation(@RequestParam("orientation") String orientation) {
		List<House> list = houseService.findByOrientation(orientation);
		return list;
	}
	
//	@ResponseStatus(HttpStatus.OK)
//	@RequestMapping(method = RequestMethod.GET)
//	public List<House> getHouseByLocation(@RequestParam("location") String location) {
//		List<House> list = houseService.findByLocation(location);
//		return list;
//	}


}
