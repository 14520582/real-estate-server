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

@Entity
@Table(name="news")


public class News implements Serializable  {
	
	private static final long serialVersionUID = 4L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
    private Integer id;  
	@Column(name="subject")
    private String subject;
	@Column(name="content")
    private String content;
	@JoinColumn(name = "id_typeofnews", nullable = false)
	private TypeOfNews typeofnews;
	@ManyToOne(fetch = FetchType.EAGER)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject){
		this.subject = subject;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content){
		this.content = content;
	}
	
	public TypeOfNews getTypeOfNews() {
		return typeofnews;
	}
	public void setTypeOfNews(TypeOfNews typeofnews){
		this.typeofnews = typeofnews;
	}
	
	public News(Integer id, String subject, String content, TypeOfNews typeofnews) {
		super();
		this.id = id;
		this.subject = subject;
		this.content = content;
		this.typeofnews = typeofnews;
	}
	public News(String subject, String content, TypeOfNews typeofnews) {
		super();
		this.subject = subject;
		this.content = content;
		this.typeofnews = typeofnews;
	}
	public News() {
		super();
	}


}
