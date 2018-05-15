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
@Table(name="property")

public class Property implements Serializable {
	
	private static final long serialVersionUID = 2L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Integer id;  
	@Column(name="subject")
	private String subject;
	@Column(name="address")
	private String address;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_province", nullable = false)
	private Province province;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_district", nullable = false)
	private District district;
	@Column(name="price")	
	private int price;
	
	@Column(name="sellorrent")	
	private int sellorrent; // sell = 0 ; rent = 1;	
	
	@Column(name="redorpinkbook")	
	private int redorpinkbook; // red = 0 ; pink = 1;	
	
	
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

	@Column (name = "height")
	private  float height;
	@Column (name = "width")
	private  float width;
	@Column(name="area")	
	private float area;	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_account", nullable = false)
	private Account account;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public Province getProvince() {
		return province;
	}
	public void setProvince(Province province) {
		this.province = province;
	}
	public District getDistrict() {
		return district;
	}
	public void setDistrict(District district) {
		this.district = district;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public Integer getSellorrent() {
		return sellorrent;
	}
	public void setSellorrent(Integer sor) {
		this.sellorrent = sor;
	}
	
	public Integer getRedorpinkbook() {
		return redorpinkbook;
	}
	public void setRedorpinkbook(Integer rop) {
		this.redorpinkbook = rop;
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
	
	public Float getArea() {
		return area;
	}
	public void setArea(Float area) {
		this.area = area;
	}
	
	public Float getHeight() {
		return height;
	}
	public void setHeight(Float height) {
		this.height = height;
	}

	public Float getWidth() {
		return width;
	}
	public void setWidth(Float width) {
		this.width = width;
	}
	
	

	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account acc) {
		this.account = acc;
	}
	
	public Property(){
		super();
	}
	
	public Property(Integer id, String subject, String address, Province province, District district, Integer price, Integer sor, Integer rop,
			Float area, Integer numofbedroom,Integer numofbathroom, Integer numoffloor, String orientation,Account acc, Type type){
		super();
		this.id = id;
		this.subject = subject;
		this.address = address;
		this.province = province;
		this.district = district;
		this.price = price;
		this.area = area;
		this.numofbedroom = numofbedroom;
		this.numofbathroom = numofbathroom;
		this.numoffloor = numoffloor;
		this.orientation = orientation;
		this.type = type;
		this.account = acc;
		this.redorpinkbook = rop;
		this.sellorrent = sor;
		
	}
	
	
	public Property(String subject, String address, Province province, District district, Integer price, Integer sor, Integer rop,
			Float area, Integer numofbedroom,Integer numofbathroom, Integer numoffloor, String orientation,Account acc, Type type){
		super();
		//this.id = id;
		this.subject = subject;
		this.address = address;
		this.province = province;
		this.district = district;
		this.price = price;
		this.area = area;
		this.numofbedroom = numofbedroom;
		this.numofbathroom = numofbathroom;
		this.numoffloor = numoffloor;
		this.orientation = orientation;
		this.type = type;
		this.account = acc;
		this.redorpinkbook = rop;
		this.sellorrent = sor;
		
	}
	

}
