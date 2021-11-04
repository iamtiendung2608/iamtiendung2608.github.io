package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.database.Laptop;
import com.example.demo.database.Screen;
import com.example.demo.database.source;

@Service("ScreenService")
public class ScreenService {
	List<Screen>allScreen=Screen.getItemsSource();
	@Autowired
	private ScreenRepo repo;
	public Screen getScreen(int id) {
		return (Screen)repo.findById(id).orElse(null);
	}
	public void SaveListScreen() {
		repo.saveAll(allScreen);
	}
	public List<Screen>getFromService(){
		return allScreen;
	}
}




