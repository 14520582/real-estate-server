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
@Table(name="price")
public class PriceArea implements Serializable   {
	private static final long serialVersionUID = 4L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	@Column(name="id")
    private Integer id;
	
	@Column(name="rate")
    private int rate;
	
	@Column(name="percentage")
    private int percentage = 0;
	
	@Column(name="apartmentrate")
    private int apartmentrate;
	
	@Column(name="apartmentpercentage")
    private int apartmentpercentage = 0;
	
	@Column(name="houserate")
    private int houserate;
	
	@Column(name="housepercentage")
    private int housepercentage = 0;
	
	@Column(name="time")
    private long time;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_district", nullable = false)
	private District district;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public int getPercentage() {
		return percentage;
	}

	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}

	public District getDistrict() {
		return district;
	}

	
	public int getApartmentrate() {
		return apartmentrate;
	}

	public void setApartmentrate(int apartmentrate) {
		this.apartmentrate = apartmentrate;
	}

	public int getApartmentpercentage() {
		return apartmentpercentage;
	}

	public void setApartmentpercentage(int apartmentpercentage) {
		this.apartmentpercentage = apartmentpercentage;
	}

	public int getHouserate() {
		return houserate;
	}

	public void setHouserate(int houserate) {
		this.houserate = houserate;
	}

	public int getHousepercentage() {
		return housepercentage;
	}

	public void setHousepercentage(int housepercentage) {
		this.housepercentage = housepercentage;
	}

	public void setDistrict(District district) {
		this.district = district;
	}



	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public PriceArea() {
		super();
	}
	public PriceArea(Integer id, int rate, int percentage, long time, District district) {
		super();
		this.id = id;
		this.rate = rate;
		this.percentage = percentage;
		this.time = time;
		this.district = district;
	}

	public PriceArea(int rate, int percentage, long time, District district) {
		super();
		this.rate = rate;
		this.percentage = percentage;
		this.time = time;
		this.district = district;
	}

	public PriceArea(int rate, int percentage, int apartmentrate, int apartmentpercentage, int houserate,
			int housepercentage, long time, District district) {
		super();
		this.rate = rate;
		this.percentage = percentage;
		this.apartmentrate = apartmentrate;
		this.apartmentpercentage = apartmentpercentage;
		this.houserate = houserate;
		this.housepercentage = housepercentage;
		this.time = time;
		this.district = district;
	}

	public PriceArea(Integer id, int rate, int percentage, int apartmentrate, int apartmentpercentage, int houserate,
			int housepercentage, long time, District district) {
		super();
		this.id = id;
		this.rate = rate;
		this.percentage = percentage;
		this.apartmentrate = apartmentrate;
		this.apartmentpercentage = apartmentpercentage;
		this.houserate = houserate;
		this.housepercentage = housepercentage;
		this.time = time;
		this.district = district;
	}



	
	
}
