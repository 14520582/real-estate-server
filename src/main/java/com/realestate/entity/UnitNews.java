package com.realestate.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="unitnews") 

public class UnitNews implements Serializable {
	
	private static final long serialVersionUID = 4L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
    private Integer id;  
	
	@Column(name="content",length = 100000)
    private String content;
	
	@Column(name="thumbnail")
    private String thumbnail;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_news", nullable = false)
	@JsonIgnoreProperties({"unites", "category", "thumbnail", "content", "headline", "title", "datecreated", "views"})
	private News news;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	
	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}
	
	public UnitNews() {
		super();
	}
	public UnitNews(Integer id, String content, String thumbnail, News news){
		this.id = id;
		this.content = content;
		this.thumbnail = thumbnail;
		this.news = news;
	}
	
	public UnitNews( String content, String thumbnail, News news){
		this.content = content;
		this.thumbnail = thumbnail;
		this.news = news;
	}

	public UnitNews(String content, String thumbnail) {
		super();
		this.content = content;
		this.thumbnail = thumbnail;
	}
	
	
	

}
