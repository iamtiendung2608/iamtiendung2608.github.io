package com.example.demo.GroupOrder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Service.ListBuyService;
import com.example.demo.UserAccount.AppUser;


@Controller
public class GroupOrderController {
	@Autowired
	private ListBuyService ListService;
	private AppUser user;
	//TODO: take a group ID and Create Group
	@RequestMapping("/group/join")
	public String InputCode() {
		user= (AppUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(!ListService.CheckGroup(user.getId())) {
			return "Group-Have";
		}
		return "InputCode";
	}    
	@PostMapping("/group/join")
	public String AddCode(@RequestParam("ID") int ID) {
		user= (AppUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		ListService.CreateGroup(ID, user.getId());
		return "redirect:/shop";
	}
	@RequestMapping("/group/token")
	public String GenerateToken(Model model) {
		user= (AppUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("token", user.getId());
		ListService.CreateGroup(user.getId(), user.getId());
		return "Generate-Token";
	}
	//TODO: Group Cart if Group exit	
	@RequestMapping("/group/cart")
	public String GroupCart() {
		user= (AppUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return "redirect:/shop";
	}
}








