package com.example.demo.Service;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.UserAccount.Payment;

public interface PaymentRepo extends JpaRepository<Payment, Integer>{
	@Query(value="SELECT * FROM payment WHERE User_ID = :User_Id",nativeQuery=true)
	public Payment getPaymentByUserID(int User_Id);
}



