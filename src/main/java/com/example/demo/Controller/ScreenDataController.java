package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.example.demo.Service.ListBuyService;
import com.example.demo.Service.ScreenService;
import com.example.demo.UserAccount.AppUser;

import com.example.demo.database.Screen;

@Controller
public class ScreenDataController {
	@Autowired
	private ScreenService repo;
	@Autowired
	private ListBuyService ListService;
	private AppUser user;

	List<Screen>allScreen=Screen.getItemsSource();
	@RequestMapping("/screen")
	public String ScreenHome(Model model) {
		repo.SaveListScreen(allScreen);
		model.addAttribute("screen", allScreen);
		return "Screen-Items";
	}
	@RequestMapping("/screen/{id}")
	public String ScreenDetails(Model model,@PathVariable("id")int id) {
		model.addAttribute("screen", repo.getScreen(id));
		return "Screen-Details";
	}
	@PostMapping("/screen/{id}")
	public String AddScreen(@PathVariable("id")int id,Model model) {
		user= (AppUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Screen screen=repo.getScreen(id);
		ListService.saveToCart(user.getId(), screen);
		model.addAttribute("screen", screen);
		return "Screen-Details";
	}
}






