package com.realestate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.realestate.entity.PriceArea;
import com.realestate.service.IMarketPriceService;

@RestController
@RequestMapping("/marketPrice")
public class MarketPriceController {
	@Autowired
	private IMarketPriceService marketPriceService;
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value= "/get/all", method = RequestMethod.GET)
	public List<PriceArea> findAll() {
		List<PriceArea> list = marketPriceService.findAll();
		return list;
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value= "/update", method = RequestMethod.PUT)
	public PriceArea update(@RequestBody PriceArea item) {
		PriceArea list = marketPriceService.save(item);
		return list;
	}
}
