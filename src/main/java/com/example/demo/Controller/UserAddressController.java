package com.example.demo.Controller;

import javax.validation.Valid;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
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
	public String Address(@ModelAttribute("address")Address address) {
		user = (AppUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Address userAdress=repo.findAddressByUserID(user.getId());
		if(userAdress!=null)
			return "payment-have";
		return "address";
	}
	@PostMapping("/address")
	public String CheckAddress(@Valid@ModelAttribute("address")Address address,
			BindingResult BR) {
		if(BR.hasErrors())
			return "address";
		user = (AppUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		address.setUser(user);
		repo.save(address);
		return "redirect:/shop";
	}
}


