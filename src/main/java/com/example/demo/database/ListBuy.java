package com.example.demo.database;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.example.demo.UserAccount.AppUser;

@Entity
@Table(name="LISTBUY")
public class ListBuy {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ID;
	@OneToOne
	@JoinColumn(name="User_ID", referencedColumnName="User_id")
	private AppUser user;
	private String ItemsBuied="";
	private int GroupID;
	private String ListGroupOrder="";
	public ListBuy() {
		super();
	}
	public ListBuy(String itemsBuied) {
		super();
		ItemsBuied = itemsBuied;
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
	public int getGroupID() {
		return GroupID;
	}
	public String getListGroupOrder() {
		return ListGroupOrder;
	}
	public void setListGroupOrder(String listGroupOrder) {
		ListGroupOrder = listGroupOrder;
	}
	public void setGroupID(int groupID) {
		GroupID = groupID;
	}
	public int getID() {
		return ID;
	}
}





