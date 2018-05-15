package com.realestate.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realestate.dao.DistrictDAO;
import com.realestate.entity.District;
import com.realestate.service.IDistrictService;
@Service(value = "districtService")
public class DistrictService implements IDistrictService{
	@Autowired
	private DistrictDAO districtDAO;
	@Override
	public List<District> findAll() {
		return (List<District>) districtDAO.findAll();
	}
	@Override
	public List<District> getDistrictByProvince(String nameProvince){
		return (List<District>) districtDAO.getDistrictByProvince(nameProvince);
	}
}
