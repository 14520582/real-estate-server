package com.realestate.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realestate.dao.MarketPriceDAO;
import com.realestate.entity.PriceArea;
import com.realestate.service.IMarketPriceService;

@Service(value = "marketPriceService")
public class MarketPriceService implements IMarketPriceService {
	@Autowired
	private MarketPriceDAO marketPriceDAO;

	@Override
	public List<PriceArea> findAll() {
		// TODO Auto-generated method stub
		return (List<PriceArea>) marketPriceDAO.findAll();
	}

	@Override
	public PriceArea save(PriceArea item) {
		// TODO Auto-generated method stub
		return marketPriceDAO.save(item);
	}
}
