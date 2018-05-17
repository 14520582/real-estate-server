package com.realestate.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.realestate.entity.News;

@Repository
public interface NewsDAO extends CrudRepository<News, Integer>{
      @Query("SELECT t FROM News t WHERE " +
            "LOWER(t.category.name) LIKE LOWER(CONCAT('%',:category, '%')) OR " +
            "LOWER(t.category.label) LIKE LOWER(CONCAT('%',:category, '%'))")
      public Page<News> findBySearchTerm(@Param("category") String category, Pageable pageable);
      
      @Query(value="SELECT * FROM news ORDER BY views DESC LIMIT 10", nativeQuery = true)
      public List<News> findMostView();
//    public List<News> findAll();
//    @Query("SELECT e FROM News e WHERE e.typeofnews.name = :nameType")
//    public List<News> getNewsByType(@Param("nameType") String nameType);
//    @Query("select u from News u where u.subject like %?1%")
//    public List<News> findNewsBySubject(String subject);
//    @Query("select u from News u ORDER BY u.id ASC")
//    public List<News> ascNews();
//    @Query("select u from News u ORDER BY u.id DES")
//    public List<News> desNews();
}

