package com.example.demo.database;

import javax.persistence.Entity;

@Entity
public class Earphone extends source{
	private int Drivers;
	private long HZ;
	private String Material;
	public Earphone(int drivers, long connected, String material) {
		Drivers = drivers;
		HZ = connected;
		Material = material;
	}
	public Earphone() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Earphone(String type, long price) {
		super(type, price);
		// TODO Auto-generated constructor stub
	}
	public Earphone(String name, String source) {
		super(name, source);
		// TODO Auto-generated constructor stub
	}
	public int getDrivers() {
		return Drivers;
	}
	public void setDrivers(int drivers) {
		Drivers = drivers;
	}
	public long getConnected() {
		return HZ;
	}
	public void setConnected(long connected) {
		HZ = connected;
	}
	public String getMaterial() {
		return Material;
	}
	public void setMaterial(String material) {
		Material = material;
	}
}
