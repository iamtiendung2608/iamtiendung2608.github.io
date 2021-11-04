package com.example.demo.Service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.database.Laptop;

@Service("LaptopService")

public class LaptopService {
	List<Laptop>allLaptop=Laptop.getItemsSource();
	@Autowired
	private LaptopRepo repo;
	public Laptop getLaptop(int id) {
		return (Laptop) repo.findById(id).orElse(null);
	}
	public void SaveListLaptop() {
		repo.saveAll(allLaptop);
	}
	public List<Laptop>getFromService(){
		return allLaptop;
	}
}




