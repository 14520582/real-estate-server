package com.realestate.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realestate.dao.TypeOfNewsDAO;
import com.realestate.dao.UnitNewsDAO;
import com.realestate.entity.UnitNews;
import com.realestate.service.IUnitNewsService;
@Service(value = "unitNewsService")

public class UnitNewsService implements IUnitNewsService {
	@Autowired
	private UnitNewsDAO unitNewsDAO;
	
	@Override
	public List<UnitNews> findByNews(int news){
		return unitNewsDAO.findByNews(news);
	}

	@Override
	public UnitNews save(UnitNews unit) {
		// TODO Auto-generated method stub
		return unitNewsDAO.save(unit);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		unitNewsDAO.delete(id);
	}

	@Override
	public void deleteByNews(int id) {
		// TODO Auto-generated method stub
		unitNewsDAO.deleteByNews(id);
	}
	

}
