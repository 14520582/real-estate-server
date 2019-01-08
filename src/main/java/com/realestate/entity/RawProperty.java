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
	
	@Column(name="title")
	private String title;

	@Column(name="price")	
	private int price;
	
	@Column(name="form")	
	private int form; // sell = 0 ; rent = 1;	
	
	@Column(name="license")	
	private int license; // red = 0 ; pink = 1;	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_address")	
	private Address address;
	
	@Column(name="cover")
	private String cover;
	
	@Column(name="numofbedroom")	
	private int numofbedroom;	
	
	@Column(name="numofbathroom")	
	private int numofbathroom;
	
	@Column(name="phone")	
	private String phone;
	
	@Column(name="nameOfOwner")	
	private String nameOfOwner;	

	@Column(name="email")	
	private String email;
	
	@Column(name="numoffloor")	
	private int numoffloor;	
	
	@Column(name="direction")
	private int direction;
	
	@Column(name="type")
	private int type;

	@Column (name = "height")
	private  float height;
	
	@Column (name = "width")
	private  float width;
	
	@Column(name="area")	
	private float area;
	
	@Lob 
	@Column(name="description",length = 100000)
    private String description;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_account")
	@JsonIgnoreProperties({"token", "password", "role"})
	private Account account;
	
	@Column(name="datecreated")
    private long datecreated;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getForm() {
		return form;
	}

	public void setForm(int form) {
		this.form = form;
	}

	public int getLicense() {
		return license;
	}

	public void setLicense(int license) {
		this.license = license;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public int getNumofbedroom() {
		return numofbedroom;
	}

	public void setNumofbedroom(int numofbedroom) {
		this.numofbedroom = numofbedroom;
	}

	public int getNumofbathroom() {
		return numofbathroom;
	}

	public void setNumofbathroom(int numofbathroom) {
		this.numofbathroom = numofbathroom;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getNameOfOwner() {
		return nameOfOwner;
	}

	public void setNameOfOwner(String nameOfOwner) {
		this.nameOfOwner = nameOfOwner;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getNumoffloor() {
		return numoffloor;
	}

	public void setNumoffloor(int numoffloor) {
		this.numoffloor = numoffloor;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getArea() {
		return area;
	}

	public void setArea(float area) {
		this.area = area;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public long getDatecreated() {
		return datecreated;
	}

	public void setDatecreated(long datecreated) {
		this.datecreated = datecreated;
	}

	public RawProperty(Integer id, String title, int price, int form, int license, Address address, String cover,
			int numofbedroom, int numofbathroom, String phone, String nameOfOwner, String email, int numoffloor,
			int direction, int type, float height, float width, float area, String description, Account account,
			long datecreated) {
		super();
		this.id = id;
		this.title = title;
		this.price = price;
		this.form = form;
		this.license = license;
		this.address = address;
		this.cover = cover;
		this.numofbedroom = numofbedroom;
		this.numofbathroom = numofbathroom;
		this.phone = phone;
		this.nameOfOwner = nameOfOwner;
		this.email = email;
		this.numoffloor = numoffloor;
		this.direction = direction;
		this.type = type;
		this.height = height;
		this.width = width;
		this.area = area;
		this.description = description;
		this.account = account;
		this.datecreated = datecreated;
	}

	public RawProperty(String title, int price, int form, int license, Address address, String cover, int numofbedroom,
			int numofbathroom, String phone, String nameOfOwner, String email, int numoffloor, int direction, int type,
			float height, float width, float area, String description, Account account, long datecreated) {
		super();
		this.title = title;
		this.price = price;
		this.form = form;
		this.license = license;
		this.address = address;
		this.cover = cover;
		this.numofbedroom = numofbedroom;
		this.numofbathroom = numofbathroom;
		this.phone = phone;
		this.nameOfOwner = nameOfOwner;
		this.email = email;
		this.numoffloor = numoffloor;
		this.direction = direction;
		this.type = type;
		this.height = height;
		this.width = width;
		this.area = area;
		this.description = description;
		this.account = account;
		this.datecreated = datecreated;
	}

	public RawProperty() {
		super();
	}
	
	
}
