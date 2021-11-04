package com.example.demo.Security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.Service.UserService;

import lombok.AllArgsConstructor;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	private UserService userService;
	public SecurityConfig(BCryptPasswordEncoder bCryptPasswordEncoder, UserService userService) {
		super();
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.userService = userService;
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
			.csrf().disable()
			.authorizeRequests()
			.antMatchers("/h2-console/**").permitAll()
			.antMatchers("/registration").permitAll()
			.antMatchers("/images/**").permitAll()
			.antMatchers("/css/**").permitAll()
			.antMatchers("/js/**").permitAll()
			.antMatchers("/").permitAll()
				.anyRequest().authenticated()
			.and()
			.formLogin()
				.loginPage("/login").permitAll()
				.defaultSuccessUrl("/shop");
		http.headers().frameOptions().disable();
	}
	@Override 
	protected void configure(AuthenticationManagerBuilder auth)throws Exception{
		auth
			.userDetailsService(userService)
			.passwordEncoder(bCryptPasswordEncoder);
	}
	
}






