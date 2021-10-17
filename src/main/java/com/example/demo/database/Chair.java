package com.example.demo.database;

import javax.persistence.Entity;

@Entity
public class Chair extends source{
	private int standAngle;
	private int lyingAngle;
	private int Weigh;
	public Chair(int standAngle, int lyingAngle, int weigh) {
		this.standAngle = standAngle;
		this.lyingAngle = lyingAngle;
		Weigh = weigh;
	}
	public Chair() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Chair(String type, long price) {
		super(type, price);
		// TODO Auto-generated constructor stub
	}
	public Chair(String name, String source) {
		super(name, source);
		// TODO Auto-generated constructor stub
	}
	public int getStandAngle() {
		return standAngle;
	}
	public void setStandAngle(int standAngle) {
		this.standAngle = standAngle;
	}
	public int getLyingAngle() {
		return lyingAngle;
	}
	public void setLyingAngle(int lyingAngle) {
		this.lyingAngle = lyingAngle;
	}
	public int getWeigh() {
		return Weigh;
	}
	public void setWeigh(int weigh) {
		Weigh = weigh;
	}
	
}
