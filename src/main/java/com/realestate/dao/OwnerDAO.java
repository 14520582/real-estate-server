package com.realestate.dao;

//import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.realestate.entity.Owner;

@Repository
public interface OwnerDAO extends CrudRepository<Owner, Integer>{
    @Query("select u from Owner u where u.name = ?1")
    public Owner findByName(String name);
//    @Query("SELECT COUNT(e)>0 FROM Artist e WHERE e.name=?1")
//    public boolean existsByName(String name);
//    @Query("SELECT e FROM Artist e WHERE e.genre.name = :nameGenre")
//    public List<Album> getArtistByGenre(@Param("nameGenre") String nameGenre);
}
