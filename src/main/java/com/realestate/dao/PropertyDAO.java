package com.realestate.dao;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.realestate.entity.Property;

@Repository
public interface PropertyDAO  extends CrudRepository<Property, Integer>{
	  @Query(value = "SELECT * FROM property ORDER BY id DESC LIMIT :limit", nativeQuery = true)
	  public List<Property> getNewList(@Param("limit") int limit);
	  
	  public List<Property> findTop10ByOrderByIdDesc();
//    @Query("select u from House u where u.subject like %?1%")
//    public List<House> findBySubject(String subject);
//    
//    @Query("select u from House u where u.orientation like %?1%")
//    public List<House> findByOrientation(String orientation);
//    
//    @Query("select u from House u where u.location like %?1%")
//    public List<House> findByLocation(String location);
//    
//    @Query("SELECT e FROM House e WHERE e.type.name = :nameType")
//    public List<House> getHouseByType(@Param("nameType") String nameType);
//    
//    @Query("select u from House u where u.numofbedroom = ?1")
//    public List<House> findByNumofbedroom(Integer numofbedroom );
//    
//    @Query("select u from House u where u.numofbathroom = ?1")
//    public List<House> findByNumofbathroom(Integer numofbathroom );
//    
//    @Query("select u from House u where u.numoffloor = ?1")
//    public List<House> findByNumoffloor(Integer numoffloor);
//    
//    @Query("select u from House u where u.price between ?1 and ?2")
//    public List<House> findByPrice(Integer minprice, Integer maxprice );
//    
//    @Query("select u from House u where u.area between ?1 and ?2")
//    public List<House> findByArea(Float minarea, Float maxarea );
	
//      public List<Property> findAll();
//      @Query("select u from Property u where u.id like %?1%")
//      public Property findByID(Integer id);
    
}