package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Service.ListBuyService;
import com.example.demo.UserAccount.AppUser;
import com.example.demo.database.source;

@Controller
public class CartController {
	private AppUser user;
	@Autowired
	private ListBuyService repo;
	@RequestMapping("/cart")
	private String getCart(Model model) {
		user= (AppUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<source>result=repo.getAllItemsCart(user.getId());
		model.addAttribute("Cart", result);
		return "Cart";
	}
}



