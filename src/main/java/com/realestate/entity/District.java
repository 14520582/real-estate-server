package com.realestate.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="district")


public class District implements Serializable {
	
//	private static final long serialVersionUID = 4L;
//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
    private Integer id; 
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_province", nullable = false)
	private Province province;
	
	@Column(name="name")
    private String name;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Province getProvince() {
		return province;
	}
	public void setProvince(Province province) {
		this.province = province;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public District() {
		super();
	}
	
	public District(Integer id, Province province, String name){
		super();
		this.id = id;
		this.name = name;
		this.province = province;
	}
	
	public District( Province province, String name){
		super();
		this.name = name;
		this.province = province;
	}


}
