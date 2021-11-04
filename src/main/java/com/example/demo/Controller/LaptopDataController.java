package com.example.demo.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Service.LaptopService;

import com.example.demo.Service.ListBuyService;
import com.example.demo.UserAccount.AppUser;
import com.example.demo.database.Laptop;


@Controller
public class LaptopDataController {
	@Autowired
	private LaptopService lapService;
	@Autowired
	private ListBuyService ListService;
	private AppUser user;
	@RequestMapping("/laptop")
	public String LaptopHome(Model model) {
		//lapService.SaveListLaptop(allLaptop);
		model.addAttribute("laptop", lapService.getFromService());
		return "Laptop-Items";
	}
	@RequestMapping("/laptop/{id}")
	public String LaptopDetails(Model model,@PathVariable("id")int id) {
		model.addAttribute("laptop", lapService.getLaptop(id));
		return "Laptop-Details";
	}
	@PostMapping("/laptop/{id}")
	public String AddLaptop(@PathVariable("id")int id) {
		user = (AppUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Laptop mylap=lapService.getLaptop(id);
		ListService.saveToCart(user.getId(), mylap,id);
		return "redirect:/laptop/{id}";
	}
	
}
