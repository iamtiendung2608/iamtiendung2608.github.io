package com.example.demo.Service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.database.ListBuy;

public interface ListBuyRepo extends JpaRepository<ListBuy,Integer> {
	
}
