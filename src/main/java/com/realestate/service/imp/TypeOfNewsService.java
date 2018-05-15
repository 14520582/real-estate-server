package com.realestate.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realestate.dao.TypeOfNewsDAO;
import com.realestate.entity.TypeOfNews;
import com.realestate.service.ITypeOfNewsService;
@Service(value = "typeOfNewsService")
public class TypeOfNewsService implements ITypeOfNewsService{
	@Autowired
	private TypeOfNewsDAO typeOfNewsDAO;
	@Override
	public TypeOfNews findByName(String name) {
		// TODO Auto-generated method stub
		return typeOfNewsDAO.findByName(name);
	}
	@Override
	public List<TypeOfNews> findAll() {
		// TODO Auto-generated method stub
		return (List<TypeOfNews>) typeOfNewsDAO.findAll();
	}
}
