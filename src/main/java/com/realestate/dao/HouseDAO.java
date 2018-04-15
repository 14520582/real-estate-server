package com.realestate.dao;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;
import com.realestate.entity.House;

@Repository
public interface HouseDAO  extends CrudRepository<House, Integer>{

    @Query("select u from House u where u.subject like %?1%")
    public List<House> findBySubject(String subject);
    
    @Query("select u from House u where u.orientation like %?1%")
    public List<House> findByOrientation(String orientation);
    
//    @Query("select u from House u where u.location like %?1%")
//    public List<House> findByLocation(String location);
    
    @Query("SELECT e FROM House e WHERE e.type.name = :nameType")
    public List<House> getHouseByType(@Param("nameType") String nameType);
    
//    @Query("select u from House u where u.numofbedroom = ?1")
//    public List<House> getHouseByNumofbedroom(Integer numofbedroom );
//    
//    @Query("select u from House u where u.numofbathroom = ?1")
//    public List<House> getHouseByNumofbathroom(Integer numofbathroom );
//    
//    @Query("select u from House u where u.numoffloor = ?1")
//    public List<House> getHouseByNumoffloor(Integer numoffloor);
//    
    

}