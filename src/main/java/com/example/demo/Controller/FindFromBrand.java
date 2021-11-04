package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Service.ListBuyService;
import com.example.demo.database.source;



@Controller
public class FindFromBrand {
	@Autowired
	private ListBuyService repo;
	@RequestMapping("/find/{brand}")
	public String StringFindAllBrand(@PathVariable("brand")String Brand,Model model) {
		List<source>result=repo.getAllItems(Brand);
		model.addAttribute("Brand", result);
		return "Searching-Page";
	}
}




