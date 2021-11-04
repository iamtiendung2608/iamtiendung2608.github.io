package com.example.demo.Controller;

import javax.validation.Valid;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Service.AddressRepo;
import com.example.demo.UserAccount.Address;
import com.example.demo.UserAccount.AppUser;
@Controller
public class UserAddressController {
	private AppUser user;
	private AddressRepo repo;
	public UserAddressController(AddressRepo repo) {
		super();
		this.repo = repo;
	}
	@RequestMapping("/address")
	public String Address(@ModelAttribute("address")Address address
			,Model model) {
		user = (AppUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Address userAdress=repo.findAddressByUserID(user.getId());
		if(userAdress!=null) {
			model.addAttribute("address", userAdress);
			return "address-have";
		}
		return "address";
	}
	@PostMapping("/address")
	public String CheckAddress(@Valid@ModelAttribute("address")Address address,
			BindingResult BR) {
		if(BR.hasErrors())
			return "address";
		address.setUser(user);
		repo.save(address);
		return "redirect:/shop";
	}
	@RequestMapping("/change/address")
	public String ChangeAddress() {
		repo.deleteAdressByUserID(user.getId());
		return "redirect:/address";
	}
}


