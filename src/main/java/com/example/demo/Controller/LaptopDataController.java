package com.example.demo.Controller;

import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Service.LaptopRepo;
import com.example.demo.Service.ListBuyRepo;
import com.example.demo.UserAccount.AppUser;
import com.example.demo.database.Laptop;
import com.example.demo.database.ListBuy;

@Controller
public class LaptopDataController {
	List<Laptop>allLaptop=Laptop.getItemsSource();
	private LaptopRepo repo;
	private ListBuyRepo ListRepo;
	private AppUser user;
	public LaptopDataController(LaptopRepo repo, ListBuyRepo listRepo) {
		super();
		this.repo = repo;
		ListRepo = listRepo;
	}
	@RequestMapping("/laptop")
	public String LaptopHome(Model model) {
		repo.saveAll(allLaptop);
		model.addAttribute("laptop", allLaptop);
		return "Laptop-Items";
	}
	@RequestMapping("/laptop/{id}")
	public String LaptopDetails(Model model,@PathVariable("id")int id) {
		Laptop K=(Laptop) repo.findById(id).orElse(null);
		model.addAttribute("laptop", K);
		return "Laptop-Details";
	}
	@PostMapping("/laptop/{id}")
	public String AddLaptop(@PathVariable("id")int id,Model model) {
		user = (AppUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Laptop mylap=(Laptop) repo.findById(id).orElse(null);
		ListBuy userList=ListRepo.findById(user.getId()).orElse(null);
		userList.setListItems(mylap);
		userList.setItemsBuied(id);
		mylap.setBuiled();
		mylap.setTotal();
		ListRepo.save(userList);
		model.addAttribute("laptop", mylap);
		return "Laptop-Details";
	}
}
