package com.example.demo.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Service.PaymentRepo;
import com.example.demo.UserAccount.AppUser;
import com.example.demo.UserAccount.Payment;

@Controller
public class PaymentController {
	private AppUser user;
	@Autowired
	PaymentRepo repo;
	@RequestMapping("/payment")
	public String payment(@ModelAttribute("payment") Payment payment,
			Model model) {
		user = (AppUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Payment K=repo.getPaymentByUserID(user.getId());
		if(K!=null) {
			model.addAttribute("payment", K);
			return "payment-have";
		}
		return "payment";
	}
	@PostMapping("/payment")
	public String CheckPayment(@Valid @ModelAttribute("payment")Payment payment
			,BindingResult BR) {
		if(BR.hasErrors())
			return "payment";
		payment.setUser(user);
		repo.save(payment);
		return "redirect:/shop";
	}
	@RequestMapping("/change/payment")
	public String ChangePayment() {
		repo.DeletePaymentByUserID(user.getId());
		return "redirect:/payment";
	}
}




