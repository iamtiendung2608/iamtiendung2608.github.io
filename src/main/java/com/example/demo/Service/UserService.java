package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.UserAccount.AppUser;
import com.example.demo.database.ListBuy;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class UserService implements UserDetailsService{
	
	private UserRepo repo;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	private ListBuyRepo ListRepo;
	public UserService(UserRepo repo, BCryptPasswordEncoder bCryptPasswordEncoder, ListBuyRepo listRepo) {
		super();
		this.repo = repo;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		ListRepo = listRepo;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return repo.findByUsername(username).orElseThrow(()->new 
				UsernameNotFoundException("Username not found"));
	}

	public String signUpUser(AppUser appUser) {
		// TODO Auto-generated method stub
		boolean userExists=repo.findByUsername(appUser.getName()).isPresent();
		if(userExists)
			throw new IllegalStateException("Account already taken!");
		String encodedPassword= bCryptPasswordEncoder.encode(appUser.getPassword());
		appUser.setPassword(encodedPassword);
		if(appUser.getPassword()==null)
			throw new IllegalStateException("Password mustn't be null");
		repo.save(appUser);
		ListBuy userBuy=new ListBuy();
		userBuy.setUser(appUser);
		ListRepo.save(userBuy);
		return "redirect:/login";
	}
}
