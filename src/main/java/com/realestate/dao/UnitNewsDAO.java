//package com.realestate.dao;
//
//import org.springframework.data.jpa.repository.Query;
//import java.util.List;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//import com.realestate.entity.UnitNews;
//
//@Repository
//public interface UnitNewsDAO extends CrudRepository<UnitNews, Integer>{
//	@Query("select u from UnitNews where u.news.id = :news")
//    public  List<UnitNews> findByNews(@Param("news") int news);
//}

package com.realestate.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.repository.query.Param;
import com.realestate.entity.UnitNews;

@Repository
public interface UnitNewsDAO extends CrudRepository<UnitNews, Integer> {
	@Query("select u from UnitNews u where u.news.id = :news")
	public List<UnitNews> findByNews(@Param("news") int news);
	
	@Transactional
	@Modifying
	@Query("delete from UnitNews u where u.news.id = :news")
	public void deleteByNews(@Param("news") int news); 
}
