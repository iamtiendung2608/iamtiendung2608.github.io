package com.example.demo.UserAccount;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
@Table(name="payment")
@Entity(name="payment")
public class Payment {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ID;
	@CreditCardNumber(message="Not a valid credit card number")
	private String CardNumber;
	@Length(min=5,max=14)
	private String PhoneNumber;
	@Min(value=2022)
	private int ccYear;
	@Range(min=1,max=12)
	private int ccMonth;
	@Length(min = 1, max = 3)
	private String ZipCode;
	@OneToOne
	@JoinColumn(name="User_ID", referencedColumnName="User_id")
	private AppUser user;
	public Payment(@CreditCardNumber(message = "Not a valid credit card number") String cardNumber,
			@Length(min = 5, max = 10) String phoneNumber, @Min(2022) int ccYear, @Range(min = 1, max = 12) int ccMonth,
			@Length(min = 1, max = 3) String zipCode) {
		super();
		CardNumber = cardNumber;
		PhoneNumber = phoneNumber;
		this.ccYear = ccYear;
		this.ccMonth = ccMonth;
		ZipCode = zipCode;
	}
	public String getCardNumber() {
		return CardNumber;
	}
	public void setCardNumber(String cardNumber) {
		CardNumber = cardNumber;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public int getCcYear() {
		return ccYear;
	}
	public void setCcYear(int ccYear) {
		this.ccYear = ccYear;
	}
	public int getCcMonth() {
		return ccMonth;
	}
	public void setCcMonth(int ccMonth) {
		this.ccMonth = ccMonth;
	}
	public String getZipCode() {
		return ZipCode;
	}
	public void setZipCode(String zipCode) {
		ZipCode = zipCode;
	}
	public void setUser(AppUser user) {
		this.user = user;
	}
	public Payment() {
		super();
	}
	@Override
	public String toString() {
		return "Payment [CardNumber=" + CardNumber + ", PhoneNumber=" + PhoneNumber + ", ccYear=" + ccYear
				+ ", ccMonth=" + ccMonth + ", ZipCode=" + ZipCode + "]";
	}
	
}
