package com.realestate.service.imp;
//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realestate.dao.OwnerDAO;
import com.realestate.entity.Owner;
import com.realestate.service.*;
@Service(value = "ownerService")
public class OwnerService implements IOwnerService{
	@Autowired
	private OwnerDAO ownerDAO;
	@Override
	public Owner findByName(String name) {
		// TODO Auto-generated method stub
		return ownerDAO.findByName(name);
	}

}
