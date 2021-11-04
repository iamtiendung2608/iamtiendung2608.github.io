package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.database.ListBuy;
import com.example.demo.database.source;

@Service("ListBuy")
public class ListBuyService {
	@Autowired
	private ListBuyRepo repo;
	private sourceRepo sourceRepo;
	
	public ListBuyService(ListBuyRepo repo, com.example.demo.Service.sourceRepo sourceRepo) {
		super();
		this.repo = repo;
		this.sourceRepo = sourceRepo;
	}
	public ListBuy getListBuy(int id) {
		return repo.findById(id).orElse(null);
	}
	//TODO: Write query to find list buy by userID
	public void saveToCart(int Userid, source Items, int ItemsId) {
		ListBuy userList=repo.findListBuybyUserId(Userid);
		userList.setItemsBuied(ItemsId);
		repo.save(userList);
	}
	public List<source> getAllItemsCart(int userId) {
		List<source>result=new ArrayList<>();
		ListBuy userList=repo.findListBuybyUserId(userId);
		String[]Items=userList.getItemsBuied().split(" ");
		for(String i:Items) {
			source SourceItems=sourceRepo.findById(Integer.parseInt(i)).orElse(null);
			SourceItems.setBuiled();
			SourceItems.setTotal();
			if(result.contains(SourceItems)) {
				SourceItems.setBuiled();
				SourceItems.setTotal();
				result.remove(SourceItems);
				result.add(SourceItems);
			}
			else
				result.add(SourceItems);
		}
		return result;
	}
	public List<source>getAllItems(String name){
		return sourceRepo.findAllItemsbyBrand(name);
	}
	public boolean CheckGroup(int Userid) {
		return repo.findListBuybyUserId(Userid).getGroupID()==Userid
				||repo.findListBuybyUserId(Userid).getGroupID()==0;
	}
	public void CreateGroup(int GroupID,int UserID) {
		repo.setGroupIDByUser_Id(GroupID, UserID);
	}
}





