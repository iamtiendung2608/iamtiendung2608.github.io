package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.database.ListBuy;
import com.example.demo.database.source;

@Service("ListBuy")
public class ListBuyService {
	@Autowired
	private ListBuyRepo repo;
	public ListBuy getListBuy(int id) {
		return (ListBuy)repo.findById(id).orElse(null);
	}
	public void saveToCart(int id, source Items) {
		ListBuy userList=repo.findById(id).orElse(null);
		userList.setListItems(Items);
		userList.setItemsBuied(id);
		Items.setBuiled();
		Items.setTotal();
		repo.save(userList);
	}
}
