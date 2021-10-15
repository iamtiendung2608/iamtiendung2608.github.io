package com.example.demo.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.database.Brand;

@Controller
public class ShopHomeController {
	List<Brand>allBrand=Brand.getItemsSource();
	@RequestMapping("/shop")
	public String HomePage(Model model) {
		model.addAttribute("Brand", allBrand);
		return "Shop";
	}
}
