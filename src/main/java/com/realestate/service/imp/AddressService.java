package com.realestate.service.imp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realestate.dao.AddressDAO;
import com.realestate.entity.Address;
import com.realestate.service.IAddressService;

@Service(value = "addressService")
public class AddressService implements IAddressService{
	@Autowired
	private AddressDAO addressDAO;

	@Override
	public Address addAddress(Address add) {
		return addressDAO.save(add);
	}
}
