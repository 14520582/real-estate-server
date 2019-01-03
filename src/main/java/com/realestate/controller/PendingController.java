package com.realestate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.realestate.entity.Pending;
import com.realestate.service.IPendingService;
@RestController
@RequestMapping("/pending")
public class PendingController {
	@Autowired
	private IPendingService pendingService;
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value= "/get", method = RequestMethod.GET)
	public List<Pending> getAllPending() {
		return pendingService.findAll();
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value= "/add", method = RequestMethod.POST)
	public Pending addPending(@RequestBody Pending item) {
		return pendingService.save(item);
	}
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value= "/update", method = RequestMethod.PUT)
	public Pending Pending(@RequestBody Pending item) {
		return pendingService.save(item);
	}
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value= "/delete/{id}", method = RequestMethod.DELETE)
	public void deletePending(@PathVariable("id") int id) {
		pendingService.delete(id);
	}	
}
