package com.realestate.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.realestate.entity.Address;

@Repository
public interface AddressDAO extends CrudRepository<Address, Integer>{

}
