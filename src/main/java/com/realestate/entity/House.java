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
@Table(name="house")

public class House implements Serializable {
	
	private static final long serialVersionUID = 2L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Integer id;  
	@Column(name="subject")
	private String subject;
	@Column(name="location")
	private String location;
	@Column(name="price")	
	private int price;
	@Column(name="area")	
	private float area;	
	@Column(name="numofbedroom")	
	private int numofbedroom;	
	@Column(name="numofbathroom")	
	private int numofbathroom;
	@Column(name="numoffloor")	
	private int numoffloor;	
	@Column(name="orientation")
	private String orientation;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_type", nullable = false)
	private Type type;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_owner", nullable = false)
	private Owner owner;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSubject() {
		return subject;
	}
	public void setName(String subject) {
		this.subject = subject;
	}
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public Float getArea() {
		return area;
	}
	public void seArea(Float area) {
		this.area = area;
	}
	public Integer getNumofbedroom() {
		return numofbedroom;
	}
	public void setNumofbedroom(Integer numofbedroom) {
		this.numofbedroom = numofbedroom;
	}
	public Integer getNumofbathroom() {
		return numofbathroom;
	}
	public void setNumofbathroom(Integer numofbathroom) {
		this.numofbathroom = numofbathroom;
	}

	public Integer getNumoffloor() {
		return numoffloor;
	}
	public void setNumoffloor(Integer numoffloor) {
		this.numoffloor = numoffloor;
	}
	
	public String getOrientation() {
		return orientation;
	}
	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}

	public House(){
		super();
	}
	
	public House(Integer id, String subject, String location, Integer price, Float area,
			Integer numofbedroom,Integer numofbathroom, Integer numoffloor, String orientation,
			Owner owner, Type type){
		super();
		this.id = id;
		this.subject = subject;
		this.location = location;
		this.price = price;
		this.area = area;
		this.numofbedroom = numofbedroom;
		this.numofbathroom = numofbathroom;
		this.numoffloor = numoffloor;
		this.orientation = orientation;
		this.owner = owner;
		this.type = type;
		
	}
	
	public House(String subject, String location, Integer price, Float area,
			Integer numofbedroom,Integer numofbathroom, Integer numoffloor, String orientation,
			Owner owner, Type type){
		super();
		this.subject = subject;
		this.location = location;
		this.price = price;
		this.area = area;
		this.numofbedroom = numofbedroom;
		this.numofbathroom = numofbathroom;
		this.numoffloor = numoffloor;
		this.orientation = orientation;
		this.owner = owner;
		this.type = type;
		
	}

}
