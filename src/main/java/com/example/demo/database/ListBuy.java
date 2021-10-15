package com.example.demo.database;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.example.demo.UserAccount.AppUser;

@Entity
public class ListBuy {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ID;
	@OneToOne
	@JoinColumn(name="User_ID", referencedColumnName="User_id")
	private AppUser user;
	@OneToMany(
			cascade=CascadeType.ALL,
			orphanRemoval=true
			)
	@JoinColumn(name="List_ID")
	private List<source>ListItems=new ArrayList<>();
	private String ItemsBuied="";
	public ListBuy() {
		super();
	}
	public ListBuy(String itemsBuied) {
		super();
		ItemsBuied = itemsBuied;
	}
	public void setListItems(source Items) {
		this.ListItems.add(Items);
	}
	public List<source> getListItems() {
		return ListItems;
	}
	public void setUser(AppUser user) {
		this.user = user;
	}
	public String getItemsBuied() {
		return ItemsBuied;
	}
	public void setItemsBuied(int itemsBuied) {
		ItemsBuied += itemsBuied+" ";
	}

}





