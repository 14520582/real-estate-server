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
@Table(name="ward")


public class Ward implements Serializable {
	
	private static final long serialVersionUID = 4L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
    private Integer id; 
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_district", nullable = false)
	private District district;
	
	@Column(name="name")
    private String name;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public District getDistrict() {
		return district;
	}
	public void setDistrict(District district) {
		this.district = district;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Ward() {
		super();
	}
	
	public Ward(Integer id, District district, String name){
		super();
		this.id = id;
		this.name = name;
		this.district = district;
	}
	
	public Ward( District district, String name){
		super();
		this.name = name;
		this.district = district;
	}


}
