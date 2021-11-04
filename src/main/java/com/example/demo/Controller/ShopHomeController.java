package com.example.demo.Controller;

import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.UserAccount.AppUser;
import com.example.demo.database.Brand;


@Controller
public class ShopHomeController {
	List<Brand>allBrand=Brand.getItemsSource();
	
	@RequestMapping("/shop")
	public String HomePage(Model model) {
		//model.addAttribute("Group", user);
		return "Shop";
	}
	@RequestMapping("/")
	public String Intro(Model model) {
		System.out.println(allBrand.get(0));
		model.addAttribute("Brand", allBrand);
		return "Intro";
	}
}
