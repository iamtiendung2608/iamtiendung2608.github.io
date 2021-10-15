package com.example.demo.UserAccount;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Table(name="Address")
@Entity(name="Address")
public class Address {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ID;
	@OneToOne
	@JoinColumn(name="User_ID", referencedColumnName="User_id")
	private AppUser user;
	@NotNull
	@Size(min=1,message="Country must not be null")
	private String Country;
	@NotNull
	@Size(min=1,message="Province must not be null")
	private String Province;
	@NotNull
	@Size(min=1,message="City must not be null")
	private String City;
	@NotNull
	@Size(min=1,message="Street must not be null")
	private String Street;
	@NotNull
	@Size(min=1,message="Home Number must not be null")
	private String HomeNumber;
	public Address(String country,String province,String city,String street,String homeNumber) {
		super();
		Country = country;
		Province = province;
		City = city;
		Street = street;
		HomeNumber = homeNumber;
	}
	
	public Address() {
		super();
	}

	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public String getProvince() {
		return Province;
	}
	public void setProvince(String province) {
		Province = province;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getStreet() {
		return Street;
	}
	public void setStreet(String street) {
		Street = street;
	}
	public String getHomeNumber() {
		return HomeNumber;
	}
	public void setHomeNumber(String homeNumber) {
		HomeNumber = homeNumber;
	}
	public void setUser(AppUser user) {
		this.user = user;
	}
	
}









