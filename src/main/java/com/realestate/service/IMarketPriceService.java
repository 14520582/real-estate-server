package com.realestate.service;

import java.util.List;

import com.realestate.entity.PriceArea;

public interface IMarketPriceService {
	List<PriceArea> findAll();
	PriceArea save(PriceArea item);
}
