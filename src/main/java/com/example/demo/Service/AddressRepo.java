package com.example.demo.Service;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.UserAccount.Address;

public interface AddressRepo extends JpaRepository<Address,Integer> {
	@Query(value="SELECT * FROM Address WHERE User_ID = :User_Id",nativeQuery=true)
	public Address findAddressByUserID(int User_Id);
	@Modifying
	@Query(value="DELETE FROM Address WHERE User_ID = :User_Id")
	@Transactional
	public void deleteAdressByUserID(int User_Id);
}
