package com.example.demo.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.database.Chair;
@Service
public class ChairService {
	List<Chair>allChair=Chair.getItemsSource();
	@Autowired
	private ChairRepo repo;
	public Chair getChair(int id) {
		return (Chair) repo.findById(id).orElse(null);
	}
	public void SaveListChair() {
		repo.saveAll(allChair);
	}
	public  List<Chair>getFromService(){
		return allChair;
	}
}
