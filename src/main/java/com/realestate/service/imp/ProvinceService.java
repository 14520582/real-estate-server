package com.realestate.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realestate.dao.ProvinceDAO;
import com.realestate.entity.Province;
import com.realestate.service.IProvinceService;
@Service(value = "provinceService")
public class ProvinceService implements IProvinceService{
	@Autowired
	private ProvinceDAO provinceDAO;
	@Override
	public Province findByName(String name) {
		return provinceDAO.findByName(name);
	}
	@Override
	public List<Province> findAll() {
		return (List<Province>) provinceDAO.findAll();
	}
}
