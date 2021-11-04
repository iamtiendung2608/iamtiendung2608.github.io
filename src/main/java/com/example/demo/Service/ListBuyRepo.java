package com.example.demo.Service;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.database.ListBuy;

public interface ListBuyRepo extends JpaRepository<ListBuy,Integer> {
	@Query(value="SELECT * FROM ListBuy WHERE User_ID = :User_Id", nativeQuery=true)
	public ListBuy findListBuybyUserId(int User_Id);
	@Modifying
	@Query(value="UPDATE ListBuy "
			+ "SET GroupID = :Group_Id "
			+ "WHERE User_ID = :User_Id")
	@Transactional
	public void setGroupIDByUser_Id(int Group_Id, int User_Id);
}
