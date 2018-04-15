package com.realestate.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.realestate.entity.Owner;
import com.realestate.service.IOwnerService;
@RestController
@RequestMapping("/owner")


public class OwnerController {
	
	@Autowired
	private IOwnerService ownerService;
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(method = RequestMethod.GET)
	public Owner getOwnerByName(@RequestParam("name") String name) {
		Owner owner = ownerService.findByName(name);
		return owner;
	}



}
