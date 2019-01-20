package com.realestate.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realestate.dao.RawPropertyDAO;
import com.realestate.service.IRawPropertyService;

@Service(value = "rawPropertyService")
public class RawPropertyService implements IRawPropertyService {
	@Autowired
	private RawPropertyDAO rawPropertyDAO;
	@Override
	public List<Object> getPriceByDistrict(int year, int month, int district) {
		// TODO Auto-generated method stub
		return rawPropertyDAO.getAvgByDistrict(month, year, district);
	}

	@Override
	public List<Object> getPriceByWard(int year, int month, int ward) {
		// TODO Auto-generated method stub
		return rawPropertyDAO.getAvgByWard(month, year, ward);
	}

}
