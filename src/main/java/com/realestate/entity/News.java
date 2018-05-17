package com.realestate.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="news")


public class News implements Serializable  {
	
	private static final long serialVersionUID = 4L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
    private Integer id;  
	
	@Column(name="title")
    private String title;
	
	@Column(name="headline")
    private String headline;
	
	@Lob 
	@Column(name="content",length = 100000)
    private String content;
	
	@Column(name="thumbnail")
    private String thumbnail;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_typeofnews", nullable = false)
	private TypeOfNews category;
	
	@Column(name="datecreated")
    private long datecreated;
	
	@Column(name="views")
    private int views = 0;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getHeadline() {
		return headline;
	}

	public void setHeadline(String headline) {
		this.headline = headline;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
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

	public void setThumnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public TypeOfNews getCategory() {
		return category;
	}

	public void setCategory(TypeOfNews category) {
		this.category = category;
	}

	public long getDatecreated() {
		return datecreated;
	}

	public void setDatecreated(long datecreated) {
		this.datecreated = datecreated;
	}

	public News() {
		super();
	}

	public News(Integer id, String title, String headline, String content, String thumbnail, TypeOfNews category,
			long datecreated, int views) {
		super();
		this.id = id;
		this.title = title;
		this.headline = headline;
		this.content = content;
		this.thumbnail = thumbnail;
		this.category = category;
		this.datecreated = datecreated;
		this.views = views;
	}

	public News(String title, String headline, String content, String thumbnail, TypeOfNews category, long datecreated,
			int views) {
		super();
		this.title = title;
		this.headline = headline;
		this.content = content;
		this.thumbnail = thumbnail;
		this.category = category;
		this.datecreated = datecreated;
		this.views = views;
	}
	


}
