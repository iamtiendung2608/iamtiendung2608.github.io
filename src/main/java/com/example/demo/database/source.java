package com.example.demo.database;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class source {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ID;
	public String Name;
	public String Source;
	private String Type;
	private long Price;
	private int Builed;
	private long Total;
	public source() {
		super();
	}

	public source(String type, long price) {
		super();
		Type = type;
		Price = price;
		Builed=0;
		Total=0;
	}
	public int getID() {
		return ID;
	}

	public source(String name, String source) {
		super();
		Name = name;
		Source = source;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getSource() {
		return Source;
	}
	public void setSource(String source) {
		Source = source;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public long getPrice() {
		return Price;
	}
	public void setPrice(long price) {
		Price = price;
	}
	public int getBuiled() {
		return Builed;
	}
	public void setBuiled() {
		Builed++;
	}
	public long getTotal() {
		return Total;
	}
	public void setTotal() {
		Total = this.Builed*this.Price;
	}

	@Override
	public String toString() {
		return "source [ID=" + ID + ", Name=" + Name + ", Source=" + Source + ", Type=" + Type + ", Price=" + Price
				+ ", Builed=" + Builed + ", Total=" + Total + "]";
	}
	

}





