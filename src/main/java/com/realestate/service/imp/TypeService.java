package com.realestate.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realestate.dao.TypeDAO;
import com.realestate.entity.Type;
import com.realestate.service.ITypeService;
@Service(value = "typeService")
public class TypeService implements ITypeService{
	@Autowired
	private TypeDAO typeDAO;
	@Override
	public Type findByName(String name) {
		// TODO Auto-generated method stub
		return typeDAO.findByName(name);
	}
	@Override
	public List<Type> findAll() {
		// TODO Auto-generated method stub
		return (List<Type>) typeDAO.findAll();
	}
}
