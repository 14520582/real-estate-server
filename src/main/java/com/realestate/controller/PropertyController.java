package com.realestate.controller;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;


import com.realestate.entity.Account;
import com.realestate.entity.Property;
import com.realestate.service.IAccountService;
import com.realestate.service.IAddressService;
import com.realestate.service.IPropertyService;


@RestController
@RequestMapping("/property")

public class PropertyController {
	
	@Autowired
	private IPropertyService propertyService;
	@Autowired
	private IAccountService accountService;
	@Autowired
	private IAddressService addressService;
//	@Autowired
//	private ITypeService typeService;

	
	@RequestMapping(value= "/add", method = RequestMethod.POST)
	public Property addProperty(@RequestBody Property item) {
		item.setAddress(addressService.addAddress(item.getAddress()));
		Property newItem = propertyService.addProperty(item);
        return newItem;
	}
	@RequestMapping(value= "/get/predict", method = RequestMethod.POST)
	public float predictProperty(@RequestBody Property item) {
		float price = propertyService.predict(item);
        return price;
	}
	@RequestMapping(value= "/delete/{id}", method = RequestMethod.DELETE)
	public void deleteProperty(@PathVariable("id") int id) {
		propertyService.deleteProperty(id);
	}
	@RequestMapping(value= "/update", method = RequestMethod.PUT)
	public Property updateProperty(@RequestBody Property item) {
		item.setAddress(addressService.addAddress(item.getAddress()));
		Property newItem = propertyService.addProperty(item);
        return newItem;
	}
	@RequestMapping(value= "/get/filter", method = RequestMethod.GET)
	public Page<Property> filter(@RequestParam("page") int page, @RequestParam("pagesize") int pageSize, @RequestParam("content") String content) {
    	Pageable pageable = new PageRequest(page, pageSize, Sort.Direction.DESC, "id");
    	return propertyService.filter(content, pageable);
	}
	@RequestMapping(value= "/get/byText", method = RequestMethod.GET)
	public Page<Property> filterByText(@RequestParam("page") int page, @RequestParam("pagesize") int pageSize, @RequestParam("id") int id) {
    	Pageable pageable = new PageRequest(page, pageSize, Sort.Direction.DESC, "id");
    	return propertyService.findById(id, pageable);
	}
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value= "/get/{id}", method = RequestMethod.GET)
	public Property findByID(@PathVariable("id") Integer id) {
		Property p= propertyService.findOne(id);
		return p;
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value= "/get/{name}/{form}", method = RequestMethod.GET)
	public List<Property> findByDistrictAndForm(@PathVariable("name") String name, @PathVariable("form") int form) {
		List<Property> p= propertyService.findByDistrictAndForm(name, form);
		return p;
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value= "/get/itembased/{id}", method = RequestMethod.GET)
	public List<Property> findByItemBased(@PathVariable("id") int id) {
		List<Property> p= propertyService.findByItemBased(id);
		return p;
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value= "/get/userbased/{id}", method = RequestMethod.GET)
	public List<Property> findByUserBased(@PathVariable("id") int id) {
		List<Property> p= propertyService.findByUserBased(id);
		return p;
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value= "/get/new", method = RequestMethod.GET)
	public List<Property> getNewList(@RequestParam("limit") Integer limit) {
		return propertyService.getNewList(limit);
	}
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value= "/get/uptown", method = RequestMethod.GET)
	public Page<Property> getUptownList(@RequestParam("page") int page, @RequestParam("pagesize") int pageSize) {
		Pageable pageable = new PageRequest(page, pageSize, Sort.Direction.DESC, "id");
		return propertyService.getUptownList(pageable);
	}
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value= "/get/downtown", method = RequestMethod.GET)
	public Page<Property> getDowntownList(@RequestParam("page") int page, @RequestParam("pagesize") int pageSize) {
		Pageable pageable = new PageRequest(page, pageSize, Sort.Direction.DESC, "id");
		return propertyService. getDowntownList(pageable);
	}
//	@ResponseStatus(HttpStatus.OK)
//	@RequestMapping(value= "/all", method = RequestMethod.GET)
//	public List<Property> findAll() {
//		List<Property> list = propertyService.findAll();
//		return list;
//	}
//	
//	@ResponseStatus(HttpStatus.OK)
//	@RequestMapping(value= "/id={id}", method = RequestMethod.GET)
//	public Property findByID(@PathVariable("id") Integer id) {
//		Property p= propertyService.findByID(id);
//		return p;
//	}

}
