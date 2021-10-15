package com.example.demo.Controller;


import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.example.demo.UserAccount.AppUser;

@Controller
public class RegistController {
	private RequestRegist requestRegist;
	public RegistController(RequestRegist requestRegist) {
		super();
		this.requestRegist = requestRegist;
	}
	@RequestMapping("/registration")
	public String regist(@ModelAttribute("user") AppUser user) {
		return "regist";
	}
	@PostMapping("/registration")
	public String registration(@Valid@ModelAttribute("user") AppUser user
			,BindingResult BR) {
		if(BR.hasErrors())
			return "regist";
		return requestRegist.regist(user);
	}
	
}





