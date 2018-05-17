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
@Table(name="address")
public class Address implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
    private Integer id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_city", nullable = false)
	private City city;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_district", nullable = false)
	private District district;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_ward", nullable = false)
	private Ward ward;
	
	
	@Column(name="no")
    private String no;
	
	@Column(name="street")
    private String street;


	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public Ward getWard() {
		return ward;
	}

	public void setWard(Ward ward) {
		this.ward = ward;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}
	
	public Address(Integer id, City city, District district, Ward ward, String no, String street) {
		super();
		this.id = id;
		this.city = city;
		this.district = district;
		this.ward = ward;
		this.no = no;
		this.street = street;
	}

	public Address(City city, District district, Ward ward, String no, String street) {
		super();
		this.city = city;
		this.district = district;
		this.ward = ward;
		this.no = no;
		this.street = street;
	}

	public Address() {
		super();
	}
	

}
