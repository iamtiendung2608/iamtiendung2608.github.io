package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.database.Screen;

@Service("ScreenService")
public class ScreenService {
	@Autowired
	private ScreenRepo repo;
	public Screen getScreen(int id) {
		return (Screen)repo.findById(id).orElse(null);
	}
	public void SaveListScreen(List<Screen>list) {
		repo.saveAll(list);
	}
}




