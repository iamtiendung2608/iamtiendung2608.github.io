package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.Service.ChairService;
import com.example.demo.Service.ListBuyService;
import com.example.demo.UserAccount.AppUser;
import com.example.demo.database.Chair;

@Controller
public class ChairDataController {
	@Autowired
	private ChairService repo; 
	@Autowired
	private ListBuyService ListService;
	private AppUser user;
	@RequestMapping("/chair")
	public String ChairHome(Model model) {
		//repo.SaveListChair(allChair);
		model.addAttribute("chair", repo.getFromService());
		return "Chair-Items";
	}
	@RequestMapping("/chair/{id}")
	public String ChairDetails(@PathVariable("id")int id, Model model) {
		model.addAttribute("chair", repo.getChair(id));
		return "Chair-Details";
	}
	@PostMapping("/chair/{id}")
	public String AddChair(@PathVariable("id")int id) {
		user = (AppUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Chair chair=repo.getChair(id);
		ListService.saveToCart(user.getId(), chair ,id);
		return "redirect:/chair/{id}";
	}
}






