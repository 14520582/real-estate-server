package com.realestate.entity;

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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table(name="rawproperty")
public class RawProperty {
	private static final long serialVersionUID = 2L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Integer id;  
	
	@Column(name="area")	
	private float area;
	
	@Column(name="price")	
	private int price;
	
	@Column(name="type")
	private int type;
	
	@Column(name="form")	
	private int form; // sell = 0 ; rent = 1;	

	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_address")	
	private Address address;
	
	
	@Column(name="created_date")
    private String datecreated;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public float getArea() {
		return area;
	}


	public void setArea(float area) {
		this.area = area;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public int getType() {
		return type;
	}


	public void setType(int type) {
		this.type = type;
	}


	public int getForm() {
		return form;
	}


	public void setForm(int form) {
		this.form = form;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public String getDatecreated() {
		return datecreated;
	}


	public void setDatecreated(String datecreated) {
		this.datecreated = datecreated;
	}


	public RawProperty() {
		super();
	}


	public RawProperty(Integer id, float area, int price, int type, int form, Address address, String datecreated) {
		super();
		this.id = id;
		this.area = area;
		this.price = price;
		this.type = type;
		this.form = form;
		this.address = address;
		this.datecreated = datecreated;
	}


	public RawProperty(float area, int price, int type, int form, Address address, String datecreated) {
		super();
		this.area = area;
		this.price = price;
		this.type = type;
		this.form = form;
		this.address = address;
		this.datecreated = datecreated;
	}
	
	
}
