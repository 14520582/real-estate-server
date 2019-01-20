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

import com.realestate.entity.PriceArea;
import com.realestate.service.IMarketPriceService;
import com.realestate.service.IRawPropertyService;

@RestController
@RequestMapping("/marketPrice")
public class MarketPriceController {
	@Autowired
	private IMarketPriceService marketPriceService;
	@Autowired
	private IRawPropertyService rawPropertyService;
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value= "/get/all", method = RequestMethod.GET)
	public List<PriceArea> findAll() {
		List<PriceArea> list = marketPriceService.findAll();
		return list;
	}
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value= "/get/district/{year}/{month}/{district}", method = RequestMethod.GET)
	public List<Object> findByDistrict(@PathVariable("year") int year, @PathVariable("month") int month, @PathVariable("district") int district) {
		List<Object> list = rawPropertyService.getPriceByDistrict(year, month, district);
		return list;
	}
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value= "/get/ward/{year}/{month}/{ward}", method = RequestMethod.GET)
	public List<Object> findByWard(@PathVariable("year") int year, @PathVariable("month") int month, @PathVariable("ward") int ward) {
		List<Object> list = rawPropertyService.getPriceByWard(year, month, ward);
		return list;
	}
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value= "/update", method = RequestMethod.PUT)
	public PriceArea update(@RequestBody PriceArea item) {
		PriceArea list = marketPriceService.save(item);
		return list;
	}
}
