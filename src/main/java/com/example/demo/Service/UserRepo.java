package com.example.demo.Service;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.UserAccount.AppUser;

public interface UserRepo extends JpaRepository<AppUser,Integer> {
	Optional<AppUser> findByUsername(String username);
}
