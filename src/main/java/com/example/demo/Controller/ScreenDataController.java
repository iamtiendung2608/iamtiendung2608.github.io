package com.example.demo.Controller;

import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Service.ListBuyRepo;
import com.example.demo.Service.ScreenRepo;
import com.example.demo.UserAccount.AppUser;
import com.example.demo.database.ListBuy;
import com.example.demo.database.Screen;

@Controller
public class ScreenDataController {
	private ScreenRepo repo;
	private ListBuyRepo ListRepo;
	private AppUser user;
	public ScreenDataController(ScreenRepo repo, ListBuyRepo listRepo) {
		super();
		this.repo = repo;
		ListRepo = listRepo;
	}
	List<Screen>allScreen=Screen.getItemsSource();
	@RequestMapping("/screen")
	public String ScreenHome(Model model) {
		repo.saveAll(allScreen);
		model.addAttribute("screen", allScreen);
		return "Screen-Items";
	}
	@RequestMapping("/screen/{id}")
	public String ScreenDetails(Model model,@PathVariable("id")int id) {
		Screen K=(Screen) repo.findById(id).orElse(null);
		model.addAttribute("screen", K);
		return "Screen-Details";
	}
	@PostMapping("/screen/{id}")
	public String AddScreen(@PathVariable("id")int id,Model model) {
		user= (AppUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Screen screen=(Screen) repo.findById(id).orElse(null);
		ListBuy userList=ListRepo.findById(user.getId()).orElse(null);
		userList.setListItems(screen);
		userList.setItemsBuied(id);
		screen.setBuiled();
		screen.setTotal();
		ListRepo.save(userList);
		model.addAttribute("screen", screen);
		return "Screen-Details";
	}
}






