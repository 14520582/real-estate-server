package com.realestate.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="district")


public class District implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 4L;

	@Id
	@Column(name="id")
    private Integer id; 
	
	@Column(name="name")
    private String name;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_city", nullable = false)
	private City city;
	
	@OneToMany(mappedBy="district", cascade = CascadeType.ALL, targetEntity = Ward.class)
	private List<Ward> wards = new ArrayList<Ward>();
	
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
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public District() {
		super();
	}
	
	public District(Integer id, String name){
		super();
		this.id = id;
		this.name = name;
	}
	
	public District(Integer id, String name, City city) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
	}

	public District(String name){
		super();
		this.name = name;

	}
	public District(Integer id) {
		super();
		this.id = id;
	}

}
