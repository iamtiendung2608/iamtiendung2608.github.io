package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogginController {
	@GetMapping("/login")
	public String loggin() {
		return "login-page";
	}
	@RequestMapping("/success")
	public String success() {
		return "success";
	}
}
