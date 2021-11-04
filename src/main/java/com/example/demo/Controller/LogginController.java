package com.example.demo.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


import com.example.demo.Service.ChairService;
import com.example.demo.Service.LaptopService;
import com.example.demo.Service.ScreenService;

@Controller
public class LogginController {
	@Autowired
	private ChairService chairService; 
	@Autowired
	private LaptopService lapService;
	@Autowired
	private ScreenService screenService;
	@GetMapping("/login")
	public String loggin() {
		chairService.SaveListChair();
		lapService.SaveListLaptop();
		screenService.SaveListScreen();
		return "login-page";
	}
	
}





