package com.realestate.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.realestate.entity.Province;

@Repository
public interface ProvinceDAO extends CrudRepository<Province, Integer>{
    public Province findByName(String name);
    public List<Province> findAll();
}
