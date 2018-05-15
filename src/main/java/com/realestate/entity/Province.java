package com.realestate.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="province")

public class Province implements Serializable  {
	
//	private static final long serialVersionUID = 4L;
//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
    private Integer id;  
	@Column(name="name")
    private String name;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Province(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Province(String name) {
		super();
		this.name = name;
	}
	public Province() {
		super();
	}


}
