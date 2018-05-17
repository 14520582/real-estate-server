package com.realestate.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="city")
public class City implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3L;

	@Id
	@Column(name="id")
    private Integer id; 
	
	@Column(name="name")
    private String name;
	
	@OneToMany(mappedBy="city", cascade = CascadeType.ALL, targetEntity = District.class)
	private List<District> districts = new ArrayList<District>();
	


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

	public City() {
		super();
	}
	public City(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public City(Integer id) {
		super();
		this.id = id;
	}
}
