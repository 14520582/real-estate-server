package com.realestate.service;

import java.util.List;

import com.realestate.entity.Pending;

public interface IPendingService {
	Pending save(Pending item);
	void delete(int id);
	List<Pending> findAll();
}
