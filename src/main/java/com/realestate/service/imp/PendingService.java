package com.realestate.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realestate.dao.PendingDAO;
import com.realestate.entity.Pending;
import com.realestate.service.IPendingService;

@Service(value = "pendingService")
public class PendingService implements IPendingService {
	@Autowired
	private PendingDAO pendingDAO;
	@Override
	public Pending save(Pending item) {
		// TODO Auto-generated method stub
		return pendingDAO.save(item);
	}
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		pendingDAO.delete(id);
	}
	@Override
	public List<Pending> findAll() {
		// TODO Auto-generated method stub
		return (List<Pending>) pendingDAO.findAll();
	}

}
