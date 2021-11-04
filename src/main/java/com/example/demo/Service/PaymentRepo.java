package com.example.demo.Service;



import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.UserAccount.Payment;

public interface PaymentRepo extends JpaRepository<Payment, Integer>{
	@Query(value="SELECT * FROM payment WHERE User_ID = :User_Id",nativeQuery=true)
	public Payment getPaymentByUserID(int User_Id);
	@Modifying
	@Query(value="DELETE FROM payment WHERE User_ID = :User_Id",nativeQuery=true)
	@Transactional
	public void DeletePaymentByUserID(int User_Id);
}



