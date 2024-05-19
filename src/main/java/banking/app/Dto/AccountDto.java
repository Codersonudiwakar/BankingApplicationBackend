package banking.app.Dto;

import banking.app.entity.Address;
import banking.app.entity.Card;
import banking.app.entity.User;
import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

public class AccountDto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long formNo;
	private String fullName;
	private String dob;
	private String fatherName;
	private String aadhaarNo;
	private String panNo;
	private String phoneNo;
	private String email;
	private String password;
	private String accountNumber;
	private AddressDto addressDto;
	private UsersDto userDto;
	private CardDto cardDto;
	
	public AccountDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getFormNo() {
		return formNo;
	}
	public void setFormNo(long formNo) {
		this.formNo = formNo;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getAadhaarNo() {
		return aadhaarNo;
	}
	public void setAadhaarNo(String aadhaarNo) {
		this.aadhaarNo = aadhaarNo;
	}
	public String getPanNo() {
		return panNo;
	}
	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public AddressDto getAddressDto() {
		return addressDto;
	}
	public void setAddressDto(AddressDto addressDto) {
		this.addressDto = addressDto;
	}
	public UsersDto getUserDto() {
		return userDto;
	}
	public void setUserDto(UsersDto userDto) {
		this.userDto = userDto;
	}
	public CardDto getCardDto() {
		return cardDto;
	}
	public void setCardDto(CardDto cardDto) {
		this.cardDto = cardDto;
	}
		 
}
