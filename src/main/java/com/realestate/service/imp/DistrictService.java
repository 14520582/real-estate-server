package com.realestate.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realestate.dao.DistrictDAO;
import com.realestate.dao.WardDAO;
import com.realestate.entity.District;
import com.realestate.entity.Ward;
import com.realestate.service.IDistrictService;
@Service(value = "districtService")
public class DistrictService implements IDistrictService{
	@Autowired
	private DistrictDAO districtDAO;
	@Autowired
	private WardDAO wardDAO;
//	@Override
//	public List<District> findAll() {
//		return (List<District>) districtDAO.findAll();
//	}

	@Override
	public List<District> findByCity(int city) {
		// TODO Auto-generated method stub
		return districtDAO.findByCity(city);
	}

	@Override
	public List<Ward> findWardsByDistrict(int dis) {
		// TODO Auto-generated method stub
		return wardDAO.findByDistrict(dis);
	}
}
